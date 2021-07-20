<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Document</title>
</head>
<body>
    

    <%

    request.setCharacterEncoding("UTF-8");
    String nombre=request.getParameter("nombre");
    String apellido=request.getParameter("apellido");
    String usuario=request.getParameter("usuario");
    String contra=request.getParameter("contra");
    String pais=request.getParameter("pais");
    String tecno=request.getParameter("tecnologias");
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    try{
    java.sql.Connection miConexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "phpmyadmin", ".admin1234.");
    java.sql.Statement miStatement = miConexion.createStatement();

    String instruccionSQL = "INSERT INTO usuarios (Nombre, Apellido, Usuario, Contrasena, Pais, Tecnologia) VALUES ('"+nombre+"', '"+apellido+"', '"+usuario+"', '"+contra+"', '"+pais+"', '"+tecno+"')";

    miStatement.executeUpdate(instruccionSQL);
    out.println("Registrado con éxito");
    }catch(Exception e){
        out.println("Ha ocurrido un error");
        e.printStackTrace();
    }
    %>

</body>
</html>