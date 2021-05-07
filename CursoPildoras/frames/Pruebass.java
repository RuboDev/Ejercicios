import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class Pruebass {
    public static void main(String[] args) {
        // Bucle para comprobar Fuentes instaladas en el sistema.
        String fuente = JOptionPane.showInputDialog("Introduce fuente");
        boolean estalafuente = false;

        String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String nombredelafuente : nombresDeFuentes) {
            if (nombredelafuente.equals(fuente)) {
                estalafuente = true;

            }

            // System.out.println(nombredelafuente);
        }

        if (estalafuente) {
            System.out.println("Fuente instalada");

        } else {
            System.out.println("No está la fuente");
        }
    }
}
