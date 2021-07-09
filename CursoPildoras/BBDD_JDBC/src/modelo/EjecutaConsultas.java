package modelo;

public class EjecutaConsultas {
    private String pruebas;
    public String filtraBBDD(String seccion, String pais) {
        pruebas = "";

        if (!seccion.equals("Todos") && pais.equals("Todos")) {
            pruebas="Has escogido seccion";
        }else if(seccion.equals("Todos") && !pais.equals("Todos")){
            pruebas="Has escogido pais";
        }else if(!seccion.equals("Todos") && !pais.equals("Todos")){
            pruebas = "Has escogido ambos";
        }else{
            pruebas = "No has escogido ninguno";
        }
        return pruebas;
    }
}
