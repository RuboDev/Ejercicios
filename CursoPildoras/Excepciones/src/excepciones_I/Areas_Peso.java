package excepciones_I;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Areas_Peso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calcular Area de:");
        System.out.println("Elige una opcion: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Círculo");

        try {
            int figura = sc.nextInt();

            switch (figura) {
                case 1:
                    int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
                    System.out.println("El área del cuadrado es: " + Math.pow(lado, 2));
                    break;

                case 2:
                    int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
                    int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
                    System.out.println("El área del rectángulo es: " + base * altura);
                    break;

                case 3:
                    int base1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
                    int altura1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
                    System.out.println("El área del triángulo es: " + base1 * altura1 / 2);
                    break;

                case 4:
                    int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
                    System.out.println("El área del Círculo es: " + Math.PI * (Math.pow(radio, 2)));
                    break;

                default:
                    System.out.println("La opcion no es correcta");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getClass().getName());
        } finally {
            sc.close();
        }

        // ------------------------------------------------------------------------------------------------------
        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura en cm"));
        System.out.println("Si eres hombre tu peso ideal es: " + (altura - 110) + " kg");
        System.out.println("Si eres hombre tu peso ideal es: " + (altura - 120) + " kg");
    }
}
