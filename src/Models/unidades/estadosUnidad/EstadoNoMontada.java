package Models.unidades.estadosUnidad;

import Models.escenario.Casillero;
import Models.unidades.Unidad;
import Models.unidades.estadosArmaAsedio.ArmaDesmontadaNoPuedeAtacarError;
import Models.unidades.estadosArmaAsedio.EstadoArma;

public class EstadoNoMontada implements EstadoUnidad {

    public void atacar(Unidad victima, int danio){
        throw new ArmaDesmontadaNoPuedeAtacarError();
    }

    public EstadoUnidad actualizarEstado() {
        return null;
    }

    public boolean puedeMoverse(){
        return true;
    }

    public void mover(Unidad unidad, Casillero destino){}

}
