package com.rubo.productos;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ModeloProductos modprod;

    // Definir o establecer el DataSource
    @Resource(name = "jdbc/Productos")
    private DataSource miPool;

    public ControladorProductos() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            modprod = new ModeloProductos(miPool);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la lista de productos desde el modelo
        List<Productos> listaProductos;

        try {
            listaProductos = modprod.getProductos();

            // Agregar lista de productos al request
            req.setAttribute("lista_productos", listaProductos);

            // Enviar ese request a la pagina JSP
            RequestDispatcher miDispatcher = req.getRequestDispatcher("/ListaProductos.jsp");
            miDispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}