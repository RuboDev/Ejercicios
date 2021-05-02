/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Ruben
 */
public class MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String matricula;
        int auto;

        System.out.println("Vamos a crear un coche");
        System.out.println("Introduzca matricula: ");
        matricula = sc.nextLine();

        do {
            System.out.println("¿El coche es automático o no? "
                    + "Introduzca una opcion:");
            System.out.println("1. Automático");
            System.out.println("2. Manual");
            System.out.println("3. Salir del programa.");
            auto = sc.nextInt();

            if (auto == 1) {
                Coche miCarro = new CocheCambioAutomatico(matricula);
                int opMenAuto;

                do {
                    System.out.println(miCarro.toString());
                    System.out.println("");

                    System.out.println("***-***MENU CONDUCIENDO***-***");
                    System.out.println("Elija una opción:");
                    System.out.println("1. Acelerar");
                    System.out.println("2. Frenar");
                    System.out.println("3. Salir");
                    opMenAuto = sc.nextInt();

                    switch (opMenAuto) {
                        case 1:
                            miCarro.acelerar(10);
                            break;

                        case 2:
                            miCarro.frenar(10);
                            break;

                        case 3:
                            break;

                    }
                } while (opMenAuto != 3);
            } else {
                if (auto == 2) {
                    Coche miCarro = new CocheCambioManual(matricula);
                    int opMenManual;
                    int marcha;

                    do {
                        System.out.println(miCarro.toString());
                        System.out.println("");

                        System.out.println("***-***MENU CONDUCIENDO***-***");
                        System.out.println("1. Acelerar");
                        System.out.println("2. Frenar");
                        System.out.println("3. Cambiar Marcha");
                        System.out.println("4. Salir");

                        opMenManual = sc.nextInt();

                        switch (opMenManual) {
                            case 1:
                                miCarro.acelerar(10);
                                break;

                            case 2:
                                miCarro.frenar(10);
                                break;

                            case 3:
                                do{
                                System.out.println("Meta marcha(0-7):");
                                marcha = sc.nextInt();
                                
                                if (marcha > 7 || marcha < 0) {
                                    System.out.println("Marcha inválida");
                                } else {

                                    miCarro.cambiaMarcha(marcha);
                                }
                                }while(marcha > 7 || marcha < 0);

                                break;

                            case 4:
                                break;

                        }

                    } while (opMenManual != 4);
                }

            }

        } while (auto != 3);

    }

}
