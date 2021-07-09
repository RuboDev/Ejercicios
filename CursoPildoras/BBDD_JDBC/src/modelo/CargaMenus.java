package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CargaMenus {
    private Conexion miConexion;
    public ResultSet rs;

    public CargaMenus() {
        miConexion = new Conexion();
    }

    public ResultSet ejecutaConsultas() {
        Connection accesoBBDD = miConexion.dameConexion();

        try {
            Statement stateSecciones = accesoBBDD.createStatement();

            return rs = stateSecciones.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS ORDER BY SECCIÓN");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
