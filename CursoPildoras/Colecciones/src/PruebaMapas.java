import java.util.HashMap;

public class PruebaMapas {
    public static void main(String[] args) {
        HashMap<String, Empleado> personal = new HashMap<String, Empleado>();
        personal.put("145", new Empleado("Juan"));
        personal.put("146", new Empleado("Ana"));
        personal.put("147", new Empleado("Antonio"));
        personal.put("148", new Empleado("Sandra"));

        System.out.println(personal);

        personal.remove("147");
        System.out.println(personal);

        personal.put("148", new Empleado("Natalia"));
        System.out.println(personal);
    }
}

class Empleado {
    private String nombre;
    private double sueldo;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.sueldo = 2000;
    }

    public String toString() {
        return "[Nombre=" + nombre + ", sueldo=" + sueldo + "]";
    }
}