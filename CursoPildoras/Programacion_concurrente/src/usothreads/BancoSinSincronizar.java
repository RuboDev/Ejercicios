package usothreads;

import java.util.ArrayList;

public class BancoSinSincronizar {
    public static void main(String[] args) {
        Banco miBanco = new Banco();// Instanciamos miBanco

        miBanco.abrirCuentas(); // El método abrirá 100 cuentas porque así lo deseamos

        do {
            miBanco.transaccionBancaria();
        } while (Transaccion.cont_id < 1000); // 1000 es el numero de transacciones a realizar

        miBanco.mostrarSaldoCuentas();
    }
}

class Banco {
    ArrayList<Cuenta> cuentasBancarias;

    public Banco() {
        cuentasBancarias = new ArrayList<Cuenta>();
    }

    public void abrirCuentas() {
        double saldototal = 0;
        for (int i = 0; i < 100; i++) { // 100 es el numero de cuentas bancarias que se abriran
            Cuenta nuevacuenta = new Cuenta(i, 2000);
            cuentasBancarias.add(nuevacuenta);
            System.out.println("Cuenta abierta. Nº: " + nuevacuenta.numero + " Saldo: " + nuevacuenta.saldo + "€");
            saldototal += nuevacuenta.saldo;
        }
        System.out.println("SALDO TOTAL BANCO: " + saldototal + "€");
    }

    public void transaccionBancaria() {

        Transaccion transa = new Transaccion(cuentasBancarias);
        transa.start();
        try {
            transa.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mostrarSaldoCuentas() {
        double saldototal = 0;
        for (Cuenta cuenta : cuentasBancarias) {
            System.out.println("Nº: " + cuenta.numero + " Saldo: " + cuenta.saldo + "€");
            saldototal += cuenta.saldo;
        }
        System.out.println("SALDO TOTAL BANCO: " + saldototal + "€");
    }
}

class Cuenta {
    int numero;
    double saldo;

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
}

class Transaccion extends Thread {
    static int cont_id;
    private int id;
    private ArrayList<Cuenta> cuentasBancarias;

    public Transaccion(ArrayList<Cuenta> cuentasBancarias) {
        id = cont_id;
        this.cuentasBancarias = cuentasBancarias;
    }

    public void run() {
        cont_id++;
        System.out.println(id);

        Cuenta cuenta1 = cuentasBancarias.get((int) (Math.random() * 100)); // Elegimos cuenta random del 0 al 99
        Cuenta cuenta2 = cuentasBancarias.get((int) (Math.random() * 100)); // Elegimos cuenta random del 0 all 99

        cuenta1.saldo = cuenta1.saldo - (int) (Math.random() * cuenta1.saldo); // Cantidad que se sustrae de una cuenta
                                                                               // random de 0 al saldo
        cuenta2.saldo = cuenta2.saldo + cuenta1.saldo; // Cantidad que se añade a la cuenta beneficiaria

        cuentasBancarias.set(cuentasBancarias.indexOf(cuenta1), cuenta1); // seteamos la cuenta1 con el nuevo saldo en
                                                                          // su posicion
        cuentasBancarias.set(cuentasBancarias.indexOf(cuenta2), cuenta2); // seteamos la cuenta2 con el nuevo saldo en
                                                                          // su posicion
    }
}
