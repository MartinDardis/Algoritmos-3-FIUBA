package Models.unidades.estadosUnidad;

import Models.Posicionable;
import Models.escenario.Casillero;
import Models.unidades.Unidad;
import Models.unidades.errores.*;


public class EstadoEnTransicion implements EstadoUnidad {

    private EstadoUnidad estadoSiguiente;

    public EstadoEnTransicion(EstadoUnidad siguiente){
        this.estadoSiguiente = siguiente;
    }

    public EstadoUnidad actualizarEstado(){
        return this.estadoSiguiente;
    }

    public boolean puedeMoverse(){
        return true;
    }

    public EstadoUnidad desmontar(){
        throw new ArmaEnTransicionError();
    }

    public EstadoUnidad montar(){
        throw new ArmaEnTransicionError();
    }

    public void atacar(Posicionable objetivo, int danio) { throw new ArmaEnTransicionError(); }

    public void mover(Unidad unidad, Casillero destino){ throw new ArmaEnTransicionError(); }

}
