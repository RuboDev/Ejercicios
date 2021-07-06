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
    public MarcoAplicacion() {
        setBounds(600, 400, 600, 600);
        setLayout(new BorderLayout());

        // Panel Menus
        JPanel menus = new JPanel();

        JComboBox<String> seccion = new JComboBox<String>();
        seccion.addItem("Todos");
        seccion.setEditable(false);

        JComboBox<String> pais = new JComboBox<String>();
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

    public void cargarComboBoxes() {
        try {
            // 1. Crear conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root",
                    "");

            // 2. Crear Statement 
            Statement miSentencia = miConexion.createStatement();

            // 4.1 Ejecutar y recorrer consulta 1
            ResultSet rs = miSentencia.executeQuery("SELECT SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}