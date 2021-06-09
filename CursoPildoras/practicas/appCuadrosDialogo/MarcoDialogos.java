import javax.swing.*;

public class MarcoDialogos extends JFrame {
    public MarcoDialogos() {
        setTitle("Selector Cuadro de dialogos");
        setBounds(600, 400, 600, 400);
        LaminaPrincipal lamina = new LaminaPrincipal();
        add(lamina);
        setVisible(true);
    }
}
