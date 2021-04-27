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
public class CocheCambioManual extends Coche {

    public CocheCambioManual(String matricula) {
        super(matricula);
    }

    @Override
    public void cambiaMarcha(int marcha) {

        this.marcha = marcha;

    }
}
