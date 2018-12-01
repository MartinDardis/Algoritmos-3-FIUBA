package Models.edificios;
import Models.Posicionable;
import Models.edificios.Estados.EstadoReparacion;
import Models.escenario.Casillero;
import Models.juego.Jugador;
import Models.unidades.Unidad;

import java.util.ArrayList;

public class Edificio implements Posicionable {

    protected int vidaMaxima;
    protected int vidaPorReparacion;
    protected int alto;
    protected int ancho;
    protected int rangoAtaque;
    protected int danioAEdificio;
    protected int danioAUnidad;
    protected Jugador propietario;
    protected Casillero salida;
    protected ArrayList<Casillero> ubicacion;
    //

    protected EstadoReparacion estadoReparacion;

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }

    public int getVida(){
        return this.estadoReparacion.getVida();
    }

    public void atacar(Posicionable unidadEnemiga) {

    }

    public Casillero getSalida() {
        return salida;
    }

    public void setEstadoReparacion(EstadoReparacion nuevoEstado){
        this.estadoReparacion = nuevoEstado;
    }
    public EstadoReparacion getEstadoReparacion(){
        return this.estadoReparacion;
    }

    public void setVida(int nuevaVida){
        this.estadoReparacion.setVida(nuevaVida);
    }

    public void setUbicacion(ArrayList<Casillero> listaPosc){
        ubicacion = listaPosc;
    }

    public void setSalida(Casillero salida) {
        this.salida = salida;
    }

    public void reparar(){
        this.estadoReparacion.reparar(this.vidaPorReparacion);
        this.estadoReparacion = this.estadoReparacion.actualizarEstado(this.vidaMaxima);
    }

    public String perteneceA(){
        return propietario.getNombre();
    }

    public boolean dentroRadioDeAtaque(int unaDistancia){
        if(rangoAtaque < unaDistancia){
            return false;
        }
        return true;
    }
    public void recibirDanio(int danio){
        int vidaActual = getVida();
        setVida(vidaActual-danio);
    }

    public int getRangoAtaque() {
        return rangoAtaque;
    }

    public int getDanioAEdificio() {
        return danioAEdificio;
    }

    public int getDanioAUnidad() {
        return danioAUnidad;
    }

    public int generarOro(){return 0;}

    public ArrayList<Casillero> getCasillero(){
        return this.ubicacion;
    }
    public int distanciaHasta(Posicionable otroPosicionable){
        ArrayList<Casillero> posiciones = otroPosicionable.getCasillero();
        Casillero posicionActual = this.getCasillero().get(0);
        ArrayList<Casillero> misPosiciones = this.getCasillero();
        int menorDistancia = posiciones.get(0).distanciaHasta(posicionActual);
        for (Casillero posicionPropia : misPosiciones){
            posicionActual = posicionPropia;
            for (Casillero casilleros : posiciones) {
                int distanciaActual = casilleros.distanciaHasta(posicionActual);
                if (distanciaActual < menorDistancia){
                    menorDistancia = distanciaActual;
                }
            }
        }
        return menorDistancia;
    }

    public void restaurarEstados(){
    }


}
