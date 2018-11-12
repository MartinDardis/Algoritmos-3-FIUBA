package Models.edificios;

import Models.unidades.Arquero;
import Models.unidades.Espadachin;

public class Cuartel {
    private int vida;
    private int costo;
    private int turnosConstruccion;
    private int restauracionVidaPorTurno;


    public Cuartel() {
        vida = 250;
        costo = 50;
        turnosConstruccion = 3;
        restauracionVidaPorTurno = 25;
    }
    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return costo;
    }

    public int getTurnosConstruccion() {
        return turnosConstruccion;
    }

    public int getReparacionPorTurno () {return this.restauracionVidaPorTurno;}

    public Espadachin crearEspadachin(int oroJugador){
        if (oroJugador < 50)
            throw new OroInsuficienteError();
        else{
            Espadachin nuevoEspadachin = new Espadachin();
            return nuevoEspadachin;
        }

    }
    public Arquero crearArquero(int oroJugador){
        if (oroJugador < 75)
            throw new OroInsuficienteError();
        else{
            Arquero nuevoArquero = new Arquero();
            return nuevoArquero;
        }

    }
}
