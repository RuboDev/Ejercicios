/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio6;

/**
 *
 * @author Ruben
 */
public class Ej6MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Camion camion1 = new Camion("CAM 0975");
        Camion camion2 = new Camion("LTS 4554");
        Remolque miRemolque = new Remolque(5000);;

        Coche coche1 = new Coche("RLS 1993", 5);
        Coche coche2 = new Coche("NNL 0148", 3);

        Vehiculo arrayVehiculos[] = {camion1, camion2, coche1, coche2};

        for (int i = 0; i < arrayVehiculos.length; i++) {//ponemos remolque de 5000kg a todos los Camiones
            if (arrayVehiculos[i] instanceof Camion) {
                Camion camionContainer = (Camion) arrayVehiculos[i];
                camionContainer.ponRemolque(miRemolque);
            }
        }

        for (int i = 0; i < arrayVehiculos.length; i++) {//aceleramos los vehiculos vel= 120
            int vel = 120;
            if (arrayVehiculos[i] instanceof Camion) {
                Camion camionContainer = (Camion) arrayVehiculos[i];
                try {
                    camionContainer.acelerar(vel, camionContainer.remol);
                } catch (DemasiadoRapidoException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                arrayVehiculos[i].acelerar(vel);
            }

        }

        System.out.println(coche1.toString());
        System.out.println(coche2.toString());
        System.out.println(camion1.toString());
        System.out.println(camion2.toString());
    }

}
