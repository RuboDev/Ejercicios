import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.DuplicateFormatFlagsException;

public class PruebaTexto {
    public static void main(String[] args) {
        MarcoTexto marco = new MarcoTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoTexto extends JFrame {
    public MarcoTexto() {
        setTitle("Prueba Texto");
        setBounds(600, 300, 600, 350);
        LaminaTexto lamina = new LaminaTexto();
        add(lamina);
        setVisible(true);
    }
}

class LaminaTexto extends JPanel {

    private JTextField campo1;
    private JLabel resultado;

    public LaminaTexto() {
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        JLabel texto1 = new JLabel("Email: ");
        panelSuperior.add(texto1);

        campo1 = new JTextField(20);
        panelSuperior.add(campo1);

        JButton boton = new JButton("Comprobar");
        DameTexto miOyente = new DameTexto();
        boton.addActionListener(miOyente);
        panelSuperior.add(boton);

        add(panelSuperior, BorderLayout.NORTH);

        resultado = new JLabel("", JLabel.CENTER);
        add(resultado, BorderLayout.CENTER);
    }

    private class DameTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int correcto = 0;
            String email = campo1.getText().trim();

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    correcto++;
                }
            }

            if (correcto != 1) {
                resultado.setText("email Incorrecto");
            } else {
                resultado.setText("email Correcto");
            }
            System.out.println(campo1.getText());
        }
    }
}
