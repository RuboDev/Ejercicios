import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Aplicacion_Consulta {
    public static void main(String[] args) {
        MarcoAplicacion miMarco = new MarcoAplicacion();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoAplicacion extends JFrame {
    JComboBox<String> seccion;
    JComboBox<String> pais;

    public MarcoAplicacion() {
        setBounds(600, 400, 600, 600);
        setLayout(new BorderLayout());

        // Panel Menus
        JPanel menus = new JPanel();

        seccion = new JComboBox<String>();
        seccion.addItem("Todos");
        seccion.setEditable(false);

        pais = new JComboBox<String>();
        pais.addItem("Todos");
        pais.setEditable(false);

        menus.add(seccion);
        menus.add(pais);

        add(menus, BorderLayout.NORTH);

        cargarComboBoxes();

        // Text Area
        JTextArea areaTexto = new JTextArea(4, 50);
        add(areaTexto, BorderLayout.CENTER);

        // Botón consulta
        JButton btnConsulta = new JButton("Consulta");
        add(btnConsulta, BorderLayout.SOUTH);
    }

    // Procedimiento para cargar de items los comboboxes de la UI.
    // Se cargarán las distintas secciones de productos y los
    // paises de origen en orden alfanumerico.
    public void cargarComboBoxes() {
        try {
            // 1. Crear conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            // 2. Crear Statement
            Statement miSentencia = miConexion.createStatement();

            // Ejecutar y recorrer consulta 1 - 1ª Ocurrencia Seccion en orden
            ResultSet rsSeccion = miSentencia.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS ORDER BY SECCIÓN");

            while (rsSeccion.next()) {
                seccion.addItem(rsSeccion.getString(1));
            }
            rsSeccion.close();

            // Ejecutar y recorrer consulta 2 - 1ª Ocurrencia Pais en orden
            ResultSet rsPais = miSentencia
                    .executeQuery("SELECT DISTINCT PAÍSDEORIGEN FROM PRODUCTOS ORDER BY PAÍSDEORIGEN");

            while (rsPais.next()) {
                pais.addItem(rsPais.getString(1));
            }
            rsPais.close();

            miSentencia.close();
            miConexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}