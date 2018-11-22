package Models.unidades;

import Models.juego.Jugador;

public class Espadachin extends Unidad {

    public Espadachin(){
        this.vida = 100;
        this.danioAEdificio = 15;
        this.danioAUnidad = 25;
    }
    public Espadachin(Jugador jugador){
        this.vida = 100;
        this.propietario = jugador;
    }

}
