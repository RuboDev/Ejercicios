package excepciones_I;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDatos {
    public static void main(String[] args) {
        System.out.println("¿Qué deseas hacer");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner sc = new Scanner(System.in);
        int decision = sc.nextInt();

        if (decision == 1) {
            try {
                pedirDatos();
            } catch (InputMismatchException e) {/*
                                                 * Se puede capturar como una excepcion más genérica, anterior en el
                                                 * arbol de herencia, por ejemplo Exception o RuntimeException
                                                 */
                System.out.println("El dato introducido no es una edad.");
            }
        } else {
            System.out.println("Adios");
            System.exit(0);
        }

        sc.close();
    }

    static void pedirDatos() throws InputMismatchException { /*
                                                              * sentencia throws para declarar que algo en el codigo de
                                                              * este metodo lanza una excepcion, del tipo de la clase
                                                              * declarada, en este caso InputMismatchException
                                                              */
        /*
         * Vamos a controlar explicitamente, lo que en este ejemplo en realidad es una
         * mala práctica, pero a veces una mala practica es un buen recurso, resuelve el
         * problema más fácilmente.
         */

        // try {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu nombre, por favor");
        String nombre_usuario = sc.nextLine(); // InputMismatchException

        System.out.println("Introduce edad, por favor");
        int edad = sc.nextInt(); // InputMismatchException

        System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad + 1) + " años");
        sc.close();
        System.out.println("Hemos terminado");

    }
}