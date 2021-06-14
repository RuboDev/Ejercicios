package excepciones_I;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LeerImagen {
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
        setResizable(true);

        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        setIconImage(mipantalla.getImage("Ejercicios/CursoPildoras/resources/iconos/icono.png"));// Setea icono con la
                                                                                                 // imagen de la ruta
                                                                                                 // especificada
    }
}

class LaminaImagen extends JPanel {
    private Image miImagen;

    public LaminaImagen() {
        // excepcion comprobada (gestion explícita) - Se debe controlar obligatoriamente
        try {
            miImagen = ImageIO.read(new File("src/excepciones/bola.gif"));
        } catch (IOException e) {
            System.out.println("La imagen no se encuentra");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // excepcion no comprobada (gestion implícita) - se puede resolver por medio de bloques condicionales
        if (miImagen == null) {
            g.drawString("no se pudo cargar la imagen", 10, 10);
        } else {

            g.drawImage(miImagen, 0, 0, null);// Dibuja imagen en la lamina

            int anchuraImagen = miImagen.getWidth(this);
            int alturaImagen = miImagen.getHeight(this);

            for (int i = 0; i < 150; i++) {

                for (int j = 0; j < 100; j++) {
                    if (i + j > 0) {
                        g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen * i, alturaImagen * j);
                    }
                }
            }
        }
    }
}