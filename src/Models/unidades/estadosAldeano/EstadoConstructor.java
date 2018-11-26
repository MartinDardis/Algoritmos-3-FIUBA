package Models.unidades.estadosAldeano;

import Models.edificios.Edificio;
import Models.unidades.errores.*;

public class EstadoConstructor implements EstadoAldeano {

    public int generarOro(){
        return 0;
    }

    public void reparar(Edificio unEdificio){
        throw new AldeanoOcupadoError();
    }

    public EstadoAldeano actualizarEstado(){
        return new EstadoConstructor();
    }

}
