package Models.unidades;

import Models.edificios.Cuartel;
import Models.edificios.PlazaCentral;
import Models.escenario.Casillero;
import Models.juego.Jugador;
import Models.unidades.errores.AldeanoOcupadoError;
import Models.unidades.estadosAldeano.EstadoAldeano;
import Models.unidades.estadosUnidad.EstadoDisponible;
import Models.unidades.estadosAldeano.EstadoInactivo;
import Models.edificios.Edificio;

import java.util.ArrayList;

public class Aldeano extends Unidad {

    private EstadoAldeano estadoReparacion;

    //Constructor simplificado para tests
    public Aldeano() {
        this.vida = 50;
        this.estadoReparacion = new EstadoInactivo();
        this.estadoAccion = new EstadoDisponible();
    }

    //Constructor simplificado para tests
    public Aldeano(Jugador jugador) {
        this.propietario = jugador;
        this.vida = 50;
        this.estadoReparacion = new EstadoInactivo();
        this.estadoAccion = new EstadoDisponible();
    }

    //Constructor simplificado para tests
    public Aldeano(Casillero casillero){

        this.vida = 50;
        this.estadoReparacion = new EstadoInactivo();
        this.estadoAccion = new EstadoDisponible();
        ubicacion = new ArrayList<Casillero>();
        this.ubicacion.add(casillero);

    }

    //Constructor utilizado
    public Aldeano(Jugador jugador, Casillero casillero){
        this.propietario = jugador;
        this.vida = 50;
        this.estadoReparacion = new EstadoInactivo();
        this.ubicacion.add(casillero);
    }

    public int generarOro() {
        return this.estadoReparacion.generarOro();
    }

    public void setEstadoReparacion(EstadoAldeano unEstado) {
        this.estadoReparacion = unEstado;
    }


    public EstadoAldeano getEstadoReparacion() {
        return this.estadoReparacion;
    }

    public void reparar(Edificio unEdificio){

        EstadoAldeano estado = this.estadoReparacion.reparar(unEdificio);
        this.estadoReparacion = estado;
    }

    public PlazaCentral construirPlazaCentral(Jugador jugador)throws AldeanoOcupadoError {
        return this.estadoReparacion.costruirPlazaCentral(jugador);
    }

    public Cuartel construirCuartel(Jugador jugador)throws AldeanoOcupadoError{
        return this.estadoReparacion.construirCuartel(jugador);
    }


    public void comenzarConstruccion()throws AldeanoOcupadoError {
        EstadoAldeano estadoNew = this.estadoReparacion.comenzarConstruccion();
        this.estadoReparacion = estadoNew;
    }

    @Override
    public void restaurarEstados(){
        this.estadoAccion = new EstadoDisponible();
        this.estadoReparacion = this.estadoReparacion.actualizarEstado();
    }
}
