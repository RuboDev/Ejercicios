package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

import controlador.ControladorCargaMenus;

public class Marco_Aplicacion2 extends JFrame {
    public JComboBox<String> seccion;
    public JComboBox<String> pais;
    JTextArea areaTexto;

    public Marco_Aplicacion2() {
        setBounds(600, 400, 600, 700);
        setLayout(new BorderLayout());

        // Panel Menus
        JPanel menus = new JPanel();

        JLabel etiqSeccion = new JLabel("Sección comercial:");

        seccion = new JComboBox<String>();
        seccion.addItem("Todos");
        seccion.setEditable(false);

        JLabel etiqPais = new JLabel("País de origen:");

        pais = new JComboBox<String>();
        pais.addItem("Todos");
        pais.setEditable(false);

        menus.add(etiqSeccion);
        menus.add(seccion);

        menus.add(etiqPais);
        menus.add(pais);

        add(menus, BorderLayout.NORTH);

        // cargarComboBoxes(); ******
        addWindowListener(new ControladorCargaMenus(this));

        // Text Area
        areaTexto = new JTextArea(4, 50);
        add(areaTexto, BorderLayout.CENTER);

        // Botón consulta
        JButton btnConsulta = new JButton("Consulta");
        // btnConsulta.addActionListener(new OyenteBoton()); ******
        add(btnConsulta, BorderLayout.SOUTH);
    }
}
