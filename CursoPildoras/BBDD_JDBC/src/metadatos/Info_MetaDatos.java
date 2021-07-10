package metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Info_MetaDatos {
    public static void main(String[] args) {
        // mostrarInfo_BBDD();
        mostrarInfo_Tablas();
    }

    static void mostrarInfo_BBDD() {
        Connection miConexion = null;
        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            // Obtencion de metadatos
            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            // Mostramos información de la BBDD

            System.out.println("Gestor de BBDD: " + datosBBDD.getDatabaseProductName());
            System.out.println("Versión del Gestor: " + datosBBDD.getDatabaseProductVersion());
            System.out.println("Nombre del driver: " + datosBBDD.getDriverName());
            System.out.println("Versión del driver: " + datosBBDD.getDriverVersion());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                miConexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void mostrarInfo_Tablas() {
        Connection miConexion = null;
        ResultSet miResultSet = null;
        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            // Obtencion de metadatos
            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            // Lista de tablas
            System.out.println("Lista de tablas");

            miResultSet = datosBBDD.getTables("prueba", null, null, null);
            while (miResultSet.next()) {
                System.out.println(miResultSet.getString("TABLE_NAME"));

            }

            System.out.println("");
            // Lista de columnas de Productos
            System.out.println("Campos de Productos");

            miResultSet = datosBBDD.getColumns(null, null, "PRODUCTOS", null);
            while (miResultSet.next()) {
                System.out.println(miResultSet.getString("COLUMN_NAME"));

            }

        } catch (Exception e) {

        } finally {

        }
    }
}
