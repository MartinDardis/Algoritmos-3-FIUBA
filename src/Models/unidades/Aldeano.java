package Models.unidades;

import Controllers.MapaController;
import Models.edificios.PlazaCentral;

public class Aldeano extends Unidad {

    private Estado estado;

    public Aldeano() {
        this.vida = 50;
        this.estado = new EstadoInactivo();
    }

    public Aldeano(String jugador) {
        this.pertenece = jugador;
        this.vida = 50;
        this.estado = new EstadoInactivo();
    }

    public int generarOro() {
        return this.estado.generarOro();
    }

    public void setEstado(Estado unEstado) {
        this.estado = unEstado;
    }

}
