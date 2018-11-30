package Models.unidades;

import Models.escenario.Casillero;
import Models.juego.Jugador;
import Models.unidades.estadosUnidad.EstadoDisponible;

import java.util.ArrayList;

public class Espadachin extends Unidad {

    //Constructor simplificado para pruebas
    public Espadachin(){
        this.vida = 100;
        this.danioAEdificio = 15;
        this.danioAUnidad = 25;
        this.rangoAtaque = 1;
        this.estadoAccion = new EstadoDisponible();
    }

    //Constructor simplificado para pruebas
    public Espadachin(Jugador jugador){
        this.vida = 100;
        this.propietario = jugador;
        this.rangoAtaque = 1;
        this.estadoAccion = new EstadoDisponible();
    }

    //Constructor simplificado para pruebas
    public Espadachin(Casillero casillero){
        this.vida = 100;
        this.danioAEdificio = 15;
        this.danioAUnidad = 25;
        this.rangoAtaque = 1;
        ubicacion = new ArrayList<Casillero>();
        this.ubicacion.add(casillero);
        this.estadoAccion = new EstadoDisponible();
    }

    //Constructor utilizado
    public Espadachin(Jugador jugador, Casillero casillero){
        this.vida = 100;
        this.danioAEdificio = 15;
        this.danioAUnidad = 25;
        this.rangoAtaque = 1;
        this.ubicacion.add(casillero);
        this.propietario = jugador;
        this.estadoAccion = new EstadoDisponible();
    }



}
