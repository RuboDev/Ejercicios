import javax.swing.*;
import java.awt.*;

public class DisposicionLibre {
    public static void main(String[] args) {
        MarcoLibre marco = new MarcoLibre();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoLibre extends JFrame {
    public MarcoLibre() {
        setTitle("Disposicion Libre");
        setBounds(450, 350, 600, 400);
        var lamina = new LaminaLibre();
        add(lamina);
        setVisible(true);
    }
}

class LaminaLibre extends JPanel {
    public LaminaLibre() {
        setLayout(new EnColumnas());

        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        JLabel edad = new JLabel("Edad: ");
        JLabel tfno = new JLabel("Telefono: ");

        JTextField cNombre = new JTextField(10);
        JTextField cApellido = new JTextField(10);
        JTextField cEdad = new JTextField(10);
        JTextField cTfno = new JTextField(10);

        /*
         * nombre.setBounds(20, 20, 80, 15); cNombre.setBounds(80, 20, 100, 20);
         * 
         * apellido.setBounds(20, 60, 80, 15); cApellido.setBounds(80, 60, 100, 20);
         */

        add(nombre);
        add(cNombre);

        add(apellido);
        add(cApellido);

        add(edad);
        add(cEdad);

        add(tfno);
        add(cTfno);
    }
}

class EnColumnas implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // cosas
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // cosas
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        int d = parent.getWidth();
        int x = d / 2;
        int y = 20;
        int contador = 0;
        int n = parent.getComponentCount();

        for (int i = 0; i < n; i++) {
            contador++;

            Component c = parent.getComponent(i);
            c.setBounds(x - 100, y, 100, 20);
            x += 100;
            if (contador % 2 == 0) {
                x = d / 2;
                y += 40;
            }
        }
    }
}
