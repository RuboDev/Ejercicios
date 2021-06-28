package rubensockets;

import javax.swing.*;

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
	private JTextField campo1;
	private JButton miboton;

	public LaminaMarcoCliente() {
		JLabel texto = new JLabel("CLIENTE");
		add(texto);

		campo1 = new JTextField(20);
		add(campo1);

		miboton = new JButton("Enviar");
		add(miboton);
	}
}