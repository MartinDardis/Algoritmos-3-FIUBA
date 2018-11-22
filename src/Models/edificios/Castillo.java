package Models.edificios;

import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.EstadoVidaCompleta;
import Models.unidades.ArmaDeAsedio;

public class Castillo extends Edificio{


    public Castillo() {
        this.vidaMaxima = 1000;
        this.vidaPorReparacion = 15;
        this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima);
        this.alto = 4;
        this.ancho = 4;
        this.rango = 3;

    }

    public Castillo(String jugador) {
        this.vidaMaxima = 1000;
        this.vidaPorReparacion = 15;
        this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima);
        this.alto = 4;
        this.ancho = 4;
        this.pertenece = jugador;

    }

    public int getReparacionPorTurno () {return this.vidaPorReparacion;}

    public ArmaDeAsedio crearArmaDeAsedio(int oroJugador){
        if (oroJugador < 200){//Remplazar por getCosto?
            throw new OroInsuficienteError();
        }
        else{
            ArmaDeAsedio nuevaArmaDeAsedio = new ArmaDeAsedio();
            return nuevaArmaDeAsedio;
        }
    }

}
