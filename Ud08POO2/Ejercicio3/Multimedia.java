/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruben
 */
package Ejercicios.Ud08POO2.Ejercicio3;

public class Multimedia {

    private String titulo;
    private String autor;
    private String formato;
    private String duracion;
    private String[] formatsArray = {"wav", "mp3", "midi", "avi", "mov", "mpg",
        "cdAudio", "dvd"};
    private boolean compatible = false;

    public Multimedia() {
        this.titulo = null;
        this.autor = null;
        this.formato = null;
        this.duracion = null;
    }

    public Multimedia(String titulo, String autor, String formato,
            String duracion) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.duracion = duracion;

        for (int i = 0; i < formatsArray.length; i++) {//comprobar compatibilidad de formatos
            if (this.formato.equalsIgnoreCase(formatsArray[i])) {
                compatible = true; //Formato compatible
            }            
        }
        if (compatible == false) {
            System.out.println("Formato incompatible");
        }
        
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getFormato() {
        return formato;
    }

    public String getDuracion() {
        return duracion;
    }

    
    @Override
    public String toString(){
        String infoObjeto;
        infoObjeto = "Título: "+getTitulo()+"\nAutor: "+getAutor()+"\n"
                + "Formato: "+getFormato()+"\nDuración: "+getDuracion()+"\n";
        return infoObjeto;
    }
    
    public boolean equals(Multimedia m){
        boolean equivalen;
        
        if (this.titulo.equals(m.titulo) && this.autor.equals(m.autor)) {
            equivalen = true;
        }else{
            equivalen = false;
        }
        
        return equivalen;
    }

}
