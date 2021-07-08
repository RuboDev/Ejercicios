package conectaBD;

import java.sql.*;

public class Conecta_Productos {
    public static void main(String[] args) {

        try {
            // 1. CREAR CONEXIÓN - Create connection to the database
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root",
                    "");

            // 2. CREAR OBJETO STATEMENT - Create a Statement object
            Statement miStatement = miConexion.createStatement();

            // 3. EJECUTAR SENTENCIA SQL - Execute SQL query
            ResultSet miResultset = miStatement.executeQuery("SELECT * FROM PRODUCTOS");

            // 4. RECORRER EL RESULSET - Loop through the ResulSet
            while (miResultset.next()) {
                System.out.println(miResultset.getString("NOMBREARTÍCULO") + " "
                        + miResultset.getString("CÓDIGOARTÍCULO") + " " + miResultset.getString("PRECIO") + "€");
            }
        } catch (Exception e) {
            System.out.println("No conecta!!");
            e.printStackTrace();
        }
    }
}