import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaChecks {
    public static void main(String[] args) {
        MarcoCheck marco = new MarcoCheck();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCheck extends JFrame {
    public MarcoCheck() {
        setTitle("Prueba Casillas de Verificacion");
        setBounds(550, 300, 550, 350);
        LaminaCheck lamina = new LaminaCheck();
        add(lamina);
        setVisible(true);
    }
}

class LaminaCheck extends JPanel {
    JPanel panelText;
    JLabel texto;
    JPanel panelChecks;
    JCheckBox casilla1;
    JCheckBox casilla2;

    public LaminaCheck() {
        setLayout(new BorderLayout());
        panelText = new JPanel();
        texto = new JLabel("El perro de san roque no tiene rabo");
        panelText.add(texto);

        panelChecks = new JPanel();
        // panelChecks.setLayout(new BorderLayout());

        Font mifuente = new Font("Dialog", Font.PLAIN, 20);
        texto.setFont(mifuente);

        casilla1 = new JCheckBox("Negrita");
        casilla2 = new JCheckBox("Cursiva");
        casilla1.addActionListener(new oyenteChecks());
        casilla2.addActionListener(new oyenteChecks());

        panelChecks.add(casilla1/* , BorderLayout.WEST */);
        panelChecks.add(casilla2/* , BorderLayout.EAST */);

        add(panelText, BorderLayout.NORTH);
        add(panelChecks, BorderLayout.SOUTH);

    }

    private class oyenteChecks implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // System.out.println(texto.getFont());
            int tipo = 0;
            if (casilla1.isSelected())
                tipo += Font.BOLD;
            if (casilla2.isSelected())
                tipo += Font.ITALIC;

            texto.setFont(new Font("Dialog", tipo, 20));
        }

    }
}
