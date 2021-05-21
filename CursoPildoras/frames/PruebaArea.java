import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaArea {
    public static void main(String[] args) {
        MarcoPruebaArea marco = new MarcoPruebaArea();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoPruebaArea extends JFrame {
    private JPanel laminaBotones;
    private JScrollPane laminaTexto;
    private JButton botonInsertar, botonSaltoLinea;
    private JTextArea areaTexto;

    public MarcoPruebaArea() {
        setTitle("Prueba Area");
        setBounds(500, 300, 500, 350);

        setLayout(new BorderLayout()); // Se puede setear Layout en el marco
        laminaBotones = new JPanel();

        areaTexto = new JTextArea(8, 20);
        laminaTexto = new JScrollPane(areaTexto);// Lamina con barra de scroll, un JTextArea como parametro para crear
                                                 // Area de texto con barra de scroll

        add(laminaTexto, BorderLayout.CENTER);

        botonInsertar = new JButton("Insertar");
        botonInsertar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme...");
            }

        });

        laminaBotones.add(botonInsertar);

        botonSaltoLinea = new JButton("Salto Linea");
        botonSaltoLinea.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saltar = !areaTexto.getLineWrap();
                areaTexto.setLineWrap(saltar);

                /*
                 * if (saltar) { botonSaltoLinea.setText("Quitar salto"); } else {
                 * botonSaltoLinea.setText("Salto Linea"); }
                 */
                botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto Linea");// lo mismo que el if else de arriba
            }

        });
        laminaBotones.add(botonSaltoLinea);

        add(laminaBotones, BorderLayout.SOUTH);
    }

}
