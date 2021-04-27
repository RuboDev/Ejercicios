/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author Ruben
 */
public class Pelicula extends Multimedia{
    private String actorPrincipal;
    private String actrizPrincipal;

    public Pelicula(){
        this.actorPrincipal = null;
        this.actrizPrincipal = null;
        if (this.actorPrincipal == null && this.actrizPrincipal == null) {
            //System.out.println("No se encontraron actor o actriz principal");
            
        }
    }
    
    public Pelicula(String actorPrincipal, String actrizPrincipal) {
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
    }
    
    public Pelicula(String actorPrincipal, String actrizPrincipal, 
            String titulo, String autor, String formato, String duracion) {
        super(titulo, autor, formato, duracion);
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
        
        if (this.actorPrincipal == null && this.actrizPrincipal == null) {
            //System.out.println("No se encontraron actor o actriz principal");
        }
    }
    
    
    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }
    
    @Override
    public String toString(){
        String info;
        info = super.toString() + "Actor Principal: "+getActorPrincipal()
                +"\nActriz Principal: "+getActrizPrincipal() + "\n";
        return info;
    }
}
