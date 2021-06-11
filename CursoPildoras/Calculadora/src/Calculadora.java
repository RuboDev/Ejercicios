import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora {
    public static void main(String[] args) {
        Marco_Calculadora marco = new Marco_Calculadora();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class Marco_Calculadora extends JFrame {
    public Marco_Calculadora() {
        setTitle("Mi Calculadora");
        setBounds(650, 400, 225, 250);
        Panel_Principal laminaPrincipal = new Panel_Principal();
        add(laminaPrincipal);
        // pack();
    }
}

class Panel_Principal extends JPanel {

    JButton pantalla;
    JPanel botones;
    // boolean principio;
    double resultado;
    String ultimaOperacion;
    String concatDigitos = "";
    JButton botonPunto;
    ActionListener oyente;
    ActionListener operar;
    JButton botonMenos;

    public Panel_Principal() {
        this.setLayout(new BorderLayout());

        JPanel display = new JPanel();
        display.setLayout(new BorderLayout());

        pantalla = new JButton("0");
        pantalla.setEnabled(false);
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        display.add(pantalla);

        botones = new JPanel();
        botones.setLayout(new GridLayout(4, 4));

        this.add(display, BorderLayout.NORTH);
        this.add(botones, BorderLayout.CENTER);

        // principio = true;
        oyente = new InsertarNumero();
        operar = new OyenteOperacion();

        ponerBoton("7", oyente);
        ponerBoton("8", oyente);
        ponerBoton("9", oyente);
        ponerBoton("/", operar);
        ponerBoton("4", oyente);
        ponerBoton("5", oyente);
        ponerBoton("6", oyente);
        ponerBoton("*", operar);
        ponerBoton("1", oyente);
        ponerBoton("2", oyente);
        ponerBoton("3", oyente);
        ponerBoton("-", operar);
        ponerBoton("0", oyente);
        ponerBoton(".", oyente);
        ponerBoton("=", operar);
        ponerBoton("+", operar);

        this.ultimaOperacion = "=";
    }

    private class InsertarNumero implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            /*
             * if (principio) { pantalla.setText(""); principio = false; }
             */
            if (e.getActionCommand() == "." || concatDigitos.contains(".")) {
                botonPunto.setEnabled(false);
            } else {
                botonPunto.setEnabled(true);
            }

            String digito = e.getActionCommand();
            concatDigitos += digito;

            pantalla.setText(String.valueOf(concatDigitos));
        }

    }

    private class OyenteOperacion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            concatDigitos = "";

            botonPunto.setEnabled(false);
            String operacion = e.getActionCommand();

            calcular(Double.parseDouble(pantalla.getText()));

            ultimaOperacion = operacion;
            // principio = true;
        }
    }

    private void ponerBoton(String rotulo, ActionListener oyente) {
        // ActionListener insertar = new InsertarNumero();
        JButton btn = new JButton(rotulo);
        btn.addActionListener(oyente);
        botones.add(btn);
        if (btn.getText() == ".") {
            btn.setEnabled(false);
            botonPunto = btn;
        }
        if (btn.getText() == "-") {
            botonMenos = btn;
        }
    }

    public void calcular(double num) {
        if (ultimaOperacion.equals("+")) {
            resultado += num;
            System.out.println(resultado);
        } else if (ultimaOperacion.equals("-")) {
            resultado -= num;
            System.out.println(resultado);
        } else if (ultimaOperacion.equals("*")) {
            resultado *= num;
            System.out.println(resultado);
        } else if (ultimaOperacion.equals("/")) {
            resultado /= num;
            System.out.println(resultado);
        } else if (ultimaOperacion.equals("=")) {
            resultado = num;
            System.out.println(resultado);
        }

        pantalla.setText(String.valueOf(resultado));
    }
}
