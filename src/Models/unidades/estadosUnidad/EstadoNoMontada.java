package Models.unidades.estadosUnidad;

import Models.Posicionable;
import Models.escenario.Casillero;
import Models.unidades.Unidad;
import Models.unidades.estadosArmaAsedio.ArmaDesmontadaNoPuedeAtacarError;
import Models.unidades.estadosArmaAsedio.EstadoArma;

public class EstadoNoMontada implements EstadoUnidad {

    public EstadoUnidad actualizarEstado() {
        return null;
    }

    public boolean puedeMoverse(){
        return true;
    }

    @Override
    public void atacar(Posicionable objetivo, int danio) {
        throw new ArmaDesmontadaNoPuedeAtacarError();
    }

    public void mover(Unidad unidad, Casillero destino){}

}
