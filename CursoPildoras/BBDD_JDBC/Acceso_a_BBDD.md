*Pre-requisitos: (para BBDD mysql)*
1. Instalar y configurar servidor de pruebas y SGDB mysql.
2. Instalar driver JDBC MySQL
3. Agregar driver al classpath del proyecto.
# Acceso a Bases de Datos - Java DataBase Connectivity

**Paquetes:** `java.sql` y `javax.sql`

**Clases e interfaces:** `DriverManager`, *`ResulSet`*, *`Connection`*, *`Statement`*, *`DataSource`*.

## *Pasos para el acceso a BBDD*
1. Establecer conexión con la BBDD
2. Crear un objeto Statement
3. Ejecutar sentencia SQL
4. Leer el resultset