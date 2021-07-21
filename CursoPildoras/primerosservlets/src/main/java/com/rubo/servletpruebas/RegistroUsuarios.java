package com.rubo.servletpruebas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroUsuarios extends HttpServlet{
    static final long serialVersionUID = 1L;

    public RegistroUsuarios(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter salida = resp.getWriter();
        salida.println("<html><body>");
        salida.println("Nombre introducido: " + req.getParameter("nombre"));
        salida.println("<br>");
        salida.println("Apellido introducido: " + req.getParameter("apellido"));
        salida.println("</html></body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter salida = resp.getWriter();
        salida.println("<html><body>");
        salida.println("Nombre introducido: " + req.getParameter("nombre"));
        salida.println("<br>");
        salida.println("Apellido introducido: " + req.getParameter("apellido"));
        salida.println("</html></body>");
    }
}
