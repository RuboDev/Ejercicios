package excepciones_I;

import java.io.EOFException;

import javax.swing.JOptionPane;

public class CompruebaMail {
    public static void main(String[] args) {
        String mail = JOptionPane.showInputDialog("Introduce mail");
        try {
            examinaMail(mail);
        } catch (EOFException e) {
            System.out.println("La direccion de email no es correcta.");
        }
    }

    static void examinaMail(String mail) throws EOFException {
        int arroba = 0;
        boolean punto = false;

        if (mail.length() <= 3) {

            throw new EOFException(); // sentencia throw para lanzar un objeto excepcion de forma manual
            /*
             * seria mejor crear una excepcion propia, que se ajuste mejor a lo que queremos
             * hacer
             */
        } else {

            for (int i = 0; i < mail.length(); i++) {
                if (mail.charAt(i) == '@') {
                    arroba++;
                }

                if (mail.charAt(i) == '.') {
                    punto = true;
                }
            }

            if (arroba == 1 && punto == true) {
                System.out.println("Es correcto");
            } else {
                System.out.println("No es correcto");
            }
        }
    }
}
