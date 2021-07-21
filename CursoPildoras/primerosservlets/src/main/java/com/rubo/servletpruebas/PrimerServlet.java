package com.rubo.servletpruebas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PrimerServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public PrimerServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Especificamos formato de respuesta
        PrintWriter salida=resp.getWriter();

        // Generar respuesta de la petición
        salida.println("<html><body>");
        salida.println("<h1 style='text-align:center'>Prueba Servlet</h1>");
        salida.println("");
        salida.println("");
        salida.println("");
        salida.println("");
        salida.println("Fecha y hora actual: "+new Date());
        salida.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    
}
