package excepciones_I;

import javax.swing.JOptionPane;

public class VariasExcepciones {
    public static void main(String[] args) {
        try {
            division();
        } catch (NumberFormatException e) {
            //System.out.println(e.getMessage());
            System.out.println("El dato introducido no es un Entero");
            System.out.println("Se ha generado un error de este tipo: "+e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por 0");
            //System.out.println(e.getClass());
        }
    }

    static void division() throws NumberFormatException, ArithmeticException {

        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));
        System.out.println("El resultado es: " + num1 / num2);

    }

}
