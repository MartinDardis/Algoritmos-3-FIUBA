package Models.edificios;

import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.EstadoVidaCompleta;
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

    public PlazaCentral(String jugador) {
        this.vidaMaxima = 450;
        this.vidaPorReparacion = 25;
        this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima);
        this.costo = 100;
        this.alto = 2;
        this.ancho = 2;
        this.pertenece = jugador;
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

    public Aldeano crearAldeano(int oroJugador){
        if (oroJugador <  20) //getCosto?
            throw new OroInsuficienteError();
        else{
            Aldeano nuevoAldeano = new Aldeano();
            return nuevoAldeano;
        }
    }

}
