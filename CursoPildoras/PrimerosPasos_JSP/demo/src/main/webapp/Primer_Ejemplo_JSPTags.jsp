<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String alumnos[]={"Antonio", "Sandra", "María", "Paco"};
pageContext.setAttribute("losAlumnos", alumnos);
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <c:forEach items="${losAlumnos}" var="tempAlumnos">
        ${tempAlumnos} <br>
    </c:forEach>
</body>
</html>