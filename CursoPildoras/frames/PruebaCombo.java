import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

public class PruebaCombo {
    public static void main(String[] args) {
        MarcoCombo marco = new MarcoCombo();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCombo extends JFrame {
    public MarcoCombo() {
        setTitle("Prueba JComboBox");
        setBounds(500, 500, 550, 350);
        LaminaCombo lamina = new LaminaCombo();
        add(lamina);
        setVisible(true);
    }
}

class LaminaCombo extends JPanel {
    private JLabel texto;
    private JComboBox micombo;

    public LaminaCombo() {
        setLayout(new BorderLayout());
        texto = new JLabel("En lugar de la Mancha de cuyo nombre...");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        add(texto, BorderLayout.CENTER);

        JPanel lamina_norte = new JPanel();
        micombo = new JComboBox();
        micombo.setEditable(true);
        micombo.addItem("Serif");
        micombo.addItem("SansSerif");
        micombo.addItem("Monospaced");
        micombo.addItem("Dialog");

        oyenteCombo mioyente = new oyenteCombo();
        micombo.addActionListener(mioyente);

        lamina_norte.add(micombo);
        add(lamina_norte, BorderLayout.NORTH);
    }

    private class oyenteCombo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            texto.setFont(new Font((String) micombo.getSelectedItem(), Font.PLAIN, 18));
        }
    }
}
