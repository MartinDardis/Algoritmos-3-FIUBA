package Models.unidades;

import Models.Posicionable;
import Models.juego.Jugador;
import Models.escenario.*;
import Models.escenario.errores.LugarOcupadoError;
import Models.escenario.errores.LugarVacioError;
import Models.escenario.errores.PosicionFueraDeCampoError;
import Models.escenario.errores.CasilleroAlejadoError;

public class Unidad implements Posicionable {

    protected int vida;
    protected int rangoAtaque;
    protected int danioAEdificio;
    protected int danioAUnidad;
    protected Jugador propietario;
    protected Casillero posicion;

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
    public void recibirDanio(int danio){
        this.vida -= danio;
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

        Coordenada viejaCoordenada = this.posicion.obtenerPosicion();
        Coordenada nuevaCoordenada = nuevoCasillero.obtenerPosicion();

        if(viejaCoordenada.distanciaHasta(nuevaCoordenada) > 1)
            throw new CasilleroAlejadoError();
        if(nuevoCasillero.estaOcupado())
            throw new LugarOcupadoError();

        this.posicion.remover();


        nuevoCasillero.colocar(this);
        this.posicion = nuevoCasillero;

    }



}
