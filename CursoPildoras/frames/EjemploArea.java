import java.lang.reflect.Method;

import javax.swing.*;
import java.awt.event.*;

public class EjemploArea {
    public static void main(String[] args) {
        MarcoArea marco = new MarcoArea();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoArea extends JFrame {
    public MarcoArea() {
        setTitle("Ejemplo JTextArea");
        setBounds(500, 300, 500, 350);
        LaminaArea lamina = new LaminaArea();
        add(lamina);
        setVisible(true);
    }
}

class LaminaArea extends JPanel {
    JTextArea miarea;

    public LaminaArea() {
        miarea = new JTextArea(8, 20);
        JScrollPane panelArea = new JScrollPane(miarea);
        // miarea.setLineWrap(true);
        add(panelArea);

        JButton miboton = new JButton("Pulsa");
        miboton.addActionListener(new GestionaArea());
        add(miboton);
    }

    private class GestionaArea implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(miarea.getText());
        }
    }
}