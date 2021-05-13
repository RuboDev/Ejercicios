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
        addMouseListener(eventoRaton);
    }
}

/*
 * class EventosDeRaton implements MouseListener{
 * 
 * @Override public void mouseClicked(MouseEvent e) {
 * System.out.println("has hecho click"); }
 * 
 * @Override public void mousePressed(MouseEvent e) {
 * System.out.println("acabas de presionar"); }
 * 
 * @Override public void mouseReleased(MouseEvent e) {
 * System.out.println("acabas de levantar"); }
 * 
 * @Override public void mouseEntered(MouseEvent e) {
 * System.out.println("Acabas de entrar"); }
 * 
 * @Override public void mouseExited(MouseEvent e) {
 * System.out.println("Acabas de salir"); } }
 */

class EventosDeRaton extends MouseAdapter {
    /*
     * public void mouseClicked(MouseEvent e) {
     * System.out.println("has hecho click");
     * //System.out.println("x: "+e.getX()+", y: "+e.getY());
     * System.out.println(e.getClickCount()); }
     */
    public void mousePressed(MouseEvent e) {
        if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
            System.out.println("Has pulsado Boton Izq.");
        } else if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
            System.out.println("Has pulsado Boton Der.");
        } else if (e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
            System.out.println("Has pulsado Rueda");
        }
    }
}