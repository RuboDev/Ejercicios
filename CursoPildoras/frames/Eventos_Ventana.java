import javax.swing.*;
import java.awt.event.*;

public class Eventos_Ventana {
    public static void main(String[] args) {
        MarcoVentana mimarco = new MarcoVentana();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setTitle("Ventana 1");
        mimarco.setBounds(300, 300, 500, 350);

        MarcoVentana mimarco2 = new MarcoVentana();
        mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mimarco2.setTitle("Ventana 2");
        mimarco2.setBounds(900, 300, 500, 350);
    }
}

class MarcoVentana extends JFrame {
    public MarcoVentana() {
        // setTitle("Respondiendo");
        // setBounds(300, 300, 500, 350);
        setVisible(true);

        /*
         * M_Ventana oyente = new M_Ventana(); addWindowListener(oyente);
         */
        addWindowListener(new M_Ventana());
    }
}

// class M_Ventana implements WindowListener {
class M_Ventana extends WindowAdapter {
    private static int cont = 0;
    private final int id;

    public M_Ventana() {
        cont++;
        this.id = cont;
    }

    /*
     * @Override public void windowOpened(WindowEvent e) {
     * System.out.println("Ventana " + id + " abierta"); }
     * 
     * @Override public void windowClosing(WindowEvent e) {
     * System.out.println("Cerrando ventana " + id + "..."); }
     * 
     * @Override public void windowClosed(WindowEvent e) {
     * System.out.println("La ventana " + id + " ha sido cerrada"); }
     */

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Ventana " + id + " Minimizada");
    }

    /*
     * @Override public void windowDeiconified(WindowEvent e) {
     * System.out.println("Ventana " + id + " restaurada"); }
     * 
     * @Override public void windowActivated(WindowEvent e) {
     * System.out.println("Ventana " + id + " activada"); }
     * 
     * @Override public void windowDeactivated(WindowEvent e) {
     * System.out.println("Ventana " + id + " desactivada"); }
     */

}
