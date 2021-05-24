import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sliders {
    public static void main(String[] args) {
        MarcoSliders marco=new MarcoSliders();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoSliders extends JFrame {
    public MarcoSliders() {
        setTitle("Prueba Sliders");
        setBounds(500, 300, 500, 350);
        LaminaSliders lamina = new LaminaSliders();
        add(lamina);
        setVisible(true);
    }
}

class LaminaSliders extends JPanel {
    public LaminaSliders() {
        JSlider control=new JSlider(0,100,25);
        //control.setOrientation(SwingConstants.VERTICAL);
        control.setMajorTickSpacing(20);
        control.setMinorTickSpacing(10);
        control.setPaintTicks(true);
        control.setPaintLabels(true);
        control.setFont(new Font("Serif", Font.ITALIC, 12));
        control.setSnapToTicks(true);
        add(control);
    }
}
