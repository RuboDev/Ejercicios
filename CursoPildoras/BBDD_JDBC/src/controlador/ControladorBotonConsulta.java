package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import modelo.EjecutaConsultas;
import vista.Marco_Aplicacion2;

public class ControladorBotonConsulta implements ActionListener {
    private Marco_Aplicacion2 elmarco;
    EjecutaConsultas obj = new EjecutaConsultas();

    public ControladorBotonConsulta(Marco_Aplicacion2 elmarco) {
        this.elmarco = elmarco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        elmarco.areaTexto.setText("");
        String seleccionSeccion = (String) elmarco.seccion.getSelectedItem();
        String seleccionPais = (String) elmarco.pais.getSelectedItem();

        ResultSet rs = obj.filtraBBDD(seleccionSeccion, seleccionPais);
        try {
            while (rs.next()) {
                elmarco.areaTexto.append(rs.getString(1));
                elmarco.areaTexto.append(", ");
                elmarco.areaTexto.append(rs.getString(2));
                elmarco.areaTexto.append(", ");
                elmarco.areaTexto.append(rs.getString(3));
                elmarco.areaTexto.append("€, ");
                elmarco.areaTexto.append(rs.getString(4));
                elmarco.areaTexto.append("\n");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

}
