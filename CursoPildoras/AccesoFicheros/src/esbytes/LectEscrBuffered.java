package esbytes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LectEscrBuffered {
    public static void main(String[] args) {
        int cont = 0;
        int datosEntrada[] = new int[20993];

        try {
            // archivo con path no hardcodeado.
            Path path = Paths.get("src", "img");
            String pathStr = path.toString();
            File fileNoHardCode = new File(pathStr, "gato.jpg");

            FileInputStream archivoLectura = new FileInputStream(fileNoHardCode);
            BufferedInputStream streamBuffereado = new BufferedInputStream(archivoLectura);

            boolean finalAr = false;

            while (!finalAr) {
                int byteEntrada = streamBuffereado.read();

                if (byteEntrada != -1) {
                    datosEntrada[cont] = byteEntrada;
                    cont++;
                } else {
                    finalAr = true;
                }

            }
            streamBuffereado.close();
            archivoLectura.close();
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo");
        }

        System.out.println(cont + " Bytes");

        creaFichero(datosEntrada);
    }

    static void creaFichero(int datosNewFichero[]) {
        try {
            FileOutputStream fichero_nuevo = new FileOutputStream("src/img/gato_copia.jpg");
            BufferedOutputStream streamOutBuffereado = new BufferedOutputStream(fichero_nuevo);
            for (int i = 0; i < datosNewFichero.length; i++) {
                streamOutBuffereado.write(datosNewFichero[i]);
            }
            streamOutBuffereado.close();
            fichero_nuevo.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }
    }
}
