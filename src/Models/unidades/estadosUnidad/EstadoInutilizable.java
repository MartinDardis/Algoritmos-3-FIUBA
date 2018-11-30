package Models.unidades.estadosUnidad;

import Models.escenario.Casillero;
import Models.unidades.Unidad;
import Models.unidades.errores.*;

public class EstadoInutilizable implements EstadoUnidad {

    public void atacar(Unidad objetivo, int danio){
        throw new UnidadYaUtilizadaError();
    }

    public void mover(Unidad unidad, Casillero destino){ throw new UnidadYaUtilizadaError(); }

    public EstadoUnidad actualizarEstado(){
        return new EstadoInutilizable();
    }

    public boolean puedeMoverse() {
        return false;
    }
}
