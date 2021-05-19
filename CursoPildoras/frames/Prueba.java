import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Prueba {
    public static void main(String[] args) {
        MarcoPrueba marco = new MarcoPrueba();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoPrueba extends JFrame {
    public MarcoPrueba() {
        setTitle("Prueba eventos Texto");
        setBounds(500, 300, 500, 350);
        LaminaPrueba lamina = new LaminaPrueba();
        add(lamina);
        setVisible(true);
    }
}

class LaminaPrueba extends JPanel {
    public LaminaPrueba() {
        JTextField micampo = new JTextField(20);

        EscuchaTexto oyeText = new EscuchaTexto();
        Document midoc = micampo.getDocument();
        midoc.addDocumentListener(oyeText);

        add(micampo);
    }

    private class EscuchaTexto implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("Has insertado texto");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("Has borrado texto");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    }
}