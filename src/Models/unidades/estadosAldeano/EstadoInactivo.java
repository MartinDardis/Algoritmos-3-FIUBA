package Models.unidades.estadosAldeano;

import Models.edificios.Cuartel;
import Models.edificios.Edificio;
import Models.edificios.PlazaCentral;
import Models.juego.Jugador;
import Models.unidades.errores.*;

public class EstadoInactivo implements EstadoAldeano {

    public int generarOro(){
        return 20;
    }

    public void reparar(Edificio unEdificio) {
        unEdificio.reparar();
    }

    public EstadoAldeano actualizarEstado(){
        return new EstadoConstructor();
    }

    public PlazaCentral costruirPlazaCentral(Jugador jugador){
        return new PlazaCentral(jugador);
    }

    public Cuartel construirCuartel(Jugador jugador){
        return new Cuartel(jugador);
    }
}
