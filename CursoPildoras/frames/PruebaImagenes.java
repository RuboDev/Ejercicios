import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PruebaImagenes {
    public static void main(String[] args) {
        MarcoImagen mimarco = new MarcoImagen();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoImagen extends JFrame {
    public MarcoImagen() {
        setTitle("Marco Con Imagen");
        setBounds(750, 300, 640, 450);
        LaminaImagen milamina = new LaminaImagen();
        add(milamina);
        setResizable(false);

        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        setIconImage(mipantalla.getImage("CursoPildoras/resources/iconos/icono.png"));// Setea icono con imagen de la
                                                                                      // ruta especificada
    }
}

class LaminaImagen extends JPanel {
    private Image miImagen;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // File archivo = new File("CursoPildoras/resources/coche.png");

        try {
            miImagen = ImageIO.read(new File("CursoPildoras/resources/img/coche.png"));// Lee archivo de la ruta
                                                                                       // especificada
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("La imagen no se encuentra");
        }

        g.drawImage(miImagen, 0, 0, null);// Dibuja imagen en la lamina
    }
}