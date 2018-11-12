package Models.edificios;

import Models.unidades.ArmaDeAsedio;

public class Castillo {
    private int vida;
    private int restauracionVidaPorTurno; //escucho sugerencias para un mejor nombre

    public Castillo() {
        vida = 1000;
        restauracionVidaPorTurno = 15;
    }
    public int getVida() {
        return this.vida;
    }
    public int getReparacionPorTurno () {return this.restauracionVidaPorTurno;}

    public ArmaDeAsedio crearArmaDeAsedio(int oroJugador){
        if (oroJugador < 200){//Remplazar por getCosto?
            throw new OroInsuficienteError();
        }
        else{
            ArmaDeAsedio nuevaArmaDeAsedio = new ArmaDeAsedio();
            return nuevaArmaDeAsedio;
        }
    }

}
