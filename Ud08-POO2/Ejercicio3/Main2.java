/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Ruben
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ListaMultimedia MiLista = new ListaMultimedia(10);

        System.out.println("Introduzca info de 3 peliculas.");
        Disco[] mis3discos = new Disco[3];//Declarado Array de 3 Discos
        String genero, titulo, autor, formato, duracion;

        for (int i = 0; i < 3; i++) {//Pedimos los datos de los 3 Discos
            System.out.println("Disco " + i);
            System.out.println("Género: ");
            genero = sc.nextLine();

            System.out.println("Título: ");
            titulo = sc.nextLine();

            System.out.println("Autor: ");
            autor = sc.nextLine();

            System.out.println("Formato: ");
            formato = sc.nextLine();

            System.out.println("duracion: ");
            duracion = sc.nextLine();

            mis3discos[i] = new Disco(genero, titulo, autor, formato, duracion);

            System.out.println("");
        }

        for (int i = 0; i < 3; i++) {//Añadimos las 3 pelis al objeto (lista de
            //archivos multimedia) "MiLista"
            MiLista.add(mis3discos[i]);
        }

        System.out.println("");
        System.out.println(MiLista.toString());/*Mostramos la info de los 
                                                 objetos guardados en el Array 
                                                 de objetos Multimedia que hay
                                                 en el objeto mi "MiLista"*/
        Disco otroDisco = new Disco("Rock Progresivo","Meddle",
                "Pink Floyd", "cdAudio", "47'");//Creamos otra peli

        MiLista.add(otroDisco); //La añadimos a la lita
        System.out.println("Posicion: " + MiLista.indexOf(otroDisco));
        //Buscamos posicion de este obj. en la lista (y la mostramos)

        System.out.println(MiLista.get(MiLista.indexOf(otroDisco)).toString());
        //Obtenemos el objeto que esta en esa pos (y muestra la info)
    }

}
