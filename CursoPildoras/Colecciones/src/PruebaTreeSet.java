import java.util.Comparator;
import java.util.TreeSet;

public class PruebaTreeSet {
    public static void main(String[] args) {

        Articulo primero = new Articulo(1, "Primer artículo");
        Articulo segundo = new Articulo(200, "Segundo artículo");
        Articulo tercer = new Articulo(3, "Tercer artículo");

        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        ordenaArticulos.add(tercer);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(segundo);

        for (Articulo article : ordenaArticulos) {
            System.out.println(article.getDescripcion());
        }

        // Articulo comparadorArticulos = new Articulo();
        // TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos);

        // ComparadorArticulos compara_article = new ComparadorArticulos();
        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(new Comparator<Articulo>() {
            @Override
            public int compare(Articulo o1, Articulo o2) {
                String desc1 = o1.getDescripcion();
                String desc2 = o2.getDescripcion();
                return desc1.compareTo(desc2);
            }
        });
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);
        ordenaArticulos2.add(tercer);

        for (Articulo article : ordenaArticulos2) {
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
