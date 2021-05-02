/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruben
 */
public class Multimedia {

    private String titulo;
    private String autor;
    private String formato;
    private int duracion;
    private String[] formatsArray = {"wav", "mp3", "midi", "avi", "mov", "mpg",
        "cdAudio", "dvd"};
    private boolean compatible = false;

    public Multimedia() {
        this.titulo = null;
        this.autor = null;
        this.formato = null;
        this.duracion = 0;
    }

    public Multimedia(String titulo, String autor, String formato,
            int duracion) {
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

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        String infoObjeto;
        infoObjeto = "Título: " + getTitulo() + "\nAutor: " + getAutor() + "\n"
                + "Formato: " + getFormato() + "\nDuración: " + getDuracion() + "\n";
        return infoObjeto;
    }

    public boolean equals(Multimedia m) {
        boolean equivalen;

        if (this.titulo.equals(m.titulo) && this.autor.equals(m.autor)) {
            equivalen = true;
        } else {
            equivalen = false;
        }

        return equivalen;
    }

}
