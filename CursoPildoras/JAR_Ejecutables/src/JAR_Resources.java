import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.*;
import java.awt.BorderLayout;

public class JAR_Resources {
    public static void main(String[] args) {
        MarcoRecursos marco = new MarcoRecursos();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoRecursos extends JFrame {
    public MarcoRecursos() {
        setTitle("Prueba de Recursos");
        setBounds(300, 300, 300, 300);
        add(new LaminaRecursos());
    }
}

class LaminaRecursos extends JPanel {
    public LaminaRecursos() {
        setLayout(new BorderLayout());

        JTextArea zonaTexto = new JTextArea();
        add(new JScrollPane(zonaTexto), BorderLayout.CENTER);

        JButton botonDale = new JButton("Dale!", new ImageIcon(JAR_Resources.class.getResource("img/azul.png")));
        botonDale.addActionListener(new OyenteBoton());
        add(botonDale, BorderLayout.SOUTH);

    }

    private class OyenteBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("El botón funciona");
        }
    }
}
