package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
    public static void main(String[] args) {
        EscribiendoC accedeEscritura = new EscribiendoC();
        accedeEscritura.escribir();
    }
}

class EscribiendoC {
    public void escribir() {
        String frase = "Esto es una prueba de escritura";
        try {
            FileWriter escritura = new FileWriter("src/textoNuevo.txt"); // volcamos argumentos ("path", true) para
                                                                         // escribir sin borrar lo que ya hay, sino se
                                                                         // sobreescribe lo que haya
                                                                         // escrito en el archivo.
            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }

            escritura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
