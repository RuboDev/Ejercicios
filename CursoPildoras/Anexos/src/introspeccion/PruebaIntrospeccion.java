package introspeccion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class PruebaIntrospeccion {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre de la clase");
        String nombreClase;
        nombreClase = entrada.next();

        // Imprimir clase y superclase
        try {
            Class<?> cl = Class.forName(nombreClase);
            Class<?> superCl = cl.getSuperclass();
            System.out.println("Clase " + nombreClase);

            if (superCl != null && superCl != Object.class) {
                System.out.println(" extends "+superCl.getName());
            }

            System.out.println();
            imprimirConstructores(cl);
            System.out.println();
            imprimirMetodos(cl);
            System.out.println();
            imprimirCampos(cl);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }finally{
            entrada.close();
        }
    }

    //imprime todos los CONSTRUCTORES de la clase introducida por teclado
    public static void imprimirConstructores(Class<?> cl) {
        System.out.println("##### CONSTRUCTORES DE LA CLASE: "+cl.getName()+" #####");
        Constructor<?>[] constructores = cl.getDeclaredConstructors();
        for (Constructor<?> c : constructores) {
            String nombre= c.getName();
            System.out.print("   "+Modifier.toString(c.getModifiers()));
            System.out.print("   "+nombre+"(");
            //imprimir parámetros
            Class<?>[] tipoParams = c.getParameterTypes();
            for (int i = 0; i < tipoParams.length; i++) {
                
                System.out.print(tipoParams[i].getName());
                
                if(tipoParams.length - i > 1){
                    System.out.print(" arg"+(i)+", ");
                }else{
                    System.out.print(" arg"+(i));
                }
                
            }
            System.out.println(");");
        }
    }

    //imprime todos los METODOS de la clase introducida por teclado
    public static void imprimirMetodos(Class<?> cl) {
        System.out.println("@@@@@ METODOS DE LA CLASE: "+cl.getName()+" @@@@@");
        Method[] metodos = cl.getDeclaredMethods();

        for (Method m : metodos) {
            Class<?> tipoDevuelto = m.getReturnType();
            String nombre = m.getName();

            //imprime modificadores, tipo y nombre
            System.out.print("   "+Modifier.toString(m.getModifiers()));
            System.out.print("   "+tipoDevuelto.getName()+ " "+nombre+"(");

            //imprime tipo de parámetros
            Class<?>[] tipoParams = m.getParameterTypes();
            for (int i = 0; i < tipoParams.length; i++) {
                System.out.print(tipoParams[i].getName());
                
                if(tipoParams.length - i > 1){
                    System.out.print(" arg"+(i)+", ");
                }else{
                    System.out.print(" arg"+(i));
                }
            }
            System.out.println(");");
        }
    }

    public static void imprimirCampos(Class<?> cl) {
        System.out.println("%%%%% CAMPOS DE LA CLASE: "+cl.getName()+" %%%%%");
        Field[] campos = cl.getDeclaredFields();

        for (Field c : campos) {
            String nombre = c.getName();
            Class<?> tipo = c.getType();

            //imprime modificadores, tipo y nombre
            System.out.print("   "+Modifier.toString(c.getModifiers()));
            System.out.print(" "+tipo.getName()+ " "+nombre+";");
            System.out.println();
        }
    }
}
