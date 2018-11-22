package Models.unidades;

import Models.juego.Jugador;

public class Arquero extends Unidad {

    public Arquero(){
        this.vida = 75;
        this.danioAUnidad = 15;
        this.danioAEdificio = 10;
    }

    public Arquero(Jugador jugador){
        this.propietario = jugador;
        this.vida = 75;
    }

}