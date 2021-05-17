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

        /*
         * Atajos de teclado:
         * 
         * ActionMap - method getActionMap() asign the ActionMap that determines what
         * action fire for each particular key
         */
        ActionMap mapaAccion = getActionMap();
        /*
         * put actions to the ActionMap below in (key, action) format, adding a binding
         * for key to action (vincula la clave a una accion)
         */
        mapaAccion.put("fondo_Amarillo", accionAmarillo);
        mapaAccion.put("fondo_Azul", accionAzul);
        mapaAccion.put("fondo_Rojo", accionRojo);

        /*
         * InputMap - lo que devuelve el metodo getInputMap se asigna a la variable de
         * tipo InputMap. getInputMap - devuelve el inputMap usado mientras se cumple la
         * condicion de estar en la ventana focuseada
         */
        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        /*
         * los siguientes puts agregan un vinuclo para cada stroke hacia un elemento de
         * ActionMap, determinando qué elemento por la clave (o key) del elemento.
         * Vinculo keyStroke - key(de un elemento de ActionMap)
         */
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_Amarillo");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl T"), "fondo_Amarillo");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_Azul");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_Rojo");
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

            System.out.println(
                    "Nombre: " + getValue(Action.NAME) + "\nDescripcion: " + getValue(Action.SHORT_DESCRIPTION));
        }
    }
}
