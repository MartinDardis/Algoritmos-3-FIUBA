package Models.juego;

import Models.Posicionable;
import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.PlazaCentral;
import Models.unidades.Aldeano;
import Models.unidades.Unidad;

import java.util.ArrayList;

public class Jugador {

    private int oro;
    private int poblacionActual;//Array de unidades ??
    private String nombre;
    //Refactorizar bool esTurnoActual o estado JugadorActual

    public Jugador(String nuevoNombre){
        this.nombre = nuevoNombre;
        this.oro = 100;
        this.poblacionActual = 0; //Pienso en sumar los 3 aldeanos cuando se crean junto al resto, me parece mejor que inicializarlos aca

    }

    public void sumarOro(int cantOro){
        this.oro += cantOro;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getOro(){
        return this.oro;
    }

    public void cobrar(int cantOro){
        if (this.oro < cantOro){
            throw new OroInsuficienteError();//revisar si es necesario crear otro error o este va bien
        }
        this.oro -= cantOro;
    }


    public int getPoblacionActual() {
        return poblacionActual;//Todavia no testeado al iniciar, ya que 0 cambiara por lo mencionado en el constructor
    }

    public void incrementarPoblacion(){
        if (poblacionActual > 50){
            throw new PoblacionMaximaError();
        }
        this.poblacionActual++;
    }

    public void disminuirPoblacion(){
        if(poblacionActual <= 0){
            throw new NoHayPoblacionError();
        }
    }

    public void recolectarOro() {
    }

    public ArrayList listaElementos() {
    }

    public boolean poseeElemento(Posicionable unElemento) {
    }

    public void crearAldeano(PlazaCentral unaPlaza) {
    }

    public void crearEdificio(String edificio, Aldeano unAldeano, int x, int y) {
    }

    public void moverUnidad(Unidad unaUnidad, int x, int y) {
    }

    public void atacarA(Unidad unidadActual, Unidad unidadEnemiga) {

    }
}
