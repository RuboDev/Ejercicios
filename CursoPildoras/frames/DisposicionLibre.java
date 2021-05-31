import javax.swing.*;

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
        LaminaLibre lamina = new LaminaLibre();
        add(lamina);
        setVisible(true);
    }
}

class LaminaLibre extends JPanel {
    public LaminaLibre() {
        setLayout(null);

        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        JTextField c_nombre = new JTextField(10);
        JTextField c_apellido = new JTextField(10);

        nombre.setBounds(20, 20, 80, 15);
        c_nombre.setBounds(80, 20, 100, 20);

        apellido.setBounds(20, 60, 80, 15);
        c_apellido.setBounds(80, 60, 100, 20);

        add(nombre);
        add(apellido);
        add(c_nombre);
        add(c_apellido);
    }
}