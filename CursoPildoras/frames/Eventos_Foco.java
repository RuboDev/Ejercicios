import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Eventos_Foco {
    public static void main(String[] args) {
        MarcoFoco mimarco = new MarcoFoco();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoFoco extends JFrame {
    public MarcoFoco() {
        setTitle("Eventos de Foco");
        setBounds(300, 300, 600, 450);
        setVisible(true);

        LaminaFoco milamina = new LaminaFoco();
        add(milamina);
    }
}

class LaminaFoco extends JPanel {

    JTextField cuadro1;
    JTextField cuadro2;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setLayout(null);
        cuadro1 = new JTextField();
        cuadro2 = new JTextField();
        cuadro1.setBounds(120, 10, 150, 20);
        cuadro2.setBounds(120, 50, 150, 20);
        add(cuadro1);
        add(cuadro2);

        OyenteFocos oyente = new OyenteFocos();
        cuadro1.addFocusListener(oyente);
        cuadro2.addFocusListener(oyente);

    }

    private class OyenteFocos implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("He perdido el foco");
        }
    }
}
