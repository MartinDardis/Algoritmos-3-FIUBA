package Models.edificios;

import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.EstadoVidaCompleta;
import Models.juego.Jugador;
import Models.unidades.Aldeano;

public class PlazaCentral extends Edificio {

    private int costo;
    private int turnosConstruccion;
    private int restauracionVidaPorTurno;


    public PlazaCentral() {
        this.vidaMaxima = 450;
        this.vidaPorReparacion = 25;
        this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima);
        this.costo = 100;
        this.alto = 2;
        this.ancho = 2;
    }

    public PlazaCentral(Jugador jugador) {
        this.vidaMaxima = 450;
        this.vidaPorReparacion = 25;
        this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima);
        this.costo = 100;
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
    public int getReparacionPorTurno () {
        return this.restauracionVidaPorTurno;
    }

    public Aldeano crearAldeano(){
            Aldeano nuevoAldeano = new Aldeano(this.propietario);
            return nuevoAldeano;
        }
}


