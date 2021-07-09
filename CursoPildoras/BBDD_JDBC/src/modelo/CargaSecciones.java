package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CargaSecciones {
    private Conexion miConexion;
    public ResultSet rs;

    public CargaSecciones() {
        miConexion = new Conexion();
    }

    public void ejecutaConsultas() {
        Connection accesoBBDD = miConexion.dameConexion();

        try {
            Statement stateSecciones = accesoBBDD.createStatement();

            rs = stateSecciones.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS ORDER BY SECCIÓN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
