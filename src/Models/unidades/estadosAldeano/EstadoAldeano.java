package Models.unidades.estadosAldeano;

import Models.edificios.Edificio;

public interface EstadoAldeano {

    int generarOro();
    void reparar(Edificio unEdificio);
    EstadoAldeano actualizarEstado();

}
