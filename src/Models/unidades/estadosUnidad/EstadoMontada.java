package Models.unidades.estadosUnidad;

import Models.escenario.Casillero;
import Models.unidades.Unidad;
import Models.unidades.estadosArmaAsedio.EstadoArma;
import Models.unidades.estadosUnidad.EstadoUnidad;

public class EstadoMontada implements EstadoUnidad {

    public boolean puedeMoverse(){
        return false;
    }


    @Override
    public void atacar(Unidad objetivo, int danio) {

    }

    @Override
    public EstadoUnidad actualizarEstado() {
        return null;
    }
}
