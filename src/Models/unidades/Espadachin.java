package Models.unidades;

import Models.escenario.Casillero;
import Models.juego.Jugador;
import Models.unidades.estadosUnidad.EstadoDisponible;

public class Espadachin extends Unidad {

    //Constructor simplificado para pruebas
    public Espadachin(){
        this.vida = 100;
        this.danioAEdificio = 15;
        this.danioAUnidad = 25;
        this.rangoAtaque = 1;
        this.estadoAtaque = new EstadoDisponible();
    }

    //Constructor simplificado para pruebas
    public Espadachin(Jugador jugador){
        this.vida = 100;
        this.propietario = jugador;
        this.rangoAtaque = 1;
        this.estadoAtaque = new EstadoDisponible();
    }

    //Constructor simplificado para pruebas
    public Espadachin(Casillero casillero){
        this.vida = 100;
        this.danioAEdificio = 15;
        this.danioAUnidad = 25;
        this.rangoAtaque = 1;
        this.posicion = casillero;
        this.estadoAtaque = new EstadoDisponible();
    }

    //Constructor utilizado
    public Espadachin(Jugador jugador, Casillero casillero){
        this.vida = 100;
        this.danioAEdificio = 15;
        this.danioAUnidad = 25;
        this.rangoAtaque = 1;
        this.posicion = casillero;
        this.propietario = jugador;
        this.estadoAtaque = new EstadoDisponible();
    }



}
