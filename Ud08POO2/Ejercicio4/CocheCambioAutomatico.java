/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruben
 */
package Ejercicios.Ud08POO2.Ejercicio4;

public class CocheCambioAutomatico extends Coche {

    public CocheCambioAutomatico(String matricula) {
        super(matricula);
    }

    @Override
    public void acelerar(int acel) {
        if (this.velocidad + acel > 280) {//Control no negativos
            this.velocidad = 280;
            System.out.println("El coche no puede acelerar más. (280kph)");
        } else {
            this.velocidad = this.velocidad + acel;
        }

        if (this.velocidad == 0) {
            this.marcha = 0;
        }

        if (this.velocidad > 0) {
            this.marcha = 1;
        }

        if (this.velocidad > 29) {
            this.marcha = 2;
        }

        if (this.velocidad > 59) {
            this.marcha = 3;
        }

        if (this.velocidad > 79) {
            this.marcha = 4;
        }

        if (this.velocidad > 99) {
            this.marcha = 5;
        }

        if (this.velocidad > 119) {
            this.marcha = 6;
        }

        if (this.velocidad > 139) {
            this.marcha = 7;
        }
    }

    @Override
    public void frenar(int acelneg) {

        if (this.velocidad - acelneg < 0) {//Control no negativos
            this.velocidad = 0;
            System.out.println("El coche ya está parado, no puedes frenar más.");
        } else {
            this.velocidad = this.velocidad - acelneg;
        }
        
        if (this.velocidad == 0) {
            this.marcha = 0;
        }

        if (this.velocidad > 0) {
            this.marcha = 1;
        }

        if (this.velocidad > 29) {
            this.marcha = 2;
        }

        if (this.velocidad > 59) {
            this.marcha = 3;
        }

        if (this.velocidad > 79) {
            this.marcha = 4;
        }

        if (this.velocidad > 99) {
            this.marcha = 5;
        }

        if (this.velocidad > 119) {
            this.marcha = 6;
        }

        if (this.velocidad > 139) {
            this.marcha = 7;
        }
    }
}
