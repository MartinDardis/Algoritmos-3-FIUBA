package Models.unidades;

import Models.Posicionable;
import Models.edificios.Edificio;
import Models.juego.Jugador;
import Models.escenario.*;
import Models.escenario.errores.*;
import Models.unidades.errores.*;
import Models.unidades.estadosUnidad.EstadoUnidad;
import Models.unidades.estadosUnidad.EstadoDisponible;

import java.util.ArrayList;


public class Unidad implements Posicionable {

    protected int vida;
    protected int rangoAtaque;
    protected int danioAEdificio;
    protected int danioAUnidad;
    protected Jugador propietario;
    protected ArrayList<Casillero> ubicacion;
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

    public Jugador perteneceA(){
        return this.propietario;
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

    public ArrayList<Casillero> getCasillero() {
        return ubicacion;
    }

    public void setCasillero(Casillero nuevoCasillero) {
        ArrayList<Casillero> ubicaciones = new ArrayList<>();
        ubicaciones.add(nuevoCasillero);
        this.ubicacion = ubicaciones;
    }

    public void mover(Casillero nuevoCasillero)throws CasilleroAlejadoError, LugarOcupadoError {

        if(this.ubicacion.get(0).distanciaHasta(nuevoCasillero) > 1)
            throw new CasilleroAlejadoError();
        if(nuevoCasillero.estaOcupado())
            throw new LugarOcupadoError();

        this.estadoAccion.mover(this, nuevoCasillero);
        this.estadoAccion = this.estadoAccion.actualizarEstado();

    }

    public void atacar(Posicionable otroPosicionable) throws UnidadYaUtilizadaError {

        if(distanciaHasta(otroPosicionable) > this.rangoAtaque)
            throw new CasilleroAlejadoError();
        if (otroPosicionable.getClass() == Edificio.class){
            this.estadoAccion.atacar(otroPosicionable, this.danioAEdificio);

        }
        else {
            this.estadoAccion.atacar(otroPosicionable,this.danioAUnidad);
        }
        this.estadoAccion = this.estadoAccion.actualizarEstado();
    }

    public void recibirDanio(int danio){
        this.vida -= danio;
    }

    public int distanciaHasta(Posicionable otroPosicionable){
        ArrayList<Casillero> posiciones = otroPosicionable.getCasillero();
        Casillero posicionActual = this.getCasillero().get(0);
        int menorDistancia = posiciones.get(0).distanciaHasta(posicionActual);
        for (Casillero casilleros : posiciones) {
            int distanciaActual = casilleros.distanciaHasta(posicionActual);
            if (distanciaActual < menorDistancia){
                menorDistancia = distanciaActual;
            }
        }
        return menorDistancia;
    }

    public void restaurarEstados(){
        this.estadoAccion = new EstadoDisponible();
    }


}
