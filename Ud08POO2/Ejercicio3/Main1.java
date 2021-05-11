/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios.Ud08POO2.Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Ruben
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaMultimedia MiLista = new ListaMultimedia(10);

        System.out.println("Introduzca info de 3 peliculas.");
        Pelicula[] mis3pelis = new Pelicula[3];//Declarado Array de 3 Pelis
        String actorPrincipal, actrizPrincipal,
                titulo, autor, formato, duracion;

        for (int i = 0; i < 3; i++) {//Pedimos los datos de las 3 pelis
            System.out.println("Peli " + i);
            System.out.println("Actor Principal: ");
            actorPrincipal = sc.nextLine();

            System.out.println("Actriz Principal: ");
            actrizPrincipal = sc.nextLine();

            System.out.println("Título: ");
            titulo = sc.nextLine();

            System.out.println("Autor: ");
            autor = sc.nextLine();

            System.out.println("Formato: ");
            formato = sc.nextLine();

            System.out.println("duracion: ");
            duracion = sc.nextLine();

            mis3pelis[i] = new Pelicula(actorPrincipal, actrizPrincipal,
                    titulo, autor, formato, duracion);

            System.out.println("");
        }

        for (int i = 0; i < 3; i++) {//Añadimos las 3 pelis al objeto (lista de
            //archivos multimedia) "MiLista"
            MiLista.add(mis3pelis[i]);
        }

        System.out.println("");
        System.out.println(MiLista.toString());/*Mostramos la info de los 
                                                 objetos guardados en el Array 
                                                 de objetos Multimedia que hay
                                                 en el objeto mi "MiLista"*/
        Pelicula otraPeli = new Pelicula("", "", "Pulp Fiction",
                "Quentin Tarantino", "dvd", "");//Creamos otra peli

        MiLista.add(otraPeli); //La añadimos a la lita
        System.out.println("Posicion: " + MiLista.indexOf(otraPeli));
        //Buscamos posicion de este obj. en la lista (y la mostramos)

        System.out.println(MiLista.get(MiLista.indexOf(otraPeli)).toString());
        //Obtenemos el objeto que esta en esa pos (y muestra la info)

        //System.out.println(MiLista.Size());
        //System.out.println(MiLista.get(9).toString());
    }

}
