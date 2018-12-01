package Models.unidades.estadosUnidad;

import Models.Posicionable;
import Models.escenario.Casillero;
import Models.unidades.Unidad;

public class EstadoDisponible implements EstadoUnidad{

    public void atacar(Posicionable objetivo, int danio){
        objetivo.recibirDanio(danio);
    }

    public EstadoUnidad actualizarEstado(){
        return new EstadoInutilizable();
    }

    public void mover(Unidad unidad, Casillero destino){
        unidad.getCasillero().get(0).remover();
        destino.colocar(unidad);
        unidad.setCasillero(destino);
    }






    @Override
    public boolean puedeMoverse() {
        return false;
    }


}
