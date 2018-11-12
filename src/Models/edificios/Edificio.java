package Models.edificios;

import Models.Posicionable;

public class Edificio implements Posicionable {

    private int vida;

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }

    public int getVida(){
        return this.vida;
    }
}
