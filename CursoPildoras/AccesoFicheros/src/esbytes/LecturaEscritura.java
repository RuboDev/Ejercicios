package esbytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturaEscritura {
    public static void main(String[] args) {
        int cont = 0;
        int datosEntrada[] = new int[20993];

        try {
            FileInputStream archivoLectura = new FileInputStream("src/img/gato.jpg");
            boolean finalAr = false;

            while (!finalAr) {
                int byteEntrada = archivoLectura.read();

                if (byteEntrada != -1) {
                    datosEntrada[cont] = byteEntrada;
                    System.out.println(datosEntrada[cont]);
                    cont++;
                } else {
                    finalAr = true;
                }

            }
            archivoLectura.close();
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo");
        }

        System.out.println(cont);

        creaFichero(datosEntrada);
    }

    static void creaFichero(int datosNewFichero[]) {
        try {
            FileOutputStream fichero_nuevo = new FileOutputStream("src/img/gato_copia.jpg");
            for (int i = 0; i < datosNewFichero.length; i++) {
                fichero_nuevo.write(datosNewFichero[i]);
            }
            fichero_nuevo.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }
    }
}