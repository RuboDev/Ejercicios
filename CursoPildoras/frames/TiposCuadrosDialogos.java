import javax.swing.*;
import java.awt.event.*;

public class TiposCuadrosDialogos {
    public static void main(String[] args) {
        FrameCuadrosDialogos marco = new FrameCuadrosDialogos();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class FrameCuadrosDialogos extends JFrame {
    public FrameCuadrosDialogos() {
        setBounds(500, 300, 400, 250);
        add(new LaminaCuadrosDialogos());
    }
}

class LaminaCuadrosDialogos extends JPanel {
    JButton boton1, boton2, boton3, boton4;

    public LaminaCuadrosDialogos() {
        boton1 = new JButton("boton 1");
        boton2 = new JButton("boton 2");
        boton3 = new JButton("boton 3");
        boton4 = new JButton("boton 4");

        boton1.addActionListener(new AccionBotones());
        boton2.addActionListener(new AccionBotones());
        boton3.addActionListener(new AccionBotones());
        boton4.addActionListener(new AccionBotones());

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
    }

    private class AccionBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton1) {
                // System.out.println("Has pulsado el boton 1");
                // JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "Mensaje de
                // prueba");
                JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "Mensaje de prueba", "Advertencia", 2);
            }

            if (e.getSource() == boton2) {
                System.out.println("Has pulsado el boton 2");
                JOptionPane.showInputDialog(LaminaCuadrosDialogos.this, "Introduce nombre", "Introduccion datos", 2);
            }

            if (e.getSource() == boton3) {
                System.out.println("Has pulsado el boton 3");
            }

            if (e.getSource() == boton4) {
                System.out.println("Has pulsado el boton 4");
            }
        }

    }
}