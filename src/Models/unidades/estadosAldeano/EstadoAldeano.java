package Models.unidades.estadosAldeano;

import Models.edificios.Cuartel;
import Models.edificios.Edificio;
import Models.edificios.PlazaCentral;
import Models.juego.Jugador;

public interface EstadoAldeano {

    int generarOro();
    void reparar(Edificio unEdificio);

    EstadoAldeano actualizarEstado();

    EstadoAldeano comenzarConstruccion();

    EstadoAldeano comenzarReparacion();

    PlazaCentral costruirPlazaCentral(Jugador jugador);

    Cuartel construirCuartel(Jugador jugador);
}
