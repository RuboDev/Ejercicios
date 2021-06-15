package excepciones_I;

public class Suma implements Calcula {

    @Override
    public int calculo(int num1, int num2) {
        return num1 + num2;
    }
}
