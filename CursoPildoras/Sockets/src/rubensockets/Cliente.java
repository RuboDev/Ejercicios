package rubensockets;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) {
		MarcoCliente mimarco = new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoCliente extends JFrame {
	public MarcoCliente() {
		setBounds(600, 300, 280, 350);

		LaminaMarcoCliente milamina = new LaminaMarcoCliente();
		add(milamina);

		setVisible(true);
		addWindowListener(new UserOnlineEnvio());
	}
}

// -----------ENVIO SEÑAL ONLINE----------------------
class UserOnlineEnvio extends WindowAdapter {
	public void windowOpened(WindowEvent e) {
		try {
			Socket socketUserOn = new Socket("", 9999);
			PaqueteEnvio datosUserOn = new PaqueteEnvio();
			// datosUserOn.setIp(socketUserOn.getInetAddress().getHostAddress());
			// datosUserOn.setNick();
			datosUserOn.setMensaje("Online");
			ObjectOutputStream flujo_salida = new ObjectOutputStream(socketUserOn.getOutputStream());
			flujo_salida.writeObject(datosUserOn);
			socketUserOn.close();
		} catch (Exception e2) {
			e2.getStackTrace();
		}
	}
}
// --------------------------------------------------

class LaminaMarcoCliente extends JPanel implements Runnable {
	private JTextField campo1;
	private JComboBox<String> ip;
	private JLabel nick, n_nick;
	private JButton miboton;
	private JTextArea campochat;

	public LaminaMarcoCliente() {
		String strnick = JOptionPane.showInputDialog("Introduzca su nick");

		n_nick = new JLabel("Nick: ");
		add(n_nick);

		nick = new JLabel(strnick);
		add(nick);

		JLabel texto = new JLabel("Online: ");
		add(texto);

		ip = new JComboBox<String>();
		ip.addItem("Usuario 1");
		ip.addItem("Usuario 2");
		ip.addItem("Usuario 3");
		add(ip);

		campochat = new JTextArea(12, 20);
		add(campochat);

		campo1 = new JTextField(20);
		add(campo1);

		miboton = new JButton("Enviar");
		EnviaTexto oyenteBotonEnviar = new EnviaTexto();
		miboton.addActionListener(oyenteBotonEnviar);
		add(miboton);

		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		System.out.println("Estoy a la escucha");

		try {
			String nick, ip, mensaje;
			PaqueteEnvio paquete_recibido;

			while (true) {
				ServerSocket servidor = new ServerSocket(9090);
				Socket misocket = servidor.accept();

				ObjectInputStream flujo_entrada = new ObjectInputStream(misocket.getInputStream());
				paquete_recibido = (PaqueteEnvio) flujo_entrada.readObject();

				nick = paquete_recibido.getNick();
				ip = paquete_recibido.getIp();
				mensaje = paquete_recibido.getMensaje();

				campochat.append("\n" + nick + ": " + mensaje);

				flujo_entrada.close();
				misocket.close();
				servidor.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private class EnviaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println(campo1.getText());
			campochat.append("\n" + "Tú: " + campo1.getText());

			try {
				Socket misocket = new Socket("", 9999);
				PaqueteEnvio datos = new PaqueteEnvio();
				datos.setNick(nick.getText());
				datos.setIp((String) ip.getSelectedItem());
				datos.setMensaje(campo1.getText());

				ObjectOutputStream flujo_objetos = new ObjectOutputStream(misocket.getOutputStream());
				flujo_objetos.writeObject(datos);

				flujo_objetos.close();
				misocket.close();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}

	}
}

class PaqueteEnvio implements Serializable {
	private String nick, ip, mensaje;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}