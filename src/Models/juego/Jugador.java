package Models.juego;

import java.util.ArrayList;

import Models.Partida.SalidaOcupadaError;
import Models.Posicionable;
import Models.escenario.*;
import Models.escenario.errores.LugarOcupadoError;
import Models.juego.errores.*;
import Models.unidades.*;
import Models.edificios.*;
import Models.edificios.Errores.OroInsuficienteError;
import Models.unidades.errores.AldeanoOcupadoError;
import Views.layouts.BotonCasillero;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Jugador {

    private int oro;
    private int poblacionActual;//Array de unidades ?
    
    private ArrayList<Posicionable> elementos;

    private String nombre;
    private Mapa campo;
    private Jugador siguiente;
    private Castillo castillo;


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

    public void restaurarEstados(){

        for (Posicionable elem: elementos ) {
           elem.restaurarEstados();
        }

    }

    public ArrayList<Posicionable> listaElementos() {
        return elementos;
    }

    public boolean poseeElemento(Posicionable unElemento) {
        return elementos.contains(unElemento);
    }

    public boolean saldoSuficiente (int costo){
        if(this.oro >= costo)
            return true;
        else
            throw new OroInsuficienteError();
    }

    public void crearCastilloInicialEn(int fila, int columna) {
        Coordenada  origen = new Coordenada(fila,columna);
        Castillo castilloInicial = new Castillo(this);
        Coordenada salida = new Coordenada(fila,columna+castilloInicial.getAncho());

        Casillero casilleroSalida = campo.obtenerCasillero(salida);
        castilloInicial.setSalida(casilleroSalida);
        elementos.add(castilloInicial);
        castillo = castilloInicial;
        campo.colocarEdificio(castilloInicial,origen);
    }

    public void crearPlazaCentralInicial(int fila, int columna){
        Coordenada origen = new Coordenada(fila,columna);
        PlazaCentral plazaInicial = new PlazaCentral();
        plazaInicial.setJugador(this);
        Coordenada salida = new Coordenada( fila ,columna+plazaInicial.getAncho());

        Casillero casilleroSalida = campo.obtenerCasillero(salida);
        plazaInicial.setSalida(casilleroSalida);
        elementos.add(plazaInicial);
        campo.colocarEdificio(plazaInicial,origen);
    }


    public void crearAldeanosInicialesDesde(int fila, int col) {
        int cantAldeanosIniciales = 3;
        for (int i = 0 ; i<cantAldeanosIniciales ;i++ ){
            Coordenada origen = new Coordenada(fila+i,col);
            Aldeano nuevoAldeano = new Aldeano(this);
            elementos.add(nuevoAldeano);
            campo.colocarUnidad(nuevoAldeano,origen);
            this.incrementarPoblacion();
        }
    }

    public void crearAldeano(PlazaCentral unaPlaza) {
        Casillero salida = unaPlaza.getSalida();

        if (salida.estaOcupado()){
            throw new SalidaOcupadaError();
        }

        this.pagar(25);//getCosto o constante ?

        Aldeano nuevoAldeano = unaPlaza.crearAldeano();
        elementos.add(nuevoAldeano);
        campo.colocarUnidad(nuevoAldeano,salida.obtenerPosicion());
        this.incrementarPoblacion();

    }

    public void crearEspadachin(Cuartel unCuartel) {
        Casillero salida = unCuartel.getSalida();

        if (salida.estaOcupado()){
            throw new SalidaOcupadaError();
        }
        this.pagar(50);

        Espadachin nuevoEspadachin = unCuartel.crearEspadachin();
        elementos.add(nuevoEspadachin);
        campo.colocarUnidad(nuevoEspadachin,salida.obtenerPosicion());
        this.incrementarPoblacion();
    }

    public void crearArquero(Cuartel unCuartel) {
        Casillero salida = unCuartel.getSalida();

        if (salida.estaOcupado()){
            throw new SalidaOcupadaError();
        }
        this.pagar(75);

        Arquero nuevoArquero = unCuartel.crearArquero();
        elementos.add(nuevoArquero);
        campo.colocarUnidad(nuevoArquero,salida.obtenerPosicion());
        this.incrementarPoblacion();
    }

    public void crearArmaAsedio(Castillo unCastillo) {
        Casillero salida = unCastillo.getSalida();

        if (salida.estaOcupado()){
            throw new SalidaOcupadaError();
        }
        this.pagar(200);
        ArmaDeAsedio nuevaArma = unCastillo.crearArmaDeAsedio();
        elementos.add(nuevaArma);
        campo.colocarUnidad(nuevaArma,salida.obtenerPosicion());
        this.incrementarPoblacion();
    }

    public void construirPlazaCentral(Aldeano unAldeano, int x, int y)throws AldeanoOcupadoError, LugarOcupadoError,NoPerteneceAJugadorError {
        if(!elementos.contains(unAldeano)){throw new NoPerteneceAJugadorError();}
        this.saldoSuficiente(100);
        PlazaCentral unaPlaza = unAldeano.construirPlazaCentral(this);
        Coordenada poscInicial = new Coordenada(x,y);
        this.campo.colocarEdificio(unaPlaza,poscInicial);
        this.pagar(100);
        unAldeano.comenzarConstruccion();
        elementos.add(unaPlaza);

    }

    public void construirCuartel(Aldeano unAldeano, int x, int y)throws AldeanoOcupadoError,LugarOcupadoError, NoPerteneceAJugadorError {
        if(!elementos.contains(unAldeano)){throw new NoPerteneceAJugadorError();}
        this.saldoSuficiente(100);//add
        Cuartel unCuartel = unAldeano.construirCuartel(this);
        Coordenada posInicial = new Coordenada(x,y);
        this.campo.colocarEdificio(unCuartel,posInicial);
        this.pagar(100);//add
        unAldeano.comenzarConstruccion();
        elementos.add(unCuartel);
    }

    public void moverUnidad(Unidad unaUnidad, int x, int y) {
        if (! soyPropietario(unaUnidad)){
            throw new UnidadEnemigaNoPuedeUsarseError();
        }
        Coordenada destino = new Coordenada(x,y);
        Casillero casilleroDestino = campo.obtenerCasillero(destino);
        unaUnidad.mover(casilleroDestino);

    }

    private boolean soyPropietario(Unidad unaUnidad) {
        return this.elementos.contains(unaUnidad);
    }

    public void atacarA(Posicionable unidadActual, Posicionable unidadEnemiga) {
        if (unidadEnemiga.perteneceA() == this)
            throw new ObjetivoEsDelMismoJugadorError();
        unidadActual.atacar(unidadEnemiga);
    }

    public void destruirPosicionable(Posicionable unPosicionable){
        ArrayList<Casillero> casillerosQueOcupa = unPosicionable.getCasillero();
        for (Casillero unCasillero : casillerosQueOcupa ){
            Coordenada unaCoord = unCasillero.obtenerPosicion();
            campo.remover(unaCoord);
        }
        elementos.remove(unPosicionable);
        if (unPosicionable.getClass() == Unidad.class){
            this.disminuirPoblacion();
        }
    }


    public void realizarAtaqueCastillo(ArrayList <Posicionable> listaAtacables) {
        for (Posicionable atacable :listaAtacables) {
            this.atacarA(castillo,atacable);
        }
    }

    public boolean tieneCastillo() {
        return elementos.contains(this.castillo);
    }
}
