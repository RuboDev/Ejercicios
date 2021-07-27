<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1 style="text-align:center">Modificar Registros ${producto.codArt}</h1>
    <form name="form1" action="ControladorProductos" method="GET">
    <input type="hidden" name="instruccion" value="modificar">
        <table width="50%" border="0">

            <tr>
                <td>Sección</td>
                <td><label for="seccion"></label>
                <input type="text" name="seccion" id="seccion" value="${producto.seccion}"></td>
            </tr>

            <tr>
                <td>Nombre Artículo</td>
                <td><label for="nombreArt"></label>
                <input type="text" name="nombreArt" id="nombreArt" value="${producto.nombreArt}"></td>
            </tr>

            <tr>
                <td>Fecha</td>
                <td><label for="fecha"></label>
                <input type="text" name="fecha" id="fecha" value="${producto.fecha}"></td>
            </tr>

            <tr>
                <td>Precio</td>
                <td><label for="precio"></label>
                <input type="text" name="precio" id="precio" value="${producto.precio}"></td>
            </tr>

            <tr>
                <td>Importado</td>
                <td><label for="importado"></label>
                <input type="text" name="importado" id="importado" value="${producto.importado}"></td>
            </tr>

            <tr>
                <td>País de Origen</td>
                <td><label for="paisOrigen"></label>
                <input type="text" name="paisOrigen" id="paisOrigen" value="${producto.paisOrigen}"></td>
            </tr>

            <tr>
                <td><input type="submit" name="envio" id="envio" value="Enviar"></td>
                <td><input type="reset" name="borrar" id="borrar" value="Restablecer"></td>
            </tr>
        </table>
    </form>
</body>
</html>