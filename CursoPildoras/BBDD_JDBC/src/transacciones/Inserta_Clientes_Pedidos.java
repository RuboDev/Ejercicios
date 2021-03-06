package transacciones;

import java.sql.*;

public class Inserta_Clientes_Pedidos {
	public static void main(String[] args) {
		Connection miConexion = null;
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
			miConexion.setAutoCommit(false); // Seteamos en false para que los statements NO sean ejecutados y
												// commiteados individualmente

			Statement miStatement = miConexion.createStatement();

			String instruccionSql_1 = "INSERT INTO clientes (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			miStatement.executeUpdate(instruccionSql_1);

			String instruccionSql_2 = "INSERT INTO pedidos (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";
			miStatement.executeUpdate(instruccionSql_2);

			miConexion.commit(); // Realizamos todos los cambios desde el commit o rollback previo en esta
									// conexion.

			System.out.println("Datos INSERTADOS correctamente");
		} catch (Exception e) {
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
			try {
				miConexion.rollback();// Deshace todos los cambios de la transaccion actual para evitar inserciones
										// indeseadas.
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
