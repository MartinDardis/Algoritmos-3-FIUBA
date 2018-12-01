package Models.unidades.estadosAldeano;

import Models.edificios.Cuartel;
import Models.edificios.Edificio;
import Models.edificios.PlazaCentral;
import Models.juego.Jugador;

public class EstadoInactivo implements EstadoAldeano {

    public int generarOro(){
        return 20;
    }

    public EstadoConstructor reparar(Edificio unEdificio) {
        unEdificio.reparar();
        return new EstadoConstructor(1);
    }

    public EstadoAldeano actualizarEstado(){
        return this;
    }

    public PlazaCentral costruirPlazaCentral(Jugador jugador){
        return new PlazaCentral(jugador);
    }

    public Cuartel construirCuartel(Jugador jugador){
        return new Cuartel(jugador);
    }

    public EstadoAldeano comenzarConstruccion(){
        return new EstadoConstructor(3);
    }

    public EstadoAldeano comenzarReparacion(){
        return new EstadoConstructor(1);
    }
}
