import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class TrabajandoColores {
    public static void main(String[] args) {
        MarcoConColor mimarco = new MarcoConColor();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConColor extends JFrame {
    public MarcoConColor() {
        setTitle("Prueba con colores");
        setSize(400, 400);

        LaminaConColor milamina = new LaminaConColor();
        add(milamina);
        milamina.setBackground(Color.PINK);
    }
}

class LaminaConColor extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.setPaint(Color.BLUE);
        g2.draw(rectangulo);
        g2.setPaint(Color.RED);
        g2.fill(rectangulo);

        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);

        Color micolor = new Color(125, 189, 200); // Color micolor=new Color(125,189,200).brighter(); ó .darker()
        g2.setPaint(micolor); // g2.setPaint(micolor.brighter().brighter); brighter/darker se puede aplicar
                              // varias veces
        g2.fill(elipse);
    }
}
