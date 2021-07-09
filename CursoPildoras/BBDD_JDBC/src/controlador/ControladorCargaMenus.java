package controlador;

import java.awt.event.*;
import java.sql.ResultSet;

import modelo.CargaMenus;
import vista.Marco_Aplicacion2;

public class ControladorCargaMenus extends WindowAdapter {
    CargaMenus chargeSecciones = new CargaMenus();
    private Marco_Aplicacion2 elmarco;

    public ControladorCargaMenus(Marco_Aplicacion2 elmarco) {
        this.elmarco = elmarco;
    }

    public void windowOpened(WindowEvent e) {

        ResultSet[] bothRS = chargeSecciones.ejecutaConsultas();

        ResultSet rs1 = bothRS[0];
        ResultSet rs2 = bothRS[1];

        try {
            while (rs1.next()) {
                elmarco.seccion.addItem(rs1.getString(1));
            }

            while (rs2.next()) {
                elmarco.pais.addItem(rs2.getString(1));
            }
            rs1.close();
            rs2.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
