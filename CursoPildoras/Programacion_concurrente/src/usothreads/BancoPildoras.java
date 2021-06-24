package usothreads;

// import java.util.concurrent.locks.Condition;
// import java.util.concurrent.locks.Lock;
// import java.util.concurrent.locks.ReentrantLock;

public class BancoPildoras {
    public static void main(String[] args) {
        BancoP b = new BancoP();
        for (int i = 0; i < 100; i++) {
            Runnable r = new EjecucionTransferencias(b, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class BancoP {
    private final double[] cuentas;
    //private Lock bloqueoDeReentrada = new ReentrantLock();
    //private Condition saldoSuficiente;

    public BancoP() {
        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
        //saldoSuficiente = bloqueoDeReentrada.newCondition();
    }

    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
        //bloqueoDeReentrada.lock(); // bloquea la entrada del resto de hilos cuando uno lee esta instrucción.

        //try {
            while (cuentas[cuentaOrigen] < cantidad) {// evalua que el saldo no es inferor a la cantidad a transferir
                //saldoSuficiente.await();
                System.out.println("----------------------------------------------------------------------");
                wait();
            }

            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen] -= cantidad;
            System.out.printf("%10.2f de %d para %d ", cantidad, cuentaOrigen, cuentaDestino);
            cuentas[cuentaDestino] += cantidad;

            System.out.printf("Saldo total:%10.2f%n", getSaldoTotal());

            //saldoSuficiente.signalAll();
        //} finally {
            //bloqueoDeReentrada.unlock(); // desbloquea la entrada para el resto de hilos.
        //}
        notifyAll();
    }

    public double getSaldoTotal() {
        double saldototal = 0;
        for (double saldo : cuentas) {
            saldototal += saldo;
        }
        return saldototal;
    }
}

class EjecucionTransferencias implements Runnable {
    private BancoP banco;
    private int deLaCuenta;
    private double cantidadMax;

    public EjecucionTransferencias(BancoP b, int de, double max) {
        banco = b;
        deLaCuenta = de;
        cantidadMax = max;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int paraLaCuenta = (int) (Math.random() * 100);
                double cantidad = cantidadMax * Math.random();

                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);

                Thread.sleep((int) (Math.random() * 10));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}