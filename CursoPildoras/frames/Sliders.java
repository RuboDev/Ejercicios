import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Sliders {
    public static void main(String[] args) {
        MarcoSliders marco = new MarcoSliders();
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
    private JLabel rotulo;
    private JSlider control;

    public LaminaSliders() {
        setLayout(new BorderLayout());
        control = new JSlider(8, 52, 12);
        // control.setOrientation(SwingConstants.VERTICAL); se puede disponer en
        // vertical o horizontal.
        control.setMajorTickSpacing(4); // Tick grande cada 4 unidades
        control.setMinorTickSpacing(1); // Tick peque cada 1 unidad
        control.setPaintTicks(true); // pintar tricks: true/false
        control.setPaintLabels(true); // pintar etiquetas a los ticks: true/false - numeros por ej.
        control.setFont(new Font("Serif", Font.ITALIC, 10)); // fuente de las etiquetas
        control.setSnapToTicks(true); /*
                                       * imantiza los ticks, si sueltas el arrastre entre dos ticks, 
                                       * va hacia el más cercano.
                                       */

        oyenteSlider oyente = new oyenteSlider();
        control.addChangeListener(oyente);

        JPanel laminaSlider = new JPanel();
        laminaSlider.add(control);
        add(laminaSlider, BorderLayout.NORTH);

        rotulo = new JLabel("En un lugar de la Mancha de cuyo nombre...");
        add(rotulo, BorderLayout.CENTER);
        System.out.println(rotulo.getFont());
    }

    private class oyenteSlider implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            rotulo.setFont(new Font("Dialog", Font.PLAIN, control.getValue()));
        }
    }
}
