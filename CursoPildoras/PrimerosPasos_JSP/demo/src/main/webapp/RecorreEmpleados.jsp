<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder, java.util.*, java.sql.*, com.rubo.jsptags.Empleado" %>

<%
    ArrayList<Empleado> datos=new ArrayList<>();
    Class.forName("com.mysql.cj.jdbc.Driver");
    try{
        Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "phpmyadmin", ".admin1234.");
        Statement miStatement = miConexion.createStatement();
        String instruccionSQL="SELECT * FROM empleados";
        ResultSet rs= miStatement.executeQuery(instruccionSQL);

        while(rs.next()){
            datos.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
        }
        rs.close();
        miConexion.close();
    }catch(Exception e){
        out.println("Ha habido un error");
    }

    pageContext.setAttribute("losEmpleados", datos);
%>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <style>
    .cabecera{
        font-weight:bold;
    }
    </style>
</head>
<body>

    <table border="1">
        <tr class="cabecera"><td>Nombre</td><td>Apellido</td><td>Puesto</td><td>Salario</td></tr>
        <c:forEach items="${losEmpleados}" var="EmpTemp">
            <tr>
            <td>${EmpTemp.getNombre()}</td> <td>${EmpTemp.getApellido()}</td> <td>${EmpTemp.getPuesto()}</td> <td>${EmpTemp.getSalario()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>