package clases_propias;

public class HerenciaGenericos {
    public static void main(String[] args) {
        Empleado adminEmpleado = new Empleado("Elena", 45, 1500);
        Jefe directoraJefe = new Jefe("Ana", 27, 3500);
        // Empleado nuevoEmpleado = directoraComercial;

        Pareja<Empleado> administrativa = new Pareja<Empleado>();
        Pareja<Jefe> directoraComercial = new Pareja<Jefe>();
        //Pareja<Empleado> nuevoEmpleado = directoraComercial;
        
        administrativa.setPrimero(adminEmpleado);
        Pareja.imprimirTrabajador(administrativa);
        
        directoraComercial.setPrimero(directoraJefe);
        Pareja.imprimirTrabajador(directoraComercial);
    }
}
