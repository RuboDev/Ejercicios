import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LaminaPrincipal extends JPanel {
    JPanel selectPanel;

    public LaminaPrincipal() {
        setLayout(new BorderLayout());

        selectPanel = new JPanel();
        selectPanel.setLayout(new GridLayout(2, 3));

        ButtonGroup tipo, tipoMensaje, mensaje, confirmar, opcion, entrada;

        Box cajaTipo = Box.createVerticalBox();
        tipo = new ButtonGroup();
        colocaRadioButtons("Mensaje", tipo, cajaTipo);
        colocaRadioButtons("Confirmar", tipo, cajaTipo);
        colocaRadioButtons("Opcion", tipo, cajaTipo);
        colocaRadioButtons("Entrada", tipo, cajaTipo);

        Box cajaTipoMensaje = Box.createVerticalBox();
        tipoMensaje = new ButtonGroup();
        colocaRadioButtons("ERROR_MESSAGE", tipoMensaje, cajaTipoMensaje);
        colocaRadioButtons("INFORMATION_MESSAGE", tipoMensaje, cajaTipoMensaje);
        colocaRadioButtons("WARNING_MESSAGE", tipoMensaje, cajaTipoMensaje);
        colocaRadioButtons("QUESTION_MESSAGE", tipoMensaje, cajaTipoMensaje);
        colocaRadioButtons("PLAIN_MESSAGE", tipoMensaje, cajaTipoMensaje);

        Box cajaMensaje = Box.createVerticalBox();
        mensaje = new ButtonGroup();
        colocaRadioButtons("Cadena", mensaje, cajaMensaje);
        colocaRadioButtons("Icono", mensaje, cajaMensaje);
        colocaRadioButtons("Componente", mensaje, cajaMensaje);
        colocaRadioButtons("Otros", mensaje, cajaMensaje);
        colocaRadioButtons("Object[]", mensaje, cajaMensaje);

        Box cajaConfirmar = Box.createVerticalBox();
        confirmar = new ButtonGroup();
        colocaRadioButtons("DEFAULT_OPTION", confirmar, cajaConfirmar);
        colocaRadioButtons("YES_NO_OPTION", confirmar, cajaConfirmar);
        colocaRadioButtons("YES_NO_CANCEL_OPTION", confirmar, cajaConfirmar);
        colocaRadioButtons("OK_CANCEL_OPTION", confirmar, cajaConfirmar);

        Box cajaOpcion = Box.createVerticalBox();
        opcion = new ButtonGroup();
        colocaRadioButtons("String[]", opcion, cajaOpcion);
        colocaRadioButtons("Icon[]", opcion, cajaOpcion);
        colocaRadioButtons("Object[]", opcion, cajaOpcion);

        Box cajaEntrada = Box.createVerticalBox();
        entrada = new ButtonGroup();
        colocaRadioButtons("Campo de texto", entrada, cajaEntrada);
        colocaRadioButtons("Combo", entrada, cajaEntrada);
        JPanel botonPanel = new JPanel();

        JButton botonMostrar = new JButton("Mostrar");
        // OyenteBotonMostrar oyeBoton = new OyenteBotonMostrar(tipoB, tipomsg, msg);
        botonMostrar.addActionListener(new OyenteBotonMostrar());

        botonPanel.setLayout(new FlowLayout());
        botonPanel.add(botonMostrar);

        add(selectPanel, BorderLayout.CENTER);
        add(botonPanel, BorderLayout.SOUTH);
    }

    private class OyenteSelectores implements ActionListener {

        JRadioButton tipoB, tipomsg, msg;

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton rButton;
            String cosas = e.getActionCommand();

            if (cosas == "Mensaje" || cosas == "Confirmar" || cosas == "Opcion" || cosas == "Entrada") {
                rButton = (JRadioButton) e.getSource();
                // boolean msgonoff = rButton.isSelected();
                System.out.println(rButton.isSelected());
                tipoB = rButton;
            }

            if (cosas == "ERROR_MESSAGE" || cosas == "INFORMATION_MESSAGE" || cosas == "WARNING_MESSAGE"
                    || cosas == "QUESTION_MESSAGE" || cosas == "PLAIN_MESSAGE") {
                rButton = (JRadioButton) e.getSource();
                // boolean erroronoff = rButton.isSelected();
                System.out.println(rButton.isSelected());
                tipomsg = rButton;
            }

            if (cosas == "Cadena" || cosas == "Icono" || cosas == "Componente" || cosas == "Otros"
                    || cosas == "Object[]") {
                rButton = (JRadioButton) e.getSource();
                // boolean erroronoff = rButton.isSelected();
                System.out.println(rButton.isSelected());
                msg = rButton;
            }
        }

    }

    private class OyenteBotonMostrar implements ActionListener {
        /*
         * JRadioButton tipoOye, tipomsgOye, msgOye;
         * 
         * public OyenteBotonMostrar() {
         * 
         * }
         * 
         * public OyenteBotonMostrar(JRadioButton tipoB, JRadioButton tipomsg,
         * JRadioButton msg) { this.tipoOye = tipoB; this.tipomsgOye = tipomsg;
         * this.msgOye = msg; }
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public void construyeCuadroMensaje(Object msg, String titulo, int tipomsg) {
        JOptionPane.showMessageDialog(LaminaPrincipal.this, msg, titulo, tipomsg);
    }

    public void colocaRadioButtons(String nombre, ButtonGroup grupo, Box caja) {
        JRadioButton radioButton = new JRadioButton(nombre);
        radioButton.addActionListener(new OyenteSelectores());
        grupo.add(radioButton);
        caja.add(radioButton);
        selectPanel.add(caja);
    }
}
