package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection miConexion = null;

    public Conexion() {

    }

    public Connection dameConexion() {
        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miConexion;
    }
}
