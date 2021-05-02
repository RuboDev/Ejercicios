/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruben
 */
public class Coche extends Vehiculo {

    private int numPuertas;

    public Coche(String matricula, int numPuertas) {
        super(matricula);
        this.numPuertas = numPuertas;
    }

    public int numPuertas() {
        return numPuertas;
    }
    
    @Override
    public String toString(){
        String info;
        info = super.toString() + "\n<Coche>"+numPuertas()+" Puertas.";
        return info;
    }

}
