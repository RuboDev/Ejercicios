import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class CampoPassword {
    public static void main(String[] args) {
        MarcoPassword marco = new MarcoPassword();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoPassword extends JFrame {
    public MarcoPassword() {
        setTitle("Comprobando Password");
        setBounds(400, 300, 550, 400);
        LaminaPassword lamina = new LaminaPassword();
        add(lamina);
        setVisible(true);
    }
}

class LaminaPassword extends JPanel {

    // Color rojoTrans = new Color(255, 0, 0, 15);
    // Color blancoTrans = new Color(255, 255, 255, 15);
    JPasswordField passIn;

    public LaminaPassword() {
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        JLabel userEtiqueta = new JLabel("Usuario: ", JLabel.CENTER);
        JLabel passEtiqueta = new JLabel("Contraseña: ", JLabel.CENTER);
        JTextField userIn = new JTextField(15);
        passIn = new JPasswordField(15);

        OyentePassword passListener = new OyentePassword();
        Document midoc = passIn.getDocument();
        midoc.addDocumentListener(passListener);

        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(userEtiqueta);
        northPanel.add(userIn);
        northPanel.add(passEtiqueta);
        northPanel.add(passIn);

        add(northPanel, BorderLayout.NORTH);

        JButton send = new JButton("Enviar");
        add(send, BorderLayout.SOUTH);
    }

    private class OyentePassword implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            char[] contrasena;
            contrasena = passIn.getPassword();

            if (contrasena.length < 8 || contrasena.length > 12) {
                passIn.setBackground(Color.RED);
            } else {
                passIn.setBackground(Color.WHITE);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            char[] contrasena;
            contrasena = passIn.getPassword();

            if (contrasena.length < 8 || contrasena.length > 12) {
                passIn.setBackground(Color.RED);
            } else {
                passIn.setBackground(Color.WHITE);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    }
}