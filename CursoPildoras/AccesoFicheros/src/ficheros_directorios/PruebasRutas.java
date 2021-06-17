package ficheros_directorios;

import java.io.File;

public class PruebasRutas {
    public static void main(String[] args) {
        File archivo = new File("src");
        System.out.println(archivo.getAbsolutePath());
        System.out.println(archivo.exists());
    }
}
