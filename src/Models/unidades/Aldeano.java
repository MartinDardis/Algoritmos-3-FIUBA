package Models.unidades;

import Models.escenario.Casillero;
import Models.juego.Jugador;
import Models.unidades.estadosAldeano.EstadoAldeano;
import Models.unidades.estadosAldeano.EstadoInactivo;
import Models.edificios.Edificio;

public class Aldeano extends Unidad {

    private EstadoAldeano estado;

    //Constructor simplificado para tests
    public Aldeano() {
        this.vida = 50;
        this.estado = new EstadoInactivo();
    }

    //Constructor simplificado para tests
    public Aldeano(Jugador jugador) {
        this.propietario = jugador;
        this.vida = 50;
        this.estado = new EstadoInactivo();
    }

    //Constructor simplificado para tests
    public Aldeano(Casillero casillero){

        this.vida = 50;
        this.estado = new EstadoInactivo();
        this.posicion = casillero;
        this.posicion = casillero;

    }

    //Constructor utilizado
    public Aldeano(Jugador jugador, Casillero casillero){
        this.propietario = jugador;
        this.vida = 50;
        this.estado = new EstadoInactivo();
        this.posicion = casillero;
    }

    public int generarOro() {
        return this.estado.generarOro();
    }

    public void setEstado(EstadoAldeano unEstado) {
        this.estado = unEstado;
    }


    public EstadoAldeano getEstado() {
        return this.estado;
    }

    public void reparar(Edificio unEdificio){

        this.estado.reparar(unEdificio);
        this.estado = this.estado.actualizarEstado();
    }


}
