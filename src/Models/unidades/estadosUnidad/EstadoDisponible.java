package Models.unidades.estadosUnidad;

import Models.escenario.Casillero;
import Models.unidades.Unidad;

public class EstadoDisponible implements EstadoUnidad{

    public void atacar(Unidad objetivo, int danio){
        objetivo.recibirDanio(danio);
    }

    public EstadoUnidad actualizarEstado(){
        return new EstadoInutilizable();
    }

    public void mover(Unidad unidad, Casillero destino){
        unidad.getCasillero().remover();
        destino.colocar(unidad);
        unidad.setCasillero(destino);
    }






    @Override
    public boolean puedeMoverse() {
        return false;
    }


}
