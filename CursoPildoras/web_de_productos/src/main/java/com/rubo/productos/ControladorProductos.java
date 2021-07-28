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
                break;

            case "modificar":
                updateProducto(req, resp);
                break;

            case "eliminar":
                deleteProducto(req, resp);
                break;

            default:
                obtenerProductos(req, resp);
        }

    }

    private void deleteProducto(HttpServletRequest req, HttpServletResponse resp) {
        // Leemos el parametro cArticulo
        String codArt = req.getParameter("cArticulo");
        // Pasamos el valor de cArticulo como parametro al modelo
        modprod.deleteProductByCodigo(codArt);

        // Volver al listado de Productos
        //obtenerProductos(req, resp);
        try {
            resp.sendRedirect("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProducto(HttpServletRequest req, HttpServletResponse resp) {
        // Leer la info del producto que viene del formulario de modificacion
        String codArticulo = req.getParameter("codeArticulo");
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
        // Pasar el producto al modelo para que setee los campos modificados.
        modprod.setFields(nuevoProducto);
        // Volver al listado de Productos
        obtenerProductos(req, resp);
    }

    private void selectProducto(HttpServletRequest req, HttpServletResponse resp) {
        // Leemos el parametro cArticulo
        String codArt = req.getParameter("cArticulo");
        // Pasamos el valor de cArticulo como parametro al modelo
        Productos prodXcodArticulo = modprod.selectProductByCodigo(codArt);

        // El modelo nos devuelve un y lo agregamos a la request
        req.setAttribute("producto", prodXcodArticulo);

        // Enviar ese request a la pagina JSP en la que modificaremos los campos.
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