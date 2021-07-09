package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        elmarco.areaTexto.append(obj.filtraBBDD(seleccionSeccion, seleccionPais));
    }

}
