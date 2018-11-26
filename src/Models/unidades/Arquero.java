package Models.unidades;

import Models.escenario.Casillero;
import Models.juego.Jugador;

public class Arquero extends Unidad {

    public Arquero(){
        this.vida = 75;
        this.danioAUnidad = 15;
        this.danioAEdificio = 10;
    }

    public Arquero(Casillero casillero){
        this.posicion = casillero;
    }

    public Arquero(Jugador jugador){
        this.propietario = jugador;
        this.vida = 75;
    }

}