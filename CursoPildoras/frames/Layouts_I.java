import javax.swing.*;
import java.awt.*;

public class Layouts_I {
    public static void main(String[] args) {
        Marco_Layout marco = new Marco_Layout();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Marco_Layout extends JFrame {
    public Marco_Layout() {
        setTitle("Layouts I");
        setBounds(600, 350, 600, 300);
        Panel_Layout lamina = new Panel_Layout();
        // FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER);
        lamina.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(lamina);
    }
}

class Panel_Layout extends JPanel {
    public Panel_Layout() {
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
        add(new JButton("Azul"));
    }
}