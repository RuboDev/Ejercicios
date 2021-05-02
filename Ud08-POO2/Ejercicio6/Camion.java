/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruben
 */
public class Camion extends Vehiculo {

    protected Remolque remol;

    public Camion(String matricula) {
        super(matricula);
        this.remol = null;
    }

    public void ponRemolque(Remolque r) {
        this.remol = r;
    }

    public void quitaRemolque() {
        this.remol = null;
    }

    @Override
    public String toString() {
        String info;
        info = super.toString() + "\n<Camion>\n+Remolque: " + this.remol;
        return info;
    }

    public void acelerar(int acel, Remolque r) throws DemasiadoRapidoException {
        this.velocidad += acel;
        int vel = this.velocidad;
        if (r != null && vel > 100) {
            throw new DemasiadoRapidoException("El camión va demasiado rapido");
        }
    }
}
