package com.rubo.productos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
    private DataSource fuenteDatos;

    public ModeloProductos(DataSource fuenteDatos) {
        this.fuenteDatos = fuenteDatos;
    }

    public List<Productos> getProductos() throws Exception {
        List<Productos> productsList = new ArrayList<Productos>();
        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet rs = null;

        try {
            // Establecer conexión
            miConexion = fuenteDatos.getConnection();

            // Crear sentencia SQL y Statement
            String instruccionSql="SELECT * FROM PRODUCTOS";
            miStatement = miConexion.createStatement();

            // Ejecutar query y almacenar en ResultSet
            rs = miStatement.executeQuery(instruccionSql);

            // Recorrer el ResultSet
            while(rs.next()){
                Productos tempProduct = new Productos(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getString(6), rs.getString(7));
                productsList.add(tempProduct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productsList;
    }
}
