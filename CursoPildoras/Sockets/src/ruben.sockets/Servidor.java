import javax.swing.*;
import java.awt.*;

public class Servidor {
	public static void main(String[] args) {
		MarcoServidor mimarco = new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoServidor extends JFrame {
	private JTextArea areatexto;

	public MarcoServidor() {
		setBounds(1200, 300, 280, 350);

		JPanel milamina = new JPanel();
		milamina.setLayout(new BorderLayout());
		areatexto = new JTextArea();
		milamina.add(areatexto, BorderLayout.CENTER);
		add(milamina);

		setVisible(true);
	}
}
