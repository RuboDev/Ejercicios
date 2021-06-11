import java.awt.*;
import javax.swing.JFrame;

public class MultimediaFirma {
    public static void main(String[] args) {
        MarcoMultimediaFirma marco = new MarcoMultimediaFirma();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoMultimediaFirma extends JFrame {
    Image logo;

    public MarcoMultimediaFirma() {
        setBounds(600, 400, 150, 150);
        logo = Toolkit.getDefaultToolkit().getImage(MultimediaFirma.class.getResource("img/logo.png"));
    }

    public void paint(Graphics g) {
        g.drawImage(logo, 50, 50, this);
    }
}
