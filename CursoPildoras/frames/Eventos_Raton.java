import javax.swing.*;
import java.awt.event.*;

public class Eventos_Raton {
    public static void main(String[] args) {
        MarcoRaton mimarco = new MarcoRaton();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoRaton extends JFrame {
    public MarcoRaton() {
        setTitle("Eventos de raton");
        setBounds(700, 300, 600, 450);
        setVisible(true);
        EventosDeRaton eventoRaton = new EventosDeRaton();
        addMouseMotionListener(eventoRaton);
    }
}

class EventosDeRaton implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Estas arrastrando");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Estas moviendo");
    }
}