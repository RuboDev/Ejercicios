/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author Ruben
 */
public class Coche {

    private String matricula;
    protected int velocidad;
    protected int marcha;

    public Coche(String matricula) {
        this.matricula = matricula;
        this.velocidad = 0;
        this.marcha = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getMarcha() {
        return marcha;
    }

    public void acelerar(int acel) {
        if (this.marcha > 0) {
            if (this.velocidad + acel > 280) {//Control no negativos
                this.velocidad = 280;
                System.out.println("El coche no puede acelerar más. (280kph)");
            } else {
                this.velocidad = this.velocidad + acel;
            }
        } else {
            System.out.println("Mete una marcha para poder acelerar.");
        }

    }

    public void frenar(int fren) {
        if (this.velocidad - fren < 0) {//Control no negativos
            this.velocidad = 0;
            //this.marcha = 0;

            System.out.println("El coche ya está parado, no puedes frenar más.");
        } else {
            this.velocidad = this.velocidad - fren;
        }
    }

    @Override
    public String toString() {
        String info;
        info = "\nINFO COCHE" + "\nMatricula: " + this.getMatricula()
                + "\nVelocidad: " + this.getVelocidad()
                + "\nMarcha: " + this.getMarcha();
        return info;
    }

    protected void cambiaMarcha(int marcha) {
        this.marcha = marcha;
    }

}
