import java.util.HashSet;
import java.util.Iterator;

public class CuentasUsuarios {
    public static void main(String[] args) {
        Cliente cl1 = new Cliente("Antonio Banderas", "00001", 200000);
        Cliente cl2 = new Cliente("Rafael Nadal", "00002", 250000);
        Cliente cl3 = new Cliente("Penelope", "00003", 300000);
        Cliente cl4 = new Cliente("Julio Iglesias", "00004", 500000);
        Cliente cl5 = new Cliente("Antonio Banderas", "00001", 200000);

        HashSet<Cliente> clientesBanco = new HashSet<Cliente>();
        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        clientesBanco.add(cl5);

        // for (Cliente client : clientesBanco) {

        // if (client.getNombre().equals("Julio Iglesias")) {
        // clientesBanco.remove(client);
        // }
        // }

        Iterator<Cliente> it = clientesBanco.iterator();
        while (it.hasNext()) {
            Cliente cli = it.next();
            if (cli.getNombre().equals("Julio Iglesias")) {
                it.remove();
            }
        }

        for (Cliente client : clientesBanco) {
            System.out.println(client.getNombre() + " " + client.getN_cuenta() + " " + client.getSaldo());
        }

        /*
         * Iterator<Cliente> it = clientesBanco.iterator(); while (it.hasNext()) {
         * Cliente cli = it.next(); String nombre_cliente = cli.getNombre(); String
         * n_cuenta = cli.getN_cuenta(); double saldo_cuenta = cli.getSaldo();
         * 
         * System.out.println(nombre_cliente + " " + n_cuenta+ " "+saldo_cuenta); }
         */
    }
}
