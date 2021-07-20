<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<html>

<body>
<form name="Formulario_Compra" action="Lista_Compra.jsp" method="post">
 
  <p>Artículos a comprar:</p>
  <p>
    <label>
      <input type="checkbox" name="articulos" value="agua " >
      Agua </label>
    <br>
    <label>
      <input type="checkbox" name="articulos" value="leche" >
      Leche </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="pan" >
      Pan </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="mazanas" >
      Manzanas </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="carne" >
      Carne </label>
      <br>
       <label>
      <input type="checkbox" name="articulos" value="pescado" >
      Pescado </label>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="Enviar">
    <br>
  </p>
</form>
<h2>Carro de la compra:</h2>
<ul>
<%
List<String> listadelacompra = (List<String>)session.getAttribute("miCompra");
if(listadelacompra == null){
  listadelacompra = new ArrayList<String>();
  session.setAttribute("miCompra", listadelacompra);
}

String[] elementos=request.getParameterValues("articulos");
if(elementos != null){
  for (String elemTemp : elementos){
    // out.println("<li>"+elemTemp+"</li>");
    listadelacompra.add(elemTemp);
  }
}

for (String elemTemp : listadelacompra){
out.println("<li>"+elemTemp+"</li>");
}


%>
</ul>

</body>

</html>