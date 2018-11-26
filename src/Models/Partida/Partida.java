package Models.Partida;

import Models.Posicionable;
import Models.edificios.PlazaCentral;
import Models.escenario.Mapa;
import Models.juego.Jugador;
import Models.unidades.*;

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

    public ArrayList objetivosAtacables(){
        if(actual == jugador1)
            return jugador2.listaElementos();
        else
            return jugador1.listaElementos();
    }

    public boolean perteneceAJugador(Posicionable unElemento){
        return actual.poseeElemento(unElemento);
    }

    ///////// ACCIONES DE JUGABILIDAD //////////

    public void crearAldeano(PlazaCentral unaPlaza){
        actual.crearAldeano(unaPlaza);
    }

    public void construirEdificioEn(String edificio,Aldeano unAldeano,int x,int y){
        actual.construirEdificio(edificio,unAldeano,x,y);
    }

    public void moverUnidad(Unidad unaUnidad,int x,int y){
        actual.moverUnidad(unaUnidad,x,y);
    }


    public void atacar(Unidad unidadActual, Unidad unidadEnemiga){
        actual.atacarA(unidadActual,unidadEnemiga);
    }


}
