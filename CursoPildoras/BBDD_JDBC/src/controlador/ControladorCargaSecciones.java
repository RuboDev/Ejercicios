package controlador;

import java.awt.event.*;
import java.sql.ResultSet;

import modelo.CargaSecciones;
import vista.Marco_Aplicacion2;

public class ControladorCargaSecciones extends WindowAdapter {
    CargaSecciones chargeSecciones = new CargaSecciones();
    private Marco_Aplicacion2 elmarco;

    public ControladorCargaSecciones(Marco_Aplicacion2 elmarco) {
        this.elmarco = elmarco;
    }

    public void windowOpened(WindowEvent e) {

        ResultSet rs = chargeSecciones.ejecutaConsultas();
        try {
            while (rs.next()) {
                elmarco.seccion.addItem(rs.getString(1));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
