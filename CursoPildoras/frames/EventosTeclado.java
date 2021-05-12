import javax.swing.*;
import java.awt.event.*;

public class EventosTeclado {
    public static void main(String[] args) {
        MarcoConTeclas mimarco = new MarcoConTeclas();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConTeclas extends JFrame {
    public MarcoConTeclas() {
        setTitle("Eventos teclas");
        setBounds(700, 300, 600, 550);
        setVisible(true);

        EventoDeTeclado oyente = new EventoDeTeclado();
        addKeyListener(oyente);
    }
}

class EventoDeTeclado implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        char letra = e.getKeyChar();
        System.out.println(letra);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        // System.out.println(codigo);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println();

    }

}