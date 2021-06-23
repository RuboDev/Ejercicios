package usothreads;

public class SincronizandoHilos {
    public static void main(String[] args) {
        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);
        hilo2.start();
        hilo1.start();

        System.out.println("Terminadas las tareas");
    }
}

class HilosVarios extends Thread {
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo" + getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HilosVarios2 extends Thread {
    private Thread hilo;

    public HilosVarios2(Thread hilo) {
        this.hilo = hilo;
    }

    public void run() {
        try {
            hilo.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo" + getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
