package ourfirstlogin.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegistroServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {

        PrintWriter writer;
        try {
            String nombreUser = req.getParameter("nombre");
            String apellidoUser = req.getParameter("apellido");

            // writer = res.getWriter();
            res.sendRedirect("/demo/jsp/Registro.jsp?nombre="+nombreUser+"&apellido="+apellidoUser);

            // writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
