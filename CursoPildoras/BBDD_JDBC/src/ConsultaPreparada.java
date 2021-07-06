import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaPreparada {
    public static void main(String[] args) {

        try {
            // 1. Crear conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            // 2. Preparar consulta
            PreparedStatement miSentencia = miConexion.prepareStatement(
                    "SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");

            // 3. Establecer parámetros de consulta
            miSentencia.setString(1, "Deportes");
            miSentencia.setString(2, "USA");

            // 4.1 Ejecutar y recorrer consulta 1
            ResultSet rs = miSentencia.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            rs.close();

            // REUTILIZACIÓN DE CONSULTA SQL
            System.out.println();
            System.out.println("Ejecucion de segunda consulta");
            System.out.println();
            miSentencia.setString(1, "CERÁMICA");
            miSentencia.setString(2, "CHINA");

            // 4.2 Ejecutar y recorrer consulta 2
            rs = miSentencia.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
