package leyendo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccesoFichero {
    public static void main(String[] args) {
        LeerFichero accediendo = new LeerFichero();
        accediendo.lee();
    }
}

class LeerFichero {
    public void lee() {
        try {
            FileReader entrada = new FileReader("src/ejemplo.txt"); /*
                                                                     * el archivo puede estar en cualquier ruta, pero
                                                                     * queria guardar el archivo en el proyecto
                                                                     */

            int c = entrada.read();

            while (c != -1) {
                char letra = (char) c;
                System.out.print(letra);
                c = entrada.read();
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
        }
    }
}
