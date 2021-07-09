package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CargaMenus {
    private Conexion miConexion;

    public CargaMenus() {
        miConexion = new Conexion();
    }

    public ResultSet[] ejecutaConsultas() {
        Connection accesoBBDD = miConexion.dameConexion();
        ResultSet[] ambosResultSet = new ResultSet[2];

        try {
            Statement stateSecciones = accesoBBDD.createStatement();
            Statement statePaises = accesoBBDD.createStatement();
            ambosResultSet[0] = stateSecciones.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS ORDER BY SECCIÓN");
            ambosResultSet[1] = statePaises.executeQuery("SELECT DISTINCT PAÍSDEORIGEN FROM PRODUCTOS ORDER BY PAÍSDEORIGEN");

            return ambosResultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
