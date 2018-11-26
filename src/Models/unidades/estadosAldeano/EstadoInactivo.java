package Models.unidades.estadosAldeano;

import Models.edificios.Edificio;
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

}
