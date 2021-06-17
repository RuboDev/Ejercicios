package ficheros_directorios;

import java.io.File;

public class ListarFicheros {
    public static void main(String[] args) {
        File ruta = new File("/home/rubo/Escritorio/carpetaConCosas");
        String[] lista = ruta.list();

        System.out.println("Files in " + ruta);

        for (String fileordir : lista) {
            File rutasIn = new File(ruta, fileordir);
            System.out.println(fileordir + " (isDirectory:" + rutasIn.isDirectory() + ")");

            if (rutasIn.isDirectory()) {
                System.out.println("Files in " + rutasIn);
                String[] listIn = rutasIn.list();

                for (String fileordir2 : listIn) {
                    System.out.println(fileordir2);
                }
            }
        }
    }
}
