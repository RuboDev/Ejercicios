/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios.Ud08POO2.Ejercicio6;
/**
 *
 * @author Ruben
 */
public class Vehiculo {

    private String matricula;
    protected int velocidad;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.velocidad = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {
        String info;
        info = "\n***Info Vehiculo:***\nMatrícula: "+getMatricula()+" \nVelocidad: "+getVelocidad()+" km/h";
        return info;
    }

    public void acelerar(int aceleracion) {//calculamos la velocidad sumando velocidad actual + velocidad acelerada en km/h
        this.velocidad += aceleracion;
    }
}
