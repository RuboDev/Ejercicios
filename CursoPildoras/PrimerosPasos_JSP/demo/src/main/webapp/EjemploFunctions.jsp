<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.net.URLDecoder, java.util.*, java.sql.*, com.rubo.jsptags.Empleado" %>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <c:set var="datos" value="Ana,López,Directora,75000"/>
    <c:set var="datosArray" value="${fn:split(datos, ',')}"/>
    <input type="text" value="${datosArray[0]}"><br>
    <input type="text" value="${datosArray[1]}"><br>
    <input type="text" value="${datosArray[2]}"><br>
    <input type="text" value="${datosArray[3]}">
</body>
</html>