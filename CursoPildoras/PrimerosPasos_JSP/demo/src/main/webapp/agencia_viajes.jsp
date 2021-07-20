<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1 style="text-align:center">Agencia de viajes</h1>
    <%
    //Valor por defecto
    String ciudad_favorita="Madrid";

    // Lee la cookie de la petición del navegador
    Cookie[] arrayCookies= request.getCookies();

    // Buscar las preferencias. La ciudad favorita en este caso
    if(arrayCookies != null){
        for(Cookie cookieTemp : arrayCookies){
            if("agencia_viajes.ciudad_favorita".equals(URLDecoder.decode(cookieTemp.getName(), "UTF-8"))){
                ciudad_favorita = URLDecoder.decode(cookieTemp.getValue(), "UTF-8");
                break;
            }
        }
    }
    %>

    <h3> Vuelos a <%= ciudad_favorita %><h3>
    <p> Esto es un texto de ejemplo</p> <!-- Aquí debería mostrarse info en funcion de una consulta a una BBDD-->
    <p> Esto es un texto de ejemplo</p>
    <p> Esto es un texto de ejemplo</p>

    <h3> Hoteles en <%= ciudad_favorita %><h3>
    <p> Esto es un texto de ejemplo</p> <!-- Aquí debería mostrarse info en funcion de una consulta a una BBDD-->
    <p> Esto es un texto de ejemplo</p>
    <p> Esto es un texto de ejemplo</p>

    <h3> Descuentos en restaurantes de <%= ciudad_favorita %><h3>
    <p> Esto es un texto de ejemplo</p> <!-- Aquí debería mostrarse info en funcion de una consulta a una BBDD-->
    <p> Esto es un texto de ejemplo</p>
    <p> Esto es un texto de ejemplo</p>

</body>
</html>