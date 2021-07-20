<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<html>
<head>
<meta charset="UTF-8">
<title>Agencia Viajes</title>
</head>
<body>
<%
    // Leyendo datos del formulario
    String ciudad_favorita = request.getParameter("ciudad_favorita");

    //Crear la cookie
    Cookie laCookie = new Cookie("agencia_viajes.ciudad_favorita", URLEncoder.encode(ciudad_favorita, "UTF-8"));
    // Vida de la cookie
    laCookie.setMaxAge(365*24*60*60); // un año en segundos

    // Añadir la cookie a la respuesta
    response.addCookie(laCookie);
%>
Gracias por enviar tus preferencias
<a href="agencia_viajes.jsp">Ir a la agencia de viajes</a>
</body>
</html>