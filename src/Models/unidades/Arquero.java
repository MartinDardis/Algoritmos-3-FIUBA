package Models.unidades;

import Models.escenario.Casillero;
import Models.juego.Jugador;
import Models.unidades.estadosUnidad.*;

import java.util.ArrayList;

public class Arquero extends Unidad {

    //Constructor simplificado para pruebas
    public Arquero(){
        this.vida = 75;
        this.danioAUnidad = 15;
        this.danioAEdificio = 10;
        this.rangoAtaque = 3;
    }

    //Constructor simplificado para pruebas
    public Arquero(Casillero casillero){
        this.vida = 75;
        this.danioAUnidad = 15;
        this.danioAEdificio = 10;
        ubicacion = new ArrayList<Casillero>();
        this.ubicacion.add(casillero);
        this.rangoAtaque = 3;
        this.estadoAccion = new EstadoDisponible();
    }

    //Constructor simplificado para pruebas
    public Arquero(Jugador jugador){
        this.propietario = jugador;
        this.vida = 75;
        this.rangoAtaque = 3;
        this.estadoAccion = new EstadoDisponible();
    }

    //Constructor utilizado
    public Arquero(Jugador jugador, Casillero casillero){
        this.vida = 75;
        this.danioAUnidad = 15;
        this.danioAEdificio = 10;
        this.rangoAtaque = 3;
        this.ubicacion.add(casillero);
        this.propietario = jugador;
        this.estadoAccion = new EstadoDisponible();
    }

}