package com.rubo.productos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
    private DataSource fuenteDatos;
    private Connection miConexion = null;
    private Statement miStatement = null;

    public ModeloProductos(DataSource fuenteDatos) {
        this.fuenteDatos = fuenteDatos;
    }

    public List<Productos> getProductos() throws Exception {
        List<Productos> productsList = new ArrayList<Productos>();
        ResultSet rs = null;

        try {
            // Establecer conexión
            miConexion = fuenteDatos.getConnection();

            // Crear sentencia SQL y Statement
            String instruccionSql = "SELECT * FROM PRODUCTOS";
            miStatement = miConexion.createStatement();

            // Ejecutar query y almacenar en ResultSet
            rs = miStatement.executeQuery(instruccionSql);

            // Recorrer el ResultSet
            while (rs.next()) {
                Productos tempProduct = new Productos(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getDate(5), rs.getString(6), rs.getString(7));
                productsList.add(tempProduct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productsList;
    }

    public void agregarNuevoProducto(Productos nuevoProducto) {
        String instruccionSql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN)"
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement prepStatement = miConexion.prepareStatement(instruccionSql);
            prepStatement.setString(1, nuevoProducto.getCodArt());
            prepStatement.setString(2, nuevoProducto.getSeccion());
            prepStatement.setString(3, nuevoProducto.getNombreArt());
            prepStatement.setDouble(4, nuevoProducto.getPrecio());

            Date fechaConvertida = new Date(nuevoProducto.getFecha().getTime());
            prepStatement.setDate(5, fechaConvertida);

            prepStatement.setString(6, nuevoProducto.getImportado());
            prepStatement.setString(7, nuevoProducto.getPaisOrigen());

            prepStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
