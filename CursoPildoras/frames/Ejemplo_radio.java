import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ejemplo_radio {
    public static void main(String[] args) {
        Marco_radio marco = new Marco_radio();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Marco_radio extends JFrame {
    public Marco_radio() {
        setTitle("Ejemplo JRadioButtons");
        setBounds(500, 300, 550, 350);
        Lamina_radio lamina = new Lamina_radio();
        add(lamina);
        setVisible(true);
    }
}

class Lamina_radio extends JPanel {
    private JLabel texto;
    private JRadioButton boton1, boton2, boton3, boton4;

    public Lamina_radio() {
        setLayout(new BorderLayout());

        texto = new JLabel("En un lugar de la Mancha de cuyo nombre...");
        add(texto, BorderLayout.CENTER);

        ButtonGroup migrupo = new ButtonGroup();
        boton1 = new JRadioButton("Pequeño", false);
        boton2 = new JRadioButton("Mediano", false);
        boton3 = new JRadioButton("Grande", false);
        boton4 = new JRadioButton("Muy Grande", false);

        boton1.addActionListener(new oyenteRButtons());
        boton2.addActionListener(new oyenteRButtons());
        boton3.addActionListener(new oyenteRButtons());
        boton4.addActionListener(new oyenteRButtons());
        migrupo.add(boton1);
        migrupo.add(boton2);
        migrupo.add(boton3);
        migrupo.add(boton4);

        JPanel laminaRButtons = new JPanel();
        laminaRButtons.add(boton1);
        laminaRButtons.add(boton2);
        laminaRButtons.add(boton3);
        laminaRButtons.add(boton4);

        add(laminaRButtons, BorderLayout.SOUTH);
    }

    private class oyenteRButtons implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton1) {
                texto.setFont(new Font("Serif", Font.PLAIN, 10));
            } else if (e.getSource() == boton2) {
                texto.setFont(new Font("Serif", Font.PLAIN, 12));
            } else if (e.getSource() == boton3) {
                texto.setFont(new Font("Serif", Font.PLAIN, 18));
            } else if (e.getSource() == boton4) {
                texto.setFont(new Font("Serif", Font.PLAIN, 24));
            }
        }
    }
}