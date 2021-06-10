import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;

public class MarcoDialogos extends JFrame {
    private LaminaCajas lamina_tipo, lamina_tipomsg, lamina_msg, lamina_confirm, lamina_opcion, lamina_entrada;

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

    private class OyenteMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(lamina_tipo.dameSeleccion());
            System.out.println(lamina_tipomsg.dameSeleccion());
            System.out.println(lamina_msg.dameSeleccion());

            System.out.println(lamina_confirm.dameSeleccion());
            System.out.println(lamina_opcion.dameSeleccion());
            System.out.println(lamina_entrada.dameSeleccion());
        }

    }
}
