import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.*;

public class PruebaAcciones {
    public static void main(String[] args) {
        MarcoAccion marco = new MarcoAccion();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoAccion extends JFrame {
    public MarcoAccion() {
        setTitle("Prueba Acciones");
        setBounds(600, 350, 600, 300);
        PanelAccion lamina = new PanelAccion();
        add(lamina);
    }
}

class PanelAccion extends JPanel {
    public PanelAccion() {
        AccionColor accionAmarillo = new AccionColor("Amarillo",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/amarillo.png"), Color.YELLOW);
        AccionColor accionAzul = new AccionColor("Azul",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/azul.png"), Color.BLUE);
        AccionColor accionRojo = new AccionColor("Rojo",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/rojo.png"), Color.RED);

        add(new JButton(accionAmarillo));
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));

        /* No hace falta instanciarlo así:
         * JButton botonAmarillo = new JButton(accionAmarillo); JButton bontonAzul = new
         * JButton(accionAzul); JButton botonRojo
         */
        /*
         * JButton botonAmarillo = new JButton("Amarillo"); JButton botonAzul = new
         * JButton("Azul"); JButton botonRojo = new JButton("Rojo");
         * 
         * add(botonAmarillo); add(botonAzul); add(botonRojo);
         */
    }

    private class AccionColor extends AbstractAction {

        public AccionColor(String nombre, Icon icono, Color color_boton) {
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre);
            putValue("Color_de_fondo", color_boton);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color_de_fondo");
            setBackground(c);

            System.out.println("Nombre: " + getValue(Action.NAME) + "\nDescripcion: " + getValue(Action.SHORT_DESCRIPTION));
        }

    }

}
