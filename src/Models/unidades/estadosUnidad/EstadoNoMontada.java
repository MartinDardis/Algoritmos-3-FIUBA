package Models.unidades.estadosUnidad;

import Models.Posicionable;
import Models.unidades.errores.*;
import Models.escenario.Casillero;
import Models.unidades.Unidad;
import Models.unidades.errores.ArmaDesmontadaNoPuedeAtacarError;

public class EstadoNoMontada implements EstadoUnidad {

    public EstadoUnidad montar(){

        EstadoUnidad siguiente = new EstadoMontada();
        return new EstadoEnTransicion(siguiente);

    }

    public EstadoUnidad actualizarEstado() {
        return this;
    }

    public boolean puedeMoverse(){
        return true;
    }

    @Override
    public void atacar(Posicionable objetivo, int danio) {
        throw new ArmaDesmontadaNoPuedeAtacarError();
    }

    public EstadoUnidad desmontar(){
        throw new ArmaYaDesmontadaError();
    }

    public void mover(Unidad unidad, Casillero destino){}

}
