package procAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Actualiza_Productos {
    public static void main(String[] args) {
        double nPrecio = Double.parseDouble(JOptionPane.showInputDialog("Introduce precio"));
        String nArticulo = JOptionPane.showInputDialog("Introduce nombre artículo");

        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            // Creamos un CallableStatement para ejecutar prodecimientos almacenados,
            // también llamados rutinas.
            CallableStatement miStatement = miConexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");
            miStatement.setDouble(1, nPrecio);
            miStatement.setString(2, nArticulo);
            miStatement.executeQuery();

            System.out.println("OK. Precio Actualizado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}