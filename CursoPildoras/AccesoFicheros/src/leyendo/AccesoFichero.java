package leyendo;

import java.io.BufferedReader;
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
            BufferedReader mibuffer = new BufferedReader(entrada);
            String linea = "";

            while (linea != null) {
                linea = mibuffer.readLine();
                if (linea != null) {
                    System.out.println(linea);
                }
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
        }
    }
}
