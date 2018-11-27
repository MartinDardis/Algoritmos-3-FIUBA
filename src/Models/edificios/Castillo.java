package Models.edificios;

import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.EstadoVidaCompleta;
import Models.juego.Jugador;
import Models.unidades.ArmaDeAsedio;

public class Castillo extends Edificio{


    public Castillo() {
        this.vidaMaxima = 1000;
        this.vidaPorReparacion = 15;
        this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima);
        this.alto = 4;
        this.ancho = 4;
        this.rangoAtaque = 3;
        this.danioAEdificio = 20;
        this.danioAUnidad = 20;

    }

    public Castillo(Jugador jugador) {
        this.vidaMaxima = 1000;
        this.vidaPorReparacion = 15;
        this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima);
        this.alto = 4;
        this.ancho = 4;
        this.propietario = jugador;

    }

    public int getReparacionPorTurno () {return this.vidaPorReparacion;}

    public ArmaDeAsedio crearArmaDeAsedio(){

            ArmaDeAsedio nuevaArmaDeAsedio = new ArmaDeAsedio();
            return nuevaArmaDeAsedio;
    }
    public int getRangoAtaque(){return this.rangoAtaque;}

}
