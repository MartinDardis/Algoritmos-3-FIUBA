package Models.unidades;

import Models.Posicionable;
import Models.juego.Jugador;
import Models.escenario.*;
import Models.escenario.errores.*;
import Models.unidades.errores.*;
import Models.unidades.estadosUnidad.EstadoUnidad;


public class Unidad implements Posicionable {

    protected int vida;
    protected int rangoAtaque;
    protected int danioAEdificio;
    protected int danioAUnidad;
    protected Jugador propietario;
    protected Casillero posicion;
    protected EstadoUnidad estadoAccion;

    public int getVida(){
        return this.vida;
    }

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }

    public String perteneceA(){
        return this.propietario.getNombre();
    }

    public boolean dentroRadioDeAtaque(int unaDistancia){
        if(rangoAtaque > unaDistancia){
            return false;
        }
        return true;
    }

    public int generarOro(){return 0;}

    public int getRangoAtaque() {
        return rangoAtaque;
    }

    public int getDanioAUnidad() {
        return danioAUnidad;
    }

    public int getDanioAEdificio() {
        return danioAEdificio;
    }

    public Casillero getCasillero() {
        return posicion;
    }

    public void setCasillero(Casillero nuevoCasillero) {
        this.posicion = nuevoCasillero;
    }

    public void mover(Casillero nuevoCasillero)throws CasilleroAlejadoError, LugarOcupadoError {

        if(this.posicion.distanciaHasta(nuevoCasillero) > 1)
            throw new CasilleroAlejadoError();
        if(nuevoCasillero.estaOcupado())
            throw new LugarOcupadoError();

        this.estadoAccion.mover(this, nuevoCasillero);
        this.estadoAccion = this.estadoAccion.actualizarEstado();

    }

    public void atacar(Unidad otraUnidad) throws UnidadYaUtilizadaError {

        if(distanciaHasta(otraUnidad) > this.rangoAtaque)
            throw new CasilleroAlejadoError();

        this.estadoAccion.atacar(otraUnidad, this.danioAUnidad);
        this.estadoAccion = this.estadoAccion.actualizarEstado();
    }

    public void recibirDanio(int danio){
        this.vida -= danio;
    }

    public int distanciaHasta(Unidad otraUnidad){

        return otraUnidad.getCasillero().obtenerPosicion().distanciaHasta(this.getCasillero().obtenerPosicion());

    }


}
