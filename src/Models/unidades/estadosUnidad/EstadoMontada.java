package Models.unidades.estadosUnidad;

import Models.Posicionable;
import Models.unidades.errores.*;
import Models.escenario.Casillero;
import Models.unidades.Unidad;
import Models.unidades.estadosArmaAsedio.EstadoArma;
import Models.unidades.estadosUnidad.EstadoUnidad;

public class EstadoMontada implements EstadoUnidad {

    public EstadoUnidad desmontar(){
        return new EstadoEnTransicion(new EstadoNoMontada());
    }

    public boolean puedeMoverse(){
        return false;
    }

    public EstadoUnidad actualizarEstado() {
        return this;
    }

    @Override
    public void atacar(Posicionable objetivo, int danio) {
        objetivo.recibirDanio(danio);
    }

    public void mover(Unidad unidad, Casillero destino){
        throw new ArmaMontadaNoPuedeMoverseError();
    }

    public EstadoUnidad montar(){
        throw new ArmaYaMontadaError();
    }

}
