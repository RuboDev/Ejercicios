<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>

    table{
        float:left;
    }

    #contenedorBoton{
        margin-left: 1000px;
    }
    </style>
</head>

<body>
    <table border="1">
    <tr>
        <td>CÓDIGOARTÍCULO</td>
        <td>SECCIÓN</td>
        <td>NOMBREARTÍCULO</td>
        <td>PRECIO</td>
        <td>FECHA</td>
        <td>IMPORTADO</td>
        <td>PAÍSDEORIGEN</td>
    </tr>
    <c:forEach items="${lista_productos}" var="tempList">
        <tr>
            <td>
                ${tempList.codArt}
            </td>
            <td>
                ${tempList.seccion}
            </td>
            <td>
                ${tempList.nombreArt}
            </td>
            <td>
                ${tempList.precio}
            </td>
            <td>
                ${tempList.fecha}
            </td>
            <td>
                ${tempList.importado}
            </td>
            <td>
                ${tempList.paisOrigen}
            </td>
            <!-- rest of you columns data-->
        </tr>
    </c:forEach>
    </table>

    <div id="contenedorBoton">
        <input type="button" value="Insertar Registro" onclick="window.location.href='inserta_producto.jsp'">
    </div>
</body>
</html>