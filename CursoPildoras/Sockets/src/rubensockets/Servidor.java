package rubensockets;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		MarcoServidor mimarco = new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoServidor extends JFrame implements Runnable {
	private JTextArea areatexto;

	public MarcoServidor() {
		setBounds(1200, 300, 280, 350);

		JPanel milamina = new JPanel();
		milamina.setLayout(new BorderLayout());
		areatexto = new JTextArea();
		milamina.add(areatexto, BorderLayout.CENTER);
		add(milamina);

		setVisible(true);

		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {

		try {
			String nick, ip, mensaje;
			PaqueteEnvio paquete_recibido;

			while (true) {
				ServerSocket servidor = new ServerSocket(9999);
				Socket misocket = servidor.accept();

				ObjectInputStream flujo_entrada = new ObjectInputStream(misocket.getInputStream());
				paquete_recibido = (PaqueteEnvio) flujo_entrada.readObject();

				nick = paquete_recibido.getNick();
				ip = paquete_recibido.getIp();
				mensaje = paquete_recibido.getMensaje();

				if (!mensaje.equals("Online")) {
					areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);

					Socket enviaDestinatario = new Socket(ip, 9090);
					ObjectOutputStream flujo_salida = new ObjectOutputStream(enviaDestinatario.getOutputStream());
					flujo_salida.writeObject(paquete_recibido);

					flujo_salida.close();
					enviaDestinatario.close();

				} else {
					// -----------DETECTA USUARIOS ONLINE------------------------------
					InetAddress direccion = misocket.getInetAddress();
					String ipClientOn = direccion.getHostAddress();
					System.out.println("Online: " + ipClientOn);
					// ----------------------------------------------------------------
				}
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
}
