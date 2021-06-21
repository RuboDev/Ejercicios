package clases_propias;

public class Pareja<T> {
    private T primero;

    public Pareja() {
        this.primero = null;
    }

    public void setPrimero(T nuevoValor) {
        this.primero = nuevoValor;
    }

    public static void imprimirTrabajador(Pareja<? extends Empleado> p){
        Empleado primero = p.getPrimero();
        System.out.println(primero);
    }

    public T getPrimero() {
        return this.primero;
    }
}