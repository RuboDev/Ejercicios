import java.util.TreeSet;

public class PruebaTreeSet {
    public static void main(String[] args) {
        // TreeSet<String> ordenaPersonas = new TreeSet<String>();
        // ordenaPersonas.add("Sandra");
        // ordenaPersonas.add("Amanda");
        // ordenaPersonas.add("Diana");
        // for (String s : ordenaPersonas) {
        // System.out.println(s);
        // }

        Articulo primero = new Articulo(1, "Primer artículo");
        Articulo segundo = new Articulo(2, "Segundo artículo");
        Articulo tercer = new Articulo(3, "Tercer artículo");

        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        ordenaArticulos.add(tercer);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(segundo);

        for (Articulo article : ordenaArticulos) {
            System.out.println(article.getDescripcion());
        }
    }
}

class Articulo implements Comparable<Articulo> {
    private int num_articulo;
    private String descripcion;

    public Articulo(int num, String descr) {
        num_articulo = num;
        descripcion = descr;
    }

    @Override
    public int compareTo(Articulo o) {
        return num_articulo - o.num_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
