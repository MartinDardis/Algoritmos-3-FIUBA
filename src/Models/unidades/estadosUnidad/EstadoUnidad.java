package Models.unidades.estadosUnidad;

import Models.unidades.Unidad;
import Models.escenario.Casillero;

public interface EstadoUnidad {

    void atacar(Unidad objetivo, int danio);
    EstadoUnidad actualizarEstado();

}
