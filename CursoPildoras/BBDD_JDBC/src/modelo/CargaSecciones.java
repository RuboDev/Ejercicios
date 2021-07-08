package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import controlador.Conexion;

public class CargaSecciones {
    private Conexion miConexion;
    private ResultSet rs;

    public CargaSecciones() {
        miConexion = new Conexion();
    }

    public String ejecutaConsultas() {
        Productos miProducto = null;
        Connection accesoBBDD = miConexion.dameConexion();

        try {
            Statement stateSecciones = accesoBBDD.createStatement();

            rs = stateSecciones.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS ORDER BY SECCIÓN");

            while (rs.next()) {
                miProducto = new Productos();
                miProducto.setSeccion(rs.getString(1));
                return miProducto.getSeccion();
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return miProducto.getSeccion();
    }
}
