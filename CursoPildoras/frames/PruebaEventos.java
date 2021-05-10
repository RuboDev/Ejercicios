import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaEventos {
    public static void main(String[] args) {
        MarcoBotones mimarco = new MarcoBotones();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoBotones extends JFrame {

    public MarcoBotones() {
        setTitle("Eventos y Botones");
        setBounds(700, 300, 500, 300);

        // He agregado la siguiente linea y el icono para ir repasando.
        setIconImage(Toolkit.getDefaultToolkit().getImage("Ejercicios/CursoPildoras/resources/iconos/botonhelp.png"));

        LaminaBotones milamina = new LaminaBotones();
        add(milamina);

    }
}

class LaminaBotones extends JPanel implements ActionListener {
    JButton btnAzul = new JButton("Azul");
    JButton btnRojo = new JButton("Rojo");
    JButton btnAmarillo = new JButton("Amarillo");

    public LaminaBotones() {
        add(btnAzul);
        add(btnRojo);
        add(btnAmarillo);

        btnAzul.addActionListener(this);
        btnRojo.addActionListener(this);
        btnAmarillo.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAzul) {
            setBackground(Color.BLUE);
            System.out.println(btnAzul.getForeground());
            btnAzul.setForeground(Color.BLUE);
        }

        if (e.getSource() == btnRojo) {
            setBackground(Color.RED);

            btnAzul.setForeground(new Color(51,51,51));
        }

        if (e.getSource() == btnAmarillo) {
            setBackground(Color.YELLOW);
        }

    }

}