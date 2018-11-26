
package Models.escenario;

import Models.Posicionable;
import Models.escenario.errores.*;
import Models.unidades.errores.*;
import Models.unidades.Unidad;
import Models.unidades.Aldeano;
import Models.edificios.Edificio;

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
        if(posicionEdificio.distanciaHasta(unAldeano.getCasillero().obtenerPosicion()) > 1)
            throw new CasilleroAlejadoError();


        int numeroCasillero = posicionEdificio.obtenerNumero();
        Casillero casilleroEdificio = posiciones[numeroCasillero];
        Edificio edificioAReparar = (Edificio) casilleroEdificio.obtenerPosicionable();

        unAldeano.reparar(edificioAReparar);
    }



}