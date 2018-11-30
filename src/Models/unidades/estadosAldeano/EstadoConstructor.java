package Models.unidades.estadosAldeano;

import Models.edificios.Cuartel;
import Models.edificios.Edificio;
import Models.edificios.PlazaCentral;
import Models.juego.Jugador;
import Models.unidades.errores.*;

public class EstadoConstructor implements EstadoAldeano {

    private int turnosRestantes = 0;

    public EstadoConstructor(int turnos){
        turnosRestantes = turnos;
    }

    public int generarOro(){
        return 0;
    }

    public EstadoConstructor reparar(Edificio unEdificio){
        throw new AldeanoOcupadoError();
    }

    public EstadoAldeano actualizarEstado(){
        if(turnosRestantes <= 0)
            return new EstadoInactivo();
        turnosRestantes --;
        return this;
    }
    public EstadoAldeano comenzarConstruccion()throws AldeanoOcupadoError{
       throw new AldeanoOcupadoError();
    }

    public EstadoAldeano comenzarReparacion()throws AldeanoOcupadoError{
        throw new AldeanoOcupadoError();
    }

    public PlazaCentral costruirPlazaCentral(Jugador jugador)throws AldeanoOcupadoError{
        throw  new AldeanoOcupadoError();
    }

    public Cuartel construirCuartel(Jugador jugador)throws AldeanoOcupadoError{
        throw  new AldeanoOcupadoError();
    }

}
