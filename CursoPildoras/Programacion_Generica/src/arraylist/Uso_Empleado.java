package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class Uso_Empleado {
    public static void main(String[] args) {
        // Empleado listaEmpleados[] = new Empleado[3];

        // listaEmpleados[0] = new Empleado("Ana", 45, 2500);
        // listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
        // listaEmpleados[2] = new Empleado("Maria", 25, 2600);

        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        // listaEmpleados.ensureCapacity(11);

        listaEmpleados.add(new Empleado("Ana", 45, 2500));
        listaEmpleados.add(new Empleado("Antonio", 55, 2000));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        listaEmpleados.add(new Empleado("Jose", 35, 2200));
        listaEmpleados.add(new Empleado("Jose", 35, 2200));
        listaEmpleados.add(new Empleado("Ana", 45, 2500));
        listaEmpleados.add(new Empleado("Antonio", 55, 2000));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        listaEmpleados.add(new Empleado("Jose", 35, 2200));
        listaEmpleados.add(new Empleado("Jose", 35, 2200));
        listaEmpleados.add(new Empleado("Pedro", 22, 2200));
        listaEmpleados.add(new Empleado("Pedro", 22, 2200));
        listaEmpleados.add(new Empleado("Pedro", 22, 2200));
        listaEmpleados.add(new Empleado("Pedro", 22, 2200));

        // listaEmpleados.trimToSize(); -> Trims the capacity of this ArrayList instance
        // to be the list's current size.

        // listaEmpleados.add(new Empleado("Olga", 22, 2200));

        // listaEmpleados.set(1, new Empleado("Olga", 22, 2200)); -> Replaces the
        // element
        // at the specified position in this list with the specified element.

        // System.out.println(listaEmpleados.size()); -> Returns the number of elements
        // in this list.

        // System.out.println(listaEmpleados.get(3).dameDatos()); -> Returns the element
        // at the specified position in this list.

        // for (Empleado e : listaEmpleados) {
        // System.out.println(e.dameDatos());
        // }

        // for (int i = 0; i < listaEmpleados.size(); i++) {
        //     Empleado e = listaEmpleados.get(i);
        //     System.out.println(e.dameDatos());
        // }

        Iterator <Empleado> mi_iterador = listaEmpleados.iterator();
        while (mi_iterador.hasNext()) {
            System.out.println(mi_iterador.next().dameDatos());
        }
        

        // Empleado arrayEmpleados[] = new Empleado[listaEmpleados.size()];
        // listaEmpleados.toArray(arrayEmpleados);
        // for (int i = 0; i < arrayEmpleados.length; i++) {
        // System.out.println(arrayEmpleados[i].dameDatos());
        // }
    }
}

class Empleado {
    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos() {
        return "El empleado se llama " + nombre + ". Tiene " + edad + " años. Y un salario de " + salario;
    }
}
