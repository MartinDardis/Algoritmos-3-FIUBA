package Models.unidades.estadosUnidad;

import Models.unidades.Unidad;

public class EstadoDisponible implements EstadoUnidad{

    public void atacar(Unidad objetivo, int danio){
        objetivo.recibirDanio(danio);
    }

    public EstadoUnidad actualizarEstado(){
        return new EstadoInutilizable();
    }


}
