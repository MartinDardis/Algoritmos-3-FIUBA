package Models.edificios;

import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.EdificioEnConstruccionError;
import Models.edificios.Estados.EstadoEnConstruccion;
import Models.edificios.Estados.EstadoVidaCompleta;
import Models.juego.Jugador;
import Models.unidades.Arquero;
import Models.unidades.Espadachin;

public class Cuartel extends Edificio {

    private int costo;
    private int turnosConstruccion;

    public Cuartel() {
        this.vidaMaxima = 250;
        this.vidaPorReparacion = 50;
        this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima);
        this.costo = 50;
        this.turnosConstruccion = 3;
        this.alto = 2;
        this.ancho = 2;
    }

    public Cuartel(Jugador jugador) {
        this.vidaMaxima = 250;
        this.vidaPorReparacion = 50;
        this.costo = 50;
        this.turnosConstruccion = 3;
        this.estadoReparacion = new EstadoEnConstruccion(turnosConstruccion);
        this.alto = 2;
        this.ancho = 2;
        this.propietario = jugador;
    }

    public int getCosto() {
        return costo;
    }

    public int getTurnosConstruccion() {
        return turnosConstruccion;
    }

    public int getReparacionPorTurno () {return this.vidaPorReparacion;}

    public Espadachin crearEspadachin(){
         if (!this.estaHabilitado()){
             throw new EdificioEnConstruccionError();
         }
         Espadachin nuevoEspadachin = new Espadachin();
         return nuevoEspadachin;
    }

    public Arquero crearArquero(){
        if (!this.estaHabilitado()){
            throw new EdificioEnConstruccionError();
        }
        Arquero nuevoArquero = new Arquero();
        return nuevoArquero;
    }
}
