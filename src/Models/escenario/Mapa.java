
package Models.escenario;

import Models.Posicionable;
import Models.escenario.errores.LugarOcupadoError;
import Models.escenario.errores.LugarVacioError;
import Models.escenario.errores.PosicionFueraDeCampoError;
import Models.unidades.Unidad;

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
        this.filas = 50;
        this.columnas = 50;
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


    public void colocar(Posicionable nuevo,Coordenada posicion)throws LugarOcupadoError, PosicionFueraDeCampoError {

        if(!this.posicionDentroCampo(posicion))
            throw new PosicionFueraDeCampoError();

        int numeroCasillero = posicion.obtenerNumero();
        this.posiciones[numeroCasillero].colocar(nuevo);

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


    public void mover(Unidad unaUnidad,Coordenada nuevaPosc)throws LugarVacioError,PosicionFueraDeCampoError,LugarOcupadoError{

        int nuevoNumeroCasillero = nuevaPosc.obtenerNumero();
        int viejoNumeroCasillero = unaUnidad.getCasillero().obtenerPosicion().obtenerNumero();

        Casillero nuevoCasillero = posiciones[nuevoNumeroCasillero];
        Casillero viejoCasillero = posiciones[viejoNumeroCasillero];

        nuevoCasillero.colocar(unaUnidad);
        viejoCasillero.remover();

        unaUnidad.mover(nuevoCasillero);

    }

}