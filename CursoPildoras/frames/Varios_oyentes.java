import java.awt.event.*;
import javax.swing.*;

public class Varios_oyentes {
    public static void main(String[] args) {
        Marco_Principal marco = new Marco_Principal();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class Marco_Principal extends JFrame {
    public Marco_Principal() {
        setTitle("Prueba Varios Oyentes");
        setBounds(1300, 100, 300, 200);
        Lamina_Principal lamina = new Lamina_Principal();
        add(lamina);
    }
}

class Lamina_Principal extends JPanel {

    JButton botonCerrar;

    public Lamina_Principal() {
        JButton botonNuevo = new JButton("Nuevo");
        add(botonNuevo);

        botonCerrar = new JButton("Cerrar Todo");
        add(botonCerrar);

        GeneradorMarcos oyente = new GeneradorMarcos();
        botonNuevo.addActionListener(oyente);
    }

    private class GeneradorMarcos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoGenerado marco = new MarcoGenerado(botonCerrar); // Se vuelca el botonCerrar como argumento
            marco.setVisible(true);
        }
    }
}

class MarcoGenerado extends JFrame {

    private static int cont = 0;

    public MarcoGenerado(JButton btnCerrar) {// se recibe un boton por parámetro
        setBounds(cont * 250, 0, 250, 200);
        cont++;
        setTitle("Marco generado " + cont);

        CierraTodos oyenteCerrar = new CierraTodos();
        btnCerrar.addActionListener(oyenteCerrar);
    }

    /*
     * El oyente para cerrar ventanas puede ir en la clase que crea las ventanas,
     * implementando la interfaz ActionListener, o en una clase aparte que también
     * la implemente.
     */
    private class CierraTodos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            cont = 0;
        }
    }

}