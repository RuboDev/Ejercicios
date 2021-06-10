import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Date;
import java.awt.geom.*;

public class MarcoDialogos extends JFrame {
    private LaminaCajas lamina_tipo, lamina_tipomsg, lamina_msg, lamina_confirm, lamina_opcion, lamina_entrada;

    private String cadenaMensaje = "Mensaje";
    private Icon iconoMensaje = new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/azul.png");
    private Object objetoMensaje = new Date();
    private Component compMensaje = new LaminaEjemplo();

    private String[] colores = { "Amarillo", "Azul", "Rojo" };
    private Icon iconoAmarillo = new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/amarillo.png");
    private Icon iconoAzul = new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/azul.png");
    private Icon iconoRojo = new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/rojo.png");
    private Icon[] arrayIconos = { iconoAmarillo, iconoAzul, iconoRojo };

    // Constructor -------------------------------------------------------------- //
    public MarcoDialogos() {
        setTitle("Selector Cuadro de dialogos");
        setBounds(600, 400, 650, 450);
        setLayout(new BorderLayout());

        // Constructing (2,3) Grid Panel
        JPanel laminaGrid = new JPanel();
        laminaGrid.setLayout(new GridLayout(2, 3));

        /*
         * Constructing Panels given group Box's title and a String Array of
         * RadioButtons names( constructed in it's class)
         */
        String[] opcTipo = { "Mensaje", "Confirmar", "Opcion", "Entrada" };
        lamina_tipo = new LaminaCajas("Tipo", opcTipo);

        String[] opcTipoMsg = { "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE",
                "PLAIN_MESSAGE" };
        lamina_tipomsg = new LaminaCajas("Tipo de Mensaje", opcTipoMsg);

        String[] opcMsg = { "Cadena", "Icono", "Componente", "Otros", "Object[]" };
        lamina_msg = new LaminaCajas("Mensaje", opcMsg);

        String[] opcConfir = { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" };
        lamina_confirm = new LaminaCajas("Confirmar", opcConfir);

        String[] opcOpcion = { "String[]", "Icon[]", "Object[]" };
        lamina_opcion = new LaminaCajas("Opcion", opcOpcion);

        String[] opcEntrada = { "Campo de texto", "Combo" };
        lamina_entrada = new LaminaCajas("Entrada", opcEntrada);

        // Adding all the panels with BoxLayout to the Grid Panel
        laminaGrid.add(lamina_tipo);
        laminaGrid.add(lamina_tipomsg);
        laminaGrid.add(lamina_msg);
        laminaGrid.add(lamina_confirm);
        laminaGrid.add(lamina_opcion);
        laminaGrid.add(lamina_entrada);

        // Constructing panel, with his "Mostrar" button
        JPanel laminaBotonMostrar = new JPanel();
        JButton botonMostrar = new JButton("Mostrar");
        botonMostrar.addActionListener(new OyenteMostrar());
        laminaBotonMostrar.add(botonMostrar);

        // Adding both panels to the frame
        add(laminaGrid, BorderLayout.CENTER);
        add(laminaBotonMostrar, BorderLayout.SOUTH);
    }
    // -------------------------------------------------------------------------- //

    // Method to get the Object selected from options in "Mensaje" titled panel
    public Object dameMensaje() {
        String s = lamina_msg.dameSeleccion();
        if (s.equals("Cadena")) {
            return cadenaMensaje;
        } else if (s.equals("Icono")) {
            return iconoMensaje;
        } else if (s.equals("Componente")) {
            return compMensaje;
        } else if (s.equals("Otros")) {
            return objetoMensaje;
        } else if (s.equals("Object[]")) {
            return new Object[] { cadenaMensaje, iconoMensaje, compMensaje, objetoMensaje };
        } else {
            return null;
        }
    }

    // Method to get the messageType selected from "Tipo de Mensaje" titled panel
    public int dameTipoMensaje() {
        String s = lamina_tipomsg.dameSeleccion();
        if (s.equals("ERROR_MESSAGE")) {
            return JOptionPane.ERROR_MESSAGE; // 0
        } else if (s.equals("INFORMATION_MESSAGE")) {
            return JOptionPane.INFORMATION_MESSAGE; // 1
        } else if (s.equals("WARNING_MESSAGE")) {
            return JOptionPane.WARNING_MESSAGE; // 2
        } else if (s.equals("QUESTION_MESSAGE")) {
            return JOptionPane.QUESTION_MESSAGE; // 3
        } else if (s.equals("PLAIN_MESSAGE")) {
            return JOptionPane.PLAIN_MESSAGE; // -1
        } else {
            return -1;
        }
    }

    // Method to get the optionType selected from "Confirmar" titled panel
    public int getOptionType() {
        String s = lamina_confirm.dameSeleccion();
        if (s.equals("DEFAULT_OPTION")) {
            return JOptionPane.DEFAULT_OPTION; // -1
        } else if (s.equals("YES_NO_OPTION")) {
            return JOptionPane.YES_NO_OPTION; // 0
        } else if (s.equals("YES_NO_CANCEL_OPTION")) {
            return JOptionPane.YES_NO_CANCEL_OPTION; // 1
        } else if (s.equals("OK_CANCEL_OPTION")) {
            return JOptionPane.OK_CANCEL_OPTION; // 2
        } else {
            return -1;
        }
    }

    // Method to get the kind of array selected from "Opcion" titled panel
    public Object[] getArrayOption() {
        String s = lamina_opcion.dameSeleccion();
        if (s.equals("String[]")) {
            return colores;
        } else if (s.equals("Icon[]")) {
            return arrayIconos;
        } else if (s.equals("Object[]")) {
            return new Object[] { cadenaMensaje, iconoMensaje, compMensaje, objetoMensaje };
        } else {
            return colores;
        }
    }

    private class OyenteMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (lamina_tipo.dameSeleccion()) {
                case "Mensaje":
                    JOptionPane.showMessageDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipoMensaje());
                    break;
                case "Confirmar":
                    JOptionPane.showConfirmDialog(MarcoDialogos.this, dameMensaje(), "Titulo", getOptionType(),
                            dameTipoMensaje());
                    break;
                case "Opcion":
                    JOptionPane.showOptionDialog(MarcoDialogos.this, dameMensaje(), "Titulo", getOptionType(),
                            dameTipoMensaje(), null, getArrayOption(), null);
                    break;
                case "Entrada":
                    if (lamina_entrada.dameSeleccion().equals("Campo de texto")) {
                        JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipoMensaje());
                    } else if (lamina_entrada.dameSeleccion().equals("Combo")) {
                        JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipoMensaje(),
                                null, new String[] { "Amarillo", "Azul", "Rojo" }, "Azul");
                    }
                    break;
            }
        }
    }
}

class LaminaEjemplo extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        g2.setPaint(Color.YELLOW);
        g2.fill(rectangulo);
    }
}