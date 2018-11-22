package Models.unidades;

import Models.Posicionable;

public class Unidad implements Posicionable {

    protected int vida;
    protected int rango;
    protected String pertenece;

    public int getVida(){
        return this.vida;
    }

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }

    public String perteneceA(){
        return this.pertenece;
    }

    public boolean dentroRadioDeAtaque(int unaDistancia){
        if(rango > unaDistancia){
            return false;
        }
        return true;
    }
    public void recibirDanio(int danio){
        this.vida -= danio;
    }
}
