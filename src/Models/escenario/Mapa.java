
package Models.escenario;

import Models.Posicionable;
import Models.escenario.errores.*;
import Models.unidades.errores.*;
import Models.unidades.Unidad;
import Models.unidades.Aldeano;
import Models.edificios.Edificio;

import java.util.ArrayList;

public class Mapa{

    private int columnas;
    private int filas;
    private Casillero[] posiciones;

    public int getFilas(){
        return this.filas;
    }
    public int getColumnas(){
        return this.columnas;
    }

    public Mapa(){
        this.filas = 25;
        this.columnas = 25;
        this.posiciones = new Casillero[filas*columnas];
        for (int i = 0; i<filas;i++){
            for (int j = 0; j<columnas;j++){
                Coordenada pos = new Coordenada(i,j);
                int indice = pos.obtenerNumero();
                //System.out.print(indice);
                posiciones[indice]= new Casillero(pos);
            }
        }

    }

    public Casillero obtenerCasillero (Coordenada coordenada){
        int numeroCasillero = coordenada.obtenerNumero();
        Casillero casillero = this.posiciones[numeroCasillero];
        return casillero;
    }

    private boolean posicionDentroCampo(Coordenada posicion){
        return posicion.estaDentroDe(this.filas,this.columnas);
    }


    public void colocarUnidad(Unidad unaUnidad,Coordenada posicion)throws LugarOcupadoError, PosicionFueraDeCampoError {

        if(!this.posicionDentroCampo(posicion))
            throw new PosicionFueraDeCampoError();

        int numeroCasillero = posicion.obtenerNumero();
        Casillero casillero = this.posiciones[numeroCasillero];

        casillero.colocar(unaUnidad);
        unaUnidad.setCasillero(casillero);

    }

    public void colocarEdificio(Edificio unEdificio,Coordenada origen)throws LugarOcupadoError, PosicionFueraDeCampoError {
        int alto = unEdificio.getAlto();
        int ancho = unEdificio.getAncho();
        int origenX = origen.getFila();
        int origenY = origen.getColumna();
        ArrayList <Casillero> lista = this.obtenerArea(origenX,origenY,alto,ancho);
        for (Casillero casilerro :lista) {
            casilerro.colocar(unEdificio);
        }
        unEdificio.setUbicacion(lista);
    }

    private ArrayList <Casillero> obtenerArea(int columnaOrigen, int filaOrigen, int alto, int ancho)throws LugarOcupadoError, PosicionFueraDeCampoError{
        ArrayList <Casillero> salida = new ArrayList();
        for(int i = columnaOrigen; i < (alto + columnaOrigen);i++){
            for(int j= filaOrigen; j < (ancho + filaOrigen);j++){
                Coordenada posc = new Coordenada(i,j);
                if(!this.posicionDentroCampo(posc))
                    throw new PosicionFueraDeCampoError();
                if(this.posiciones[posc.obtenerNumero()].estaOcupado())
                    throw new LugarOcupadoError();
                salida.add(this.posiciones[posc.obtenerNumero()]);
            }
        }
        return salida;
    }


    public Posicionable obtener(Coordenada posicion)throws PosicionFueraDeCampoError, LugarVacioError {

        if(!this.posicionDentroCampo(posicion))
            throw new PosicionFueraDeCampoError();

        int numeroCasillero = posicion.obtenerNumero();
        return this.posiciones[numeroCasillero].obtenerPosicionable();

    }

    public Posicionable remover(Coordenada posicion)throws PosicionFueraDeCampoError,LugarVacioError{

        if(!this.posicionDentroCampo(posicion))
            throw new PosicionFueraDeCampoError();

        int numeroCasillero = posicion.obtenerNumero();

        return (Posicionable)this.posiciones[numeroCasillero].remover();

    }


    public void mover(Unidad unaUnidad,Coordenada nuevaPosicion) throws CasilleroAlejadoError,PosicionFueraDeCampoError,LugarOcupadoError{

        if(!nuevaPosicion.estaDentroDe(this.filas,this.columnas))
            throw new PosicionFueraDeCampoError();

        int nuevoNumeroCasillero = nuevaPosicion.obtenerNumero();
        Casillero nuevoCasillero = posiciones[nuevoNumeroCasillero];

        unaUnidad.mover(nuevoCasillero);

    }

    public void reparar(Aldeano unAldeano, Coordenada posicionEdificio) throws AldeanoOcupadoError, CasilleroAlejadoError, PosicionFueraDeCampoError{

        if(!posicionEdificio.estaDentroDe(this.filas,this.columnas))
            throw new PosicionFueraDeCampoError();

        //Este if va a estar acá hasta que el edificio tenga su posicion o lista de posiciones
        if(posicionEdificio.distanciaHasta(unAldeano.getCasillero().get(0).obtenerPosicion()) > 1)
            throw new CasilleroAlejadoError();


        int numeroCasillero = posicionEdificio.obtenerNumero();
        Casillero casilleroEdificio = posiciones[numeroCasillero];
        Edificio edificioAReparar = (Edificio) casilleroEdificio.obtenerPosicionable();

        unAldeano.reparar(edificioAReparar);
    }

    public void atacar(Unidad unaUnidad, Unidad otraUnidad) throws CasilleroAlejadoError,PosicionFueraDeCampoError, UnidadYaUtilizadaError{

        if(!otraUnidad.getCasillero().get(0).obtenerPosicion().estaDentroDe(this.filas,this.columnas))
            throw new PosicionFueraDeCampoError();

        unaUnidad.atacar(otraUnidad);

    }


}