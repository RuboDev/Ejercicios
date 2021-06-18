package arraylist;

import java.io.File;

public class UsoArrayList {
    public static void main(String[] args) {
        ArrayList archivos = new ArrayList(4);
        archivos.add("Juan");
        archivos.add("María");
        archivos.add("Ana");
        archivos.add("Sandra");
        archivos.add(new File("gestion_Pedidos.accdb"));

        String nombrePersona = (String) archivos.get(4); // -> no compile-time error, inconvenient
                                                         // -> also inconvenient castings
        // archivos.add(new File("gestion_Pedidos.accdb"));
        // File nombrePersona = (File) archivos.get(0);

        System.out.println(nombrePersona);

    }
}
