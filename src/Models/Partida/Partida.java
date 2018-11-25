package Models.Partida;

import Models.Posicionable;
import Models.edificios.PlazaCentral;
import Models.escenario.Mapa;
import Models.juego.Jugador;
import Models.unidades.Aldeano;
import Models.unidades.ArmaDeAsedio;
import Models.unidades.Arquero;
import Models.unidades.Espadachin;
import Models.unidades.Unidad;

import java.util.ArrayList;

public class Partida{

    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa campo;
    private Jugador actual;

    public Partida(String jugadorUno, String jugadorDos){
        campo = new Mapa();
        jugador1 = new Jugador(jugadorUno,campo);
        jugador2 = new Jugador(jugadorDos,campo);
        actual = jugador1;
    }



    //Cambia el jugador actual al siguiente jugador
    private void actualizarActual(){
        if(actual == jugador1){
            actual = jugador2;
        }else
            actual = jugador1;
    }

    //Realiza las acciones antes de terminar el turno del jugador actual
    public void terminarTurno(){
        actual.recolectarOro();
        this.actualizarActual();
    }


    public ArrayList obtenerUnidadesYEdificios(){
        return actual.listaElementos();
    }

    public boolean perteneceAJugador(Posicionable unElemento){
        return actual.poseeElemento(unElemento);
    }

    public void crearAldeano(PlazaCentral unaPlaza){
        actual.crearAldeano(unaPlaza);
    }

    public void crearEdificioEn(String edificio,Aldeano unAldeano,int x,int y){
        actual.crearEdificio(edificio,unAldeano,x,y);
    }

    public void moverUnidad(Unidad unaUnidad,int x,int y){
        actual.moverUnidad(unaUnidad,x,y);
    }


}
