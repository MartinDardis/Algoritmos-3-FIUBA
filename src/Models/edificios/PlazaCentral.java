package Models.edificios;

import Models.unidades.Aldeano;

public class PlazaCentral extends Edificio {

    private int costo;
    private int turnosConstruccion;
    private int restauracionVidaPorTurno;

    public PlazaCentral() {
        vida = 450;
        costo = 100;
        turnosConstruccion = 3;
        restauracionVidaPorTurno    = 50;
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
