package excepciones_I;

import javax.swing.JOptionPane;

public class CompruebaMail {
    public static void main(String[] args) {
        String mail = JOptionPane.showInputDialog("Introduce mail");
        try {
            examinaMail(mail);
        } catch (LongitudMailErronea e) {
            e.printStackTrace();
            // System.out.println(e.getMessage());
            // System.out.println("La direccion de email no es correcta.");
        }
    }

    static void examinaMail(String mail) throws LongitudMailErronea {
        int arroba = 0;
        boolean punto = false;

        if (mail.length() <= 3) {
            // sentencia throw para lanzar un objeto
            throw new LongitudMailErronea("El mail no puede tener menos de 4 caracteres");
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

class LongitudMailErronea extends Exception { // creamos nuestra propia exception
    public LongitudMailErronea() {
        super();
    }

    public LongitudMailErronea(String msgError) {
        super(msgError);
    }
}
