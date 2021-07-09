package transacciones;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Transaccion_Productos {
    public static void main(String[] args) {
        Connection miConexion = null;
        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
            miConexion.setAutoCommit(false); // Seteamos en false para que los statements NO sean ejecutados y
                                             // commiteados individualmente

            Statement miStatement = miConexion.createStatement();

            String instruccionSql_1 = "DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN='ITALIA'";
            String instruccionSql_2 = "DELETE FROM PRODUCTOS WHERE PECIO>300";
            String instruccionSql_3 = "UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";

            boolean ejecutar = ejecutar_transaccion();
            if (ejecutar) {
                miStatement.executeUpdate(instruccionSql_1);
                miStatement.executeUpdate(instruccionSql_2);
                miStatement.executeUpdate(instruccionSql_3);

                miConexion.commit();
                System.out.println("Se ejecutó la transacción correctamente");
            } else {
                System.out.println("No se realizó ningún cambio en la Base de Datos");
            }

        } catch (Exception e) {
            try {
                miConexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("ERROR. Algo salió mal y no se realizaron los cambios en la Base de Datos");
            e.printStackTrace();
        }

    }

    static boolean ejecutar_transaccion() {
        String ejecucion = JOptionPane.showInputDialog("¿Ejecutamos transacción?");
        if (ejecucion.equals("Sí"))
            return true;
        else
            return false;
    }
}
