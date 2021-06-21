package clases_propias;

public class UsoPareja {
    public static void main(String[] args) {
        // La clase genérica Pareja<> se adapta a los objetos, en este caso String
        Pareja<String> una = new Pareja<String>();
        una.setPrimero("Juan");
        System.out.println(una.getPrimero());
        // ----------------------------------------------
        // En este caso objeto Persona
        Persona pers1 = new Persona("Ana");
        Pareja<Persona> otra = new Pareja<Persona>();
        otra.setPrimero(pers1);
        System.out.println(otra.getPrimero().toString());
    }
}

class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return this.nombre;
    }
}