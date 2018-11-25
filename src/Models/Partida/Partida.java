package Models.Partida;

import Models.escenario.Mapa;
import Models.juego.Jugador;
import Models.unidades.Aldeano;
import Models.unidades.ArmaDeAsedio;
import Models.unidades.Arquero;
import Models.unidades.Espadachin;

public class Partida{

    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa campo;
    private Jugador actual;

    public Partida(String jugadorUno, String jugadorDos){
        jugador1 = new Jugador(jugadorUno);
        jugador2 = new Jugador(jugadorDos);
        campo = new Mapa();
        actual = jugador1;
    }

    //Iniciar el juego


    //Cambia el jugador actual al siguiente jugador
    private void actualizarActual(){
        if(actual == jugador1){
            actual = jugador2;
        }else
            actual = jugador1;
    }

    //Realiza las acciones antes de terminar el turno del jugador actual
    public void terminarTurno(){
        //actual.recolectarOro();
        this.actualizarActual();
    }

    //+++++++++++++++++++++ CREACION DE UNIDADES +++++++++++++++++++++++++++++++++++++//

    public void crearAldeanoEn(int i,int j){
        //Aldeano aldeano = actual.crearAldeano();
        //campo.colocar(aldeano,i,j);
    }

    public void crearArmaDeAsedioEn(int i,int j){
        //ArmaDeAsedio arma = actual.crearArmaDeAsedio();
        //campo.colocar(arma,i,j);
    }

    public void crearArqueroEn(int i, int j){
        //Arquero arq = actual.crearArquero();
        //campo.colocar(arq,i,j);
    }

    public void crearEspadachinEn(int i,int j){
    //    Espadachin esp = actual.crearEspadachin();
    //    campo.colocar(esp,i,j);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

}