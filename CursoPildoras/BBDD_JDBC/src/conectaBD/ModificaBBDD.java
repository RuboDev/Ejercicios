package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModificaBBDD {
    public static void main(String[] args) {
        try {
            // CREAR CONEXIÓN - Create connection to the database
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            // CREAR OBJETO STATEMENT - Create a Statement object
            Statement miStatement = miConexion.createStatement();

            // ---- INSERT ----
            // EJECUTAR SENTENCIA SQL (para insertar nueva fila de datos)
            // Execute SQL query to insert data into a new row in the table
            String instruccionSQL1 = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR77','PANTALÓN', 25.35)";
            miStatement.executeUpdate(instruccionSQL1);
            System.out.println("Datos insertados correctamente.");
            
            // ---- UPDATE ----
            String instruccionSQL2 = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
            miStatement.executeUpdate(instruccionSQL2);
            System.out.println("Datos actualizados correctamente.");

            // ---- DELETE ----
            String instruccionSQL3 = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'";
            miStatement.executeUpdate(instruccionSQL3);
            System.out.println("Datos ELIMINADOS correctamente.");

        } catch (Exception e) {
            System.out.println("No conecta!!");
            e.printStackTrace();
        }
    }
}
