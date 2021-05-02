/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruben
 */
public class ListaMultimedia {

    private Multimedia[] multimediaArray;
    private int cont = 0;

    public ListaMultimedia(int nMaxObj) {
        this.multimediaArray = new Multimedia[nMaxObj];
    }

    public int Size() {
        int arraySize;
        arraySize = cont;
        return arraySize;
    }

    public boolean add(Multimedia m) {
        boolean cabe;
        if (this.multimediaArray[cont] == null) {
            cabe = true;
            this.multimediaArray[cont] = m;
            cont++;
        } else {
            cabe = false;
        }

        return cabe;
    }

    public Multimedia get(int pos) {
        Multimedia mMediaObj;
        if (this.multimediaArray[pos] == null) {
            System.out.println("Posicion Vacía");
            this.multimediaArray[pos] = new Multimedia();
        }
        mMediaObj = this.multimediaArray[pos];

        return mMediaObj;
    }

    public int indexOf(Multimedia m) {
        int pos = -1;
        for (int i = 0; i < cont; i++) {
            if (m.equals(this.multimediaArray[i])) {
                pos = i;
            }
        }
        return pos;
    }

    @Override
    public String toString() {
        String info = "";
        for (int i = 0; i < cont; i++) {
            info = info + this.multimediaArray[i].toString() + "\n";
        }
        return info;
    }
}
