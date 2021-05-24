import javax.swing.*;
import java.awt.*;

public class Spinner {
    public static void main(String[] args) {
        FrameSpinner marco = new FrameSpinner();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class FrameSpinner extends JFrame {
    public FrameSpinner() {
        setTitle("Prueba Spinner");
        setBounds(550, 350, 550, 350);
        LaminaSpinner lamina = new LaminaSpinner();
        add(lamina);
        setVisible(true);
    }
}

class LaminaSpinner extends JPanel {
    public LaminaSpinner() {
        /*
         * String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment()
         * .getAvailableFontFamilyNames(); JSpinner control = new JSpinner(new
         * SpinnerListModel(lista));
         */

        /*
         * El constructor por defecto de JSpinner utiliza SpinnerNumberModel Si queremos
         * modificar el comportammiento por defecto de SpinnerNumberModel lo
         * instanciamos y podemos explicitar uno de los constructores 
         * por ej.: (valor inicial, minimo, maximo,incremento/decremento)
         */
        JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1));
        control.setPreferredSize(new Dimension(150, 30));// seteamos el tamaño del componente
        add(control);
    }
}