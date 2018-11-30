package Models.unidades.estadosUnidad;

import Models.Posicionable;
import Models.escenario.Casillero;
import Models.unidades.Unidad;
import Models.unidades.estadosArmaAsedio.EstadoArma;
import Models.unidades.estadosUnidad.EstadoUnidad;

public class EstadoMontada implements EstadoUnidad {

    public boolean puedeMoverse(){
        return false;
    }


    public EstadoUnidad actualizarEstado() {
        return null;
    }

    @Override
    public void atacar(Posicionable objetivo, int danio) {

    }

    public void mover(Unidad unidad, Casillero destino){}
}
