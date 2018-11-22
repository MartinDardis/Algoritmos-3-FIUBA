package Models.unidades;

import Models.Posicionable;
import Models.juego.Jugador;

public class Unidad implements Posicionable {

    protected int vida;
    protected int rangoAtaque;
    protected Jugador propietario;

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
        return this.propietario.getNombre();
    }

    public boolean dentroRadioDeAtaque(int unaDistancia){
        if(rangoAtaque > unaDistancia){
            return false;
        }
        return true;
    }
    public void recibirDanio(int danio){
        this.vida -= danio;
    }

    @Override
    public int getRangoAtaque() {
        return rangoAtaque;
    }
}
