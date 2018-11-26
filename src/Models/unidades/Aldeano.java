package Models.unidades;

import Models.escenario.Casillero;
import Models.juego.Jugador;

public class Aldeano extends Unidad {

    private Estado estado;

    public Aldeano() {
        this.vida = 50;
        this.estado = new EstadoInactivo();
    }


    public Aldeano(Jugador jugador) {
        this.propietario = jugador;
        this.vida = 50;
        this.estado = new EstadoInactivo();
    }

    public Aldeano(Casillero casillero){
        this.posicion = casillero;
    }

    public int generarOro() {
        return this.estado.generarOro();
    }

    public void setEstado(Estado unEstado) {
        this.estado = unEstado;
    }

}
