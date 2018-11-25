
package Models.escenario;
import Models.Posicionable;

import java.util.HashMap;

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
        this.posiciones = new Casillero[100];
    }

    private boolean posicionDentroCampo(Coordenada posicion){
        return posicion.estaDentroDe(this.filas,this.columnas);
    }



    public void colocar(Posicionable nuevo,Coordenada posicion)throws LugarOcupadoError,PosicionFueraDeCampoError{
        if(!this.posicionDentroCampo(posicion))
            throw new PosicionFueraDeCampoError();
        if(this.campo.containsKey(posicion.asKey())){
            throw new LugarOcupadoError();
        }
        else
            this.campo.put(posicion.asKey(),nuevo);
    }


    public Posicionable obtener(Coordenada posc)throws PosicionFueraDeCampoError,LugarVacioError{
        if(!this.posicionDentroCampo(posc))
            throw new PosicionFueraDeCampoError();
        if(!this.campo.containsKey(posc.asKey()))
            throw new LugarVacioError();
        else
            return this.campo.get(posc.asKey());
    }



    public Posicionable remover(Coordenada coord)throws PosicionFueraDeCampoError,LugarVacioError{
        if(!this.posicionDentroCampo(coord))
            throw new PosicionFueraDeCampoError();
        if(!this.campo.containsKey(coord.asKey()))
            throw new LugarVacioError();
        else {
            return (Posicionable)this.campo.remove(coord.asKey());
        }
    }



    public void mover(Coordenada viejaPosc,Coordenada nuevaPosc)throws LugarVacioError,PosicionFueraDeCampoError,LugarOcupadoError{
        if(!this.campo.containsKey(nuevaPosc.asKey())) {
            try {
                Posicionable temp = this.remover(viejaPosc);
                colocar(temp, nuevaPosc);
            } catch (LugarVacioError | PosicionFueraDeCampoError e) {
                throw e;
            }
        } else
            throw new LugarOcupadoError();
    }

    public boolean posicionVacia(Coordenada unaPosicion){
        return (!this.campo.containsKey(unaPosicion.asKey()));
    }

}