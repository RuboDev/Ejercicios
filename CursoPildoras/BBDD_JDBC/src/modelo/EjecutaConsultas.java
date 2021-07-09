package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EjecutaConsultas {
    private Conexion miConexion = new Conexion();
    private ResultSet rs;
    private PreparedStatement prepStateSeccion, prepStatePais, prepStateAmbos, prepStateNinguno;
    private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
    private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
    private final String consultaAmbos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
    private final String consultaNinguno = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS";

    public ResultSet filtraBBDD(String seccion, String pais) {

        Connection conecta = miConexion.dameConexion();
        rs = null;

        try {
            if (!seccion.equals("Todos") && pais.equals("Todos")) {
                prepStateSeccion = conecta.prepareStatement(consultaSeccion);
                prepStateSeccion.setString(1, seccion);
                rs = prepStateSeccion.executeQuery();
            } else if (seccion.equals("Todos") && !pais.equals("Todos")) {
                prepStatePais = conecta.prepareStatement(consultaPais);
                prepStatePais.setString(1, pais);
                rs = prepStatePais.executeQuery();
            } else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
                prepStateAmbos = conecta.prepareStatement(consultaAmbos);
                prepStateAmbos.setString(1, seccion);
                prepStateAmbos.setString(2, pais);
                rs = prepStateAmbos.executeQuery();
            } else {
                prepStateNinguno = conecta.prepareStatement(consultaNinguno);
                rs = prepStateNinguno.executeQuery();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
