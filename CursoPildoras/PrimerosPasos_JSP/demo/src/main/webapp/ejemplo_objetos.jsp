<html>
    <body>
    <h2>Objetos predefinidos JSP</h2>
    Petición datos del navegador: <%= request.getHeader("User-Agent") %>
    <br>
    Petición idioma utilizado: <%= request.getLocale() %>
    </body>
</html>