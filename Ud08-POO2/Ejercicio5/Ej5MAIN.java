/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

/**
 *
 * @author Ruben
 */
public class Ej5MAIN implements Cloneable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaMultimedia miLista = new ListaMultimedia(10); //Creamos lista(10)

        Disco disco1 = new Disco("rock", "Meddle", "Pink Floyd",
                "mp3", 47);//Creamos 3 discos
        Disco disco2 = new Disco("pop", "Thriller", "Michael Jackson",
                "cdAudio", 43);
        Disco disco3 = new Disco("rock", "Rubber Soul", "The Beatles",
                "cdAudio", 35);
        Pelicula peli1 = new Pelicula("John Travolta", "Uma Thruman",
              "Pulp Fiction", "Quentin Tarantino", "dvd", 138);//Creamos 3 pelis
        Pelicula peli2 = new Pelicula("Martin Freeman", null,
                "El Hobbit", "Peter Jackson", "dvd", 168);
        Pelicula peli3 = new Pelicula("Sylvester Stallone", "Talia Shire",
                "Rocky", "John G. Avildsen", "dvd", 115);

        miLista.add(disco1);//Añadimos todos discos y pelis creados a la lista
        miLista.add(disco2);
        miLista.add(disco3);
        miLista.add(peli1);
        miLista.add(peli2);
        miLista.add(peli3);

        System.out.println(miLista.toString()); //mostramos miLista por pantalla

        //Calcular duración total
        int duracionTotal = 0;
        for (int i = 0; i < miLista.Size(); i++) {
            duracionTotal += miLista.get(i).getDuracion();
        }
        System.out.println("La duración total es: " + duracionTotal
                + " minutos.");

        //mostrar cuantos discos de rock hay
        int numDiscosRock = 0;
        for (int i = 0; i < miLista.Size(); i++) {
            if (miLista.get(i) instanceof Disco) {
                Disco discoContainer = (Disco) miLista.get(i);

                if ("rock".equals(discoContainer.getGenero())) {
                    numDiscosRock++;
                }
            }

        }
        System.out.println("Hay " + numDiscosRock + " discos de "
                + "rock en la lista.");

        //cuantas peliculas no tienen actriz principal
        int noActriz = 0;
        for (int i = 0; i < miLista.Size(); i++) {
            if (miLista.get(i) instanceof Pelicula) {
                Pelicula peliContainer = (Pelicula) miLista.get(i);

                if (peliContainer.getActrizPrincipal() == null || 
                        "".equals(peliContainer.getActrizPrincipal())) {
                    noActriz++;
                }

            }
        }
        System.out.println("Hay " + noActriz + " peliculas que no tienen "
                + "actriz principal");

    }

}
