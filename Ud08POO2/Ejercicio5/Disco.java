/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios.Ud08POO2.Ejercicio5;
/**
 *
 * @author Ruben
 */
public class Disco extends Multimedia {

    private String genero;

    public Disco() {
        this.genero = null;
    }

    public Disco(String genero) {
        this.genero = genero;
    }

    public Disco(String genero, String titulo, String autor, String formato,
            int duracion) {
        super(titulo, autor, formato, duracion);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        String info;
        info = super.toString() + "Género: " + getGenero() + "\n";

        return info;
    }

}
