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
    private ButtonGroup migrupo;
    private JPanel lamina_botones;

    public Lamina_radio() {
        setLayout(new BorderLayout());

        texto = new JLabel("En un lugar de la Mancha de cuyo nombre...");
        texto.setFont(new Font("Serif", Font.PLAIN, 12));
        add(texto, BorderLayout.CENTER);

        migrupo = new ButtonGroup();
        lamina_botones = new JPanel();

        colocarBotones("Pequeño", false, 10);
        colocarBotones("Mediano", false, 12);
        colocarBotones("Grande", false, 18);
        colocarBotones("Muy Grande", false, 24);

        add(lamina_botones, BorderLayout.SOUTH);
    }

    public void colocarBotones(String nombre, boolean seleccionado, final int size) {
        JRadioButton boton = new JRadioButton(nombre, seleccionado);

        
        migrupo.add(boton);

        ActionListener mievento = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font("Serif", Font.PLAIN, size));
            }
        };
        boton.addActionListener(mievento);

        lamina_botones.add(boton);
    }
}