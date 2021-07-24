package com.rubo.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Definir o establecer el DataSource
    @Resource(name = "jdbc/Productos")
    private DataSource miPool;

    public ServletPruebas() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Crear el obj PrintWriter
        PrintWriter salida=resp.getWriter();
        resp.setContentType("text/plain");

        //Crear conexion con BBDD
        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet rs = null;

        try {
            miConexion = miPool.getConnection();
            String instruccionSql="SELECT * FROM PRODUCTOS";
            miStatement = miConexion.createStatement();
            rs = miStatement.executeQuery(instruccionSql);

            while(rs.next()){
                String nombre_articulo = rs.getString(3);
                salida.println(nombre_articulo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}