import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class MarcoDialogos extends JFrame {
    private LaminaCajas lamina1, lamina2, lamina3, lamina4, lamina5, lamina6;

    public MarcoDialogos() {
        setTitle("Selector Cuadro de dialogos");
        setBounds(600, 400, 650, 450);
        setLayout(new BorderLayout());

        JPanel laminaGrid = new JPanel();
        laminaGrid.setLayout(new GridLayout(2, 3));

        String[] opcTipo = { "Mensaje", "Confirmar", "Opcion", "Entrada" };
        lamina1 = new LaminaCajas("Tipo", opcTipo);

        String[] opcTipoMsg = { "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE",
                "PLAIN_MESSAGE" };
        lamina2 = new LaminaCajas("Tipo de Mensaje", opcTipoMsg);

        String[] opcMsg = { "Cadena", "Icono", "Componente", "Otros", "Object[]" };
        lamina3 = new LaminaCajas("Mensaje", opcMsg);

        String[] opcConfir = { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" };
        lamina4 = new LaminaCajas("Confirmar", opcConfir);

        String[] opcOpcion = { "String[]", "Icon[]", "Object[]" };
        lamina5 = new LaminaCajas("Opcion", opcOpcion);

        String[] opcEntrada = { "Campo de texto", "Combo" };
        lamina6 = new LaminaCajas("Entrada", opcEntrada);

        laminaGrid.add(lamina1);
        laminaGrid.add(lamina2);
        laminaGrid.add(lamina3);
        laminaGrid.add(lamina4);
        laminaGrid.add(lamina5);
        laminaGrid.add(lamina6);

        JPanel laminaBotonMostrar = new JPanel();
        JButton botonMostrar = new JButton("Mostrar");
        laminaBotonMostrar.add(botonMostrar);

        add(laminaGrid, BorderLayout.CENTER);
        add(laminaBotonMostrar, BorderLayout.SOUTH);
    }
}
