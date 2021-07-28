package introspeccion;

public class UsoEmpleado {
    public static void main(String[] args) {
        Persona antonio = new Persona("Antonio");
        System.out.println(antonio.getNombre());
        Empleado ana = new Empleado("Ana", 35000);
        System.out.println(ana.getNombre());
        System.out.println(ana.getSalario());

        // System.out.println(antonio.getClass());
        /*
         * Class<? extends Persona> cl1=antonio.getClass();
         * System.out.println(cl1.getName());
         */
        String nombreClase = "introspeccion.Persona";
        Class<?> cl1;
        try {
            cl1 = Class.forName(nombreClase);
            System.out.println(cl1.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        nombreClase = "introspeccion.Empleado";

        try {
            cl1 = Class.forName(nombreClase);
            System.out.println(cl1.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}

class Empleado extends Persona {
    private double salario;

    public Empleado(String nombre, double salario) {
        super(nombre);
        this.salario = salario;
    }

    public void setIncentivo(double incentivo) {
        salario = salario + incentivo;
    }

    public String getSalario() {
        return "El salario es: " + salario;
    }
}