package Models.unidades;

import Models.Posicionable;

public class Unidad implements Posicionable {

    private int vida;

    public int getVida(){
        return this.vida;
    }

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }


}
