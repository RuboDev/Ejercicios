package com.rubo.servletpruebas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControladorServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] productos = { "Destornillador", "Serrucho", "Tornillo", "Taladro" };
        req.setAttribute("lista_productos", productos);
        RequestDispatcher miDispatcher=req.getRequestDispatcher("/VistaJSP.jsp");
        miDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}