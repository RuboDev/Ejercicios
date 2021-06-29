package rubensockets;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
	}
}

class LaminaMarcoCliente extends JPanel {
	private JTextField campo1, nick, ip;
	private JButton miboton;
	private JTextArea campochat;

	public LaminaMarcoCliente() {
		nick = new JTextField(5);
		add(nick);

		JLabel texto = new JLabel("-CHAT-");
		add(texto);

		ip = new JTextField(9);
		add(ip);

		campochat = new JTextArea(12, 20);
		add(campochat);

		campo1 = new JTextField(20);
		add(campo1);

		miboton = new JButton("Enviar");
		EnviaTexto oyenteBotonEnviar = new EnviaTexto();
		miboton.addActionListener(oyenteBotonEnviar);
		add(miboton);
	}

	private class EnviaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(campo1.getText());

			try {
				Socket misocket = new Socket("", 9999);
				PaqueteEnvio datos = new PaqueteEnvio();
				datos.setNick(nick.getText());
				datos.setIp(ip.getText());
				datos.setMensaje(campo1.getText());

				ObjectOutputStream flujo_objetos = new ObjectOutputStream(misocket.getOutputStream());
				flujo_objetos.writeObject(datos);
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