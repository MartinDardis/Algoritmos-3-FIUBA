package Models.unidades;

import Models.escenario.Casillero;
import Models.juego.Jugador;
import Models.unidades.estadosAldeano.Estado;
import Models.unidades.estadosAldeano.EstadoInactivo;

public class Aldeano extends Unidad {

    private Estado estado;

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
        this.posicion = casillero;
    }

    //Constructor utilizado
    public Aldeano(Jugador jugador, Casillero casillero){
        this.propietario = jugador;
        this.vida = 50;
        this.estado = new EstadoInactivo();
        this.posicion = casillero;
    }

    @Override
    public int generarOro() {
        return this.estado.generarOro();
    }

    public void setEstado(Estado unEstado) {
        this.estado = unEstado;
    }

}
