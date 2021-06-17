package ficheros_directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {
    public static void main(String[] args) {
        File ruta = new File("/home/rubo/Escritorio/carpetaConCosas/archivoCreado.txt");
        // ruta.mkdir();
        String archivodestino = ruta.getAbsolutePath();
        try {
            ruta.createNewFile();
        } catch (Exception e) {
        }

        Escribiendo accede_es = new Escribiendo();
        accede_es.escribir(archivodestino);
    }
}

class Escribiendo {
    public void escribir(String rutaArchivo) {
        String frase = "Esto es un ejemplo.";
        try {
            FileWriter escritura = new FileWriter(rutaArchivo);
            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (IOException e) {

        }
    }
}
