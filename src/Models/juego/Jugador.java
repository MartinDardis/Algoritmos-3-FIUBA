package Models.juego;

import java.util.ArrayList;

import Models.Partida.SalidaOcupadaError;
import Models.Posicionable;
import Models.escenario.*;
import Models.juego.errores.NoHayPoblacionError;
import Models.juego.errores.PoblacionMaximaError;
import Models.unidades.*;
import Models.edificios.*;
import Models.edificios.Errores.OroInsuficienteError;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Jugador {

    private int oro;
    private int poblacionActual;//Array de unidades ?
    
    private ArrayList<Posicionable> elementos;
    private String nombre;
    private Mapa campo;
    private Jugador siguiente;

    //Constructor para pruebas y para el primer jugador instanciado
    public Jugador(String nuevoNombre, Mapa campo){
        this.nombre = nuevoNombre;
        this.oro = 100;
        this.poblacionActual = 0; //Pienso en sumar los 3 aldeanos cuando se crean junto al resto, me parece mejor que inicializarlos aca
        this.campo = campo;
        elementos = new ArrayList<>();
    }

    //Constructor a utilizar
    public Jugador(String nuevoNombre, Mapa campo, Jugador siguiente){
        this.nombre = nuevoNombre;
        this.oro = 100;
        this.poblacionActual = 0; //Pienso en sumar los 3 aldeanos cuando se crean junto al resto, me parece mejor que inicializarlos aca
        this.campo = campo;
        this.siguiente = siguiente;
    }

    public Jugador getSiguiente(){
        return this.siguiente;
    }

    //Este setter es necesario porque cuando se crea el primer jugador el segundo aún no existe
    //por ende no se lo puede enviar el siguiente al constructor al momento de crearlo
    public void setSiguiente(Jugador siguiente){
        this.siguiente = siguiente;
    }


    public String getNombre(){
        return this.nombre;
    }

    public int getOro(){
        return this.oro;
    }

    public int getPoblacionActual() {
        return poblacionActual;//Todavia no testeado al iniciar, ya que 0 cambiara por lo mencionado en el constructor
    }

    public void pagar(int cantOro){
        if (this.oro < cantOro){
            throw new OroInsuficienteError();//revisar si es necesario crear otro error o este va bien
        }
        this.oro -= cantOro;
    }

    public void sumarOro(int cantOro){
        this.oro += cantOro;
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
        for (Posicionable elem: elementos ) {
            this.sumarOro(elem.generarOro());
        }
    }

    public ArrayList<Posicionable> listaElementos() {
        return elementos;
    }

    public boolean poseeElemento(Posicionable unElemento) {
        return elementos.contains(unElemento);
    }


    public void crearAldeano(PlazaCentral unaPlaza) {
        this.pagar(25);//getCosto o constante ?
        Casillero salida = unaPlaza.getSalida();

        if (salida.estaOcupado()){
            throw new SalidaOcupadaError();
        }

        Aldeano nuevoAldeano = unaPlaza.crearAldeano();
        elementos.add(nuevoAldeano);
        campo.colocarUnidad(nuevoAldeano,salida.obtenerPosicion());
        this.incrementarPoblacion();

    }

    public Espadachin crearEspadachin(Cuartel unCuartel) {
        Espadachin nuevoEspadachin = unCuartel.crearEspadachin();
        elementos.add(nuevoEspadachin);
        this.incrementarPoblacion();
        return nuevoEspadachin;
    }

    public Arquero crearArquero(Cuartel unCuartel) {
        Arquero nuevoArquero = unCuartel.crearArquero();
        elementos.add(nuevoArquero);
        this.incrementarPoblacion();

        return nuevoArquero;
    }

    public ArmaDeAsedio crearArmaAsedio(Castillo unCastillo) {
        ArmaDeAsedio nuevaArmaAsedio = unCastillo.crearArmaDeAsedio();
        elementos.add(nuevaArmaAsedio);
        this.incrementarPoblacion();

        return nuevaArmaAsedio;
    }

    public void construirEdificio(String edificio, Aldeano unAldeano, int x, int y) {
    }

    public void moverUnidad(Unidad unaUnidad, int x, int y) {
    }

    public void atacarA(Unidad unidadActual, Unidad unidadEnemiga) {

    }

    public void destruirUnidad(Unidad unaUnidad){
        elementos.remove(unaUnidad);
        this.disminuirPoblacion();
    }
}
