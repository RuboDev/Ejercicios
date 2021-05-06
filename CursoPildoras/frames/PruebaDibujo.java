import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class PruebaDibujo {
    public static void main(String[] args) {
        MarcoConDibujos mimarco = new MarcoConDibujos();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}

class MarcoConDibujos extends JFrame {
    public MarcoConDibujos() {
        setTitle("prueba de Dibujo");
        setSize(400, 400);
        LaminaConFiguras milamina = new LaminaConFiguras();
        add(milamina);
    }
}

class LaminaConFiguras extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
        g2.draw(rectangulo);

        Ellipse2D elipse=new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.draw(elipse);
        g2.draw(new Line2D.Double(100,100,300,250));

        double centroenX=rectangulo.getCenterX();
        double centroenY=rectangulo.getCenterY();
        double radio = 150;

        Ellipse2D circulo=new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroenX, centroenY, centroenX+radio, centroenY+radio);
        g2.draw(circulo);
    }
}