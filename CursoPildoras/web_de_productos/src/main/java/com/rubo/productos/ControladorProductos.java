package com.rubo.productos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        // Leer el parámetro del formulario
        String elComando = req.getParameter("instruccion");

        // si no se envia el parametro, listar productos
        if (elComando == null)
            elComando = "listar";

        // Redirigir el flujo de ejecucion al metodo adecuado
        switch (elComando) {
            case "listar":
                obtenerProductos(req, resp);
                break;

            case "insertarBBDD":
                insertarProducto(req, resp);
                break;

            case "seleccionar":
                selectProducto(req, resp);
            
            case "modificar":
                updateProducto(req, resp);

            default:
                obtenerProductos(req, resp);
        }

    }

    private void updateProducto(HttpServletRequest req, HttpServletResponse resp) {
        // leer la info del producto que viene del formulario
        String codArticulo = req.getParameter("cArticulo");
        String seccion = req.getParameter("seccion");
        String nombreArticulo = req.getParameter("nombreArt");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoFecha.parse(req.getParameter("fecha"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        double precio = Double.parseDouble(req.getParameter("precio"));
        String importado = req.getParameter("importado");
        String paisOrigen = req.getParameter("paisOrigen");

        // Crear un objeto de tipo Producto
        Productos nuevoProducto = new Productos(codArticulo, seccion, nombreArticulo, precio, fecha, importado,
                paisOrigen);
        modprod.setFields(nuevoProducto);
        // Volver al listado de Productos
        obtenerProductos(req, resp);
    }

    private void selectProducto(HttpServletRequest req, HttpServletResponse resp) {

        String codArt = req.getParameter("cArticulo");
        Productos prodXcodArticulo = modprod.selectProductByCodigo(codArt);
        // obtenerProductos(req, resp);

        // Agregar producto al request
        req.setAttribute("producto", prodXcodArticulo);

        // Enviar ese request a la pagina JSP
        try {
            RequestDispatcher miDispatcher = req.getRequestDispatcher("/modifica_producto.jsp");
            miDispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertarProducto(HttpServletRequest req, HttpServletResponse resp) {
        // leer la info del producto que viene del formulario
        String codArticulo = req.getParameter("codArt");
        String seccion = req.getParameter("seccion");
        String nombreArticulo = req.getParameter("nombreArt");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoFecha.parse(req.getParameter("fecha"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        double precio = Double.parseDouble(req.getParameter("precio"));
        String importado = req.getParameter("importado");
        String paisOrigen = req.getParameter("paisOrigen");

        // Crear un objeto de tipo Producto
        Productos nuevoProducto = new Productos(codArticulo, seccion, nombreArticulo, precio, fecha, importado,
                paisOrigen);

        // Enviar el objeto al modelo y despues insertar el objeto Producto en la BBDD
        modprod.agregarNuevoProducto(nuevoProducto);
        // Volver al listado de Productos
        obtenerProductos(req, resp);
    }

    private void obtenerProductos(HttpServletRequest req, HttpServletResponse resp) {
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