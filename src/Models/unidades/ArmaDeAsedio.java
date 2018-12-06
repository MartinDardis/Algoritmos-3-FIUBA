package Models.unidades;

import Models.escenario.Casillero;
import Models.escenario.errores.CasilleroAlejadoError;
import Models.escenario.errores.LugarOcupadoError;
import Models.juego.Jugador;
import Models.unidades.errores.ArmaMontadaNoPuedeMoverseError;
import Models.unidades.errores.UnidadYaUtilizadaError;
import Models.unidades.estadosAldeano.EstadoInactivo;
import Models.unidades.estadosUnidad.EstadoDisponible;
import Models.unidades.estadosUnidad.EstadoNoMontada;

import java.util.ArrayList;

public class ArmaDeAsedio extends Unidad{

    private boolean movimientoRealizado;

    public ArmaDeAsedio(){
        this.vida = 150;
        this.rangoAtaque = 5;
        this.danioAUnidad = 0;
        this.estadoAccion = new EstadoNoMontada();
        movimientoRealizado = false;
    }

    public ArmaDeAsedio(Jugador jugador){
        this.propietario = jugador;
        this.vida = 150;
        this.estadoAccion =  new EstadoNoMontada();
        this.danioAEdificio = 75;
        this.danioAUnidad = 0; //No aplica, deberia lanzar excepcion cuando movamos el comportamiento aca
        ubicacion = new ArrayList<Casillero>();
        movimientoRealizado = false;
    }

    public void montar(){
        this.estadoAccion = this.estadoAccion.montar();
    }

    public void desmontar(){
        this.estadoAccion = this.estadoAccion.desmontar();
    }

    @Override
    public void mover(Casillero nuevoCasillero)throws CasilleroAlejadoError, LugarOcupadoError {
        if (!estadoAccion.puedeMoverse() ){
            throw new ArmaMontadaNoPuedeMoverseError();
        }
        if (movimientoRealizado){
            throw new UnidadYaUtilizadaError();
        }
        if(this.ubicacion.get(0).distanciaHasta(nuevoCasillero) > 1)
            throw new CasilleroAlejadoError();
        if(nuevoCasillero.estaOcupado())
            throw new LugarOcupadoError();

        this.getCasillero().get(0).remover();
        nuevoCasillero.colocar(this);
        this.setCasillero( nuevoCasillero);
        this.movimientoRealizado = true;
    }


    @Override
    public void restaurarEstados(){
        this.estadoAccion = this.estadoAccion.actualizarEstado();
        this.movimientoRealizado = false;
    }

}
