package procAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConsultaClientes {
    public static void main(String[] args) {
        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            // Creamos un CallableStatement para ejecutar prodecimientos almacenados,
            // también llamados rutinas.
            CallableStatement miStatement = miConexion.prepareCall("{call MUESTRA_CLIENTES}");
            ResultSet rs = miStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
