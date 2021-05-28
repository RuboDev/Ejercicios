import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Barra_Herramientas {
    public static void main(String[] args) {
        Marco_Herramientas marco = new Marco_Herramientas();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class Marco_Herramientas extends JFrame {
    JPanel lamina;

    public Marco_Herramientas() {
        setTitle("Marco con ToolBar");
        setBounds(500, 300, 600, 450);

        lamina = new JPanel();
        add(lamina);

        // Creating actions
        Action accionAmarillo = new AccionColor("Amarillo",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/amarillo.png"), Color.YELLOW);
        Action accionAzul = new AccionColor("Azul", new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/azul.png"),
                Color.BLUE);
        Action accionRojo = new AccionColor("Rojo", new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/rojo.png"),
                Color.RED);
        Action accionSalir = new AbstractAction("Salir",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/close.png")) {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        };

        // Constructing JMenuBar
        JMenuBar barra_menus = new JMenuBar();
        JMenu menu = new JMenu("Color");
        menu.add(accionAmarillo);
        menu.add(accionAzul);
        menu.add(accionRojo);

        barra_menus.add(menu);
        setJMenuBar(barra_menus);

        // Constructing JToolBar
        JToolBar barraH = new JToolBar();
        barraH.add(accionAmarillo);
        barraH.add(accionAzul);
        barraH.add(accionRojo);
        barraH.addSeparator();
        barraH.add(accionSalir);
        add(barraH, BorderLayout.NORTH);
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
            lamina.setBackground(c);

            System.out.println(
                    "Nombre: " + getValue(Action.NAME) + "\nDescripcion: " + getValue(Action.SHORT_DESCRIPTION));
        }
    }
}