package Models.unidades.estadosAldeano;

import Models.edificios.Cuartel;
import Models.edificios.Edificio;
import Models.edificios.PlazaCentral;
import Models.juego.Jugador;
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

    public PlazaCentral costruirPlazaCentral(Jugador jugador)throws AldeanoOcupadoError{
        throw  new AldeanoOcupadoError();
    }

    public Cuartel construirCuartel(Jugador jugador)throws AldeanoOcupadoError{
        throw  new AldeanoOcupadoError();
    }

}
