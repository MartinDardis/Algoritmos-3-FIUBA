package Models.Partida;

import Models.Posicionable;
import Models.edificios.Castillo;
import Models.edificios.Cuartel;
import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.PlazaCentral;
import Models.escenario.Casillero;
import Models.escenario.Mapa;
import Models.juego.Jugador;
import Models.unidades.*;

import java.util.ArrayList;

public class Partida {

    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa campo;
    private Jugador actual;

    public Partida(String jugadorUno, String jugadorDos) {
        campo = new Mapa();
        jugador1 = new Jugador(jugadorUno, campo);
        jugador2 = new Jugador(jugadorDos, campo, jugador1);
        jugador1.setSiguiente(jugador2);
        actual = jugador1;
    }
    //Getters para pruebas
    public Jugador getJugador1(){
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
    //Fin getters pruebas

    public Jugador getActual() {
        return actual;
    }

    //Cambia el jugador actual al siguiente jugador
    private void actualizarActual() {
        this.actual = this.actual.getSiguiente();
    }

    //Realiza las acciones antes de terminar el turno del jugador actual
    public void terminarTurno() {
        actual.recolectarOro();
        this.actualizarActual();
    }

    public ArrayList obtenerUnidadesYEdificios() {
        return actual.listaElementos();
    }

    public ArrayList objetivosAtacables() {
        return actual.getSiguiente().listaElementos();
    }

    public boolean perteneceAJugador(Posicionable unElemento) {
        return actual.poseeElemento(unElemento);
    }

    ///////// ACCIONES DE JUGABILIDAD //////////

    //Todavia falta determinar como obtener el casillero de salida para cada unidad

    public void crearAldeano(PlazaCentral unaPlaza){
        actual.crearAldeano(unaPlaza);

    }

    public void crearEspadachin(Cuartel unCuartel){
        Casillero salida = unCuartel.getSalida();
        if (salida.estaOcupado()){
            throw new SalidaOcupadaError();
        }
        if (actual.getOro() >= 50){
            Espadachin nuevoEspadachin = actual.crearEspadachin(unCuartel);
            actual.pagar(50);
            campo.colocarUnidad(nuevoEspadachin,salida.obtenerPosicion());
        }
        else {
            throw new OroInsuficienteError();
        }


    }

    public void crearArquero(Cuartel unCuartel){
        Casillero salida = unCuartel.getSalida();
        if (salida.estaOcupado()){
            throw new SalidaOcupadaError();
        }
        if (actual.getOro() >= 75){
            Arquero nuevoArquero = actual.crearArquero(unCuartel);
            actual.pagar(75);
            campo.colocarUnidad(nuevoArquero,salida.obtenerPosicion());
        }
        else {
            throw new OroInsuficienteError();
        }
    }

    public void crearArmaAsedio(Castillo unCastillo){
        Casillero salida = unCastillo.getSalida();
        if (salida.estaOcupado()){
            throw new SalidaOcupadaError();
        }
        if (actual.getOro() >= 200){
            ArmaDeAsedio nuevaArma  = actual.crearArmaAsedio(unCastillo);
            actual.pagar(200);
            campo.colocarUnidad(nuevaArma,salida.obtenerPosicion());
        }
        else {
            throw new OroInsuficienteError();
        }
    }




    public void construirEdificioEn(String edificio,Aldeano unAldeano,int x,int y){
        actual.construirEdificio(edificio,unAldeano,x,y);
    }

    public void moverUnidad(Unidad unaUnidad,int x,int y){
        actual.moverUnidad(unaUnidad,x,y);
    }


    public void atacar(Unidad unidadActual, Unidad unidadEnemiga){
        actual.atacarA(unidadActual,unidadEnemiga);
        if (unidadEnemiga.getVida() <= 0){
            actual.getSiguiente().destruirUnidad(unidadEnemiga);

        }
    }


}
