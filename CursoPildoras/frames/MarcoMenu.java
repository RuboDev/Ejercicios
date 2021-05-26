import javax.swing.*;

public class MarcoMenu {
    public static void main(String[] args) {
        MenuFrame marco = new MenuFrame();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MenuFrame extends JFrame {
    public MenuFrame() {
        setTitle("Prueba creacion de Menus");
        setBounds(500, 300, 550, 400);
        MenuLamina lamina = new MenuLamina();
        add(lamina);
        setVisible(true);
    }
}

class MenuLamina extends JPanel {
    public MenuLamina() {
        JMenuBar mibarra = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edicion");
        JMenu herramientas = new JMenu("Herramientas");

        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardarcomo = new JMenuItem("Guardar Como");
        archivo.add(guardar);
        archivo.add(guardarcomo);

        JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/copiar.gif"));
        copiar.setHorizontalTextPosition(SwingConstants.LEFT);
        JMenuItem pegar = new JMenuItem("Cortar", new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/cortar.gif"));
        pegar.setHorizontalTextPosition(SwingConstants.LEFT);
        JMenuItem cortar = new JMenuItem("Pegar", new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/pegar.gif"));
        cortar.setHorizontalTextPosition(SwingConstants.LEFT);

        JMenu opciones = new JMenu("Opciones");
        JMenuItem opcion1 = new JMenuItem("Opcion 1");
        JMenuItem opcion2 = new JMenuItem("Opcion 2");
        opciones.add(opcion1);
        opciones.add(opcion2);

        edicion.add(copiar);
        edicion.add(pegar);
        edicion.add(cortar);
        edicion.addSeparator();
        edicion.add(opciones);

        JMenuItem generales = new JMenuItem("Generales");
        herramientas.add(generales);

        mibarra.add(archivo);
        mibarra.add(edicion);
        mibarra.add(herramientas);
        add(mibarra);
    }
}