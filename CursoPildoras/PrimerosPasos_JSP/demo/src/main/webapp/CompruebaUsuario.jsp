<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Document</title>
</head>
<body>
    
    <%@ page import="java.sql.*" %>

    <%

    request.setCharacterEncoding("UTF-8");
    
    String usuario=request.getParameter("usuario");
    String contra=request.getParameter("contra");
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    try{
    Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "phpmyadmin", ".admin1234.");
    PreparedStatement c_preparada = miConexion.prepareStatement("SELECT * FROM usuarios WHERE Usuario=? AND Contrasena=?");

    c_preparada.setString(1, usuario);
    c_preparada.setString(2, contra);

    ResultSet rs = c_preparada.executeQuery();

    if(rs.next()){
        out.println("Usuario autorizado");
    }else{
        out.println("El usuario no existe o la contraseña es incorrecta");
    }
    rs.close();

    }catch(Exception e){
        out.println("Ha ocurrido un error");
        e.printStackTrace();
    }
    %>

</body>
</html>