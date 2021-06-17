package ficheros_directorios;

import java.io.File;

public class Eliminar {
    public static void main(String[] args) {
        File ruta = new File("/home/rubo/Escritorio/carpetaConCosas/archivoCreado.txt");
        ruta.delete();
    }
}
