package esbytes;

import java.io.FileInputStream;
import java.io.IOException;

public class LecturaEscritura {
    public static void main(String[] args) {
        int cont = 0;
        int datosEntrada[] = new int[20994];

        try {
            FileInputStream archivoLectura = new FileInputStream("/home/rubo/Descargas/gato.jpg");
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
    }
}