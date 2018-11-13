
package Models.escenario;
import Models.Posicionable;

import java.util.HashMap;

public class Mapa{

    private int columnas;
    private int filas;
    private HashMap<Coordenada, Posicionable> campo;

    public int getFilas(){
        return this.filas;
    }

    public int getColumnas(){
        return this.columnas;
    }

    public Mapa(){
        this.filas = 50;
        this.columnas = 50;
        this.campo = new HashMap<Coordenada, Posicionable>();
    }

    private boolean posicionDentroCampo(Coordenada posicion){
        return posicion.estaDentroDe(this.filas,this.columnas);
    }



    public void colocar(Posicionable nuevo,Coordenada posicion)throws LugarOcupadoError,PosicionFueraDeCampoError{
        if(!this.posicionDentroCampo(posicion))
            throw new PosicionFueraDeCampoError();
        if(this.campo.containsKey(posicion)){
            throw new LugarOcupadoError();
        }
        else
            this.campo.put(posicion,nuevo);
    }


    public Posicionable obtener(Coordenada posc)throws PosicionFueraDeCampoError,LugarVacioError{
        if(!this.posicionDentroCampo(posc))
            throw new PosicionFueraDeCampoError();
        if(!this.campo.containsKey(posc))
            throw new LugarVacioError();
        else
            return this.campo.get(posc);
    }



    public Posicionable remover(Coordenada coord)throws PosicionFueraDeCampoError,LugarVacioError{
        if(!this.posicionDentroCampo(coord))
            throw new PosicionFueraDeCampoError();
        if(!this.campo.containsKey(coord))
            throw new LugarVacioError();
        else {
            return (Posicionable)this.campo.remove(coord);
        }
    }



    public void mover(Coordenada viejaPosc,Coordenada nuevaPosc)throws LugarVacioError,PosicionFueraDeCampoError,LugarOcupadoError{
        if(!this.campo.containsKey(nuevaPosc)) {
            try {
                Posicionable temp = remover(viejaPosc);
                colocar(temp, nuevaPosc);
            } catch (LugarVacioError | PosicionFueraDeCampoError e) {
                throw e;
            }
        } else
            throw new LugarOcupadoError();
    }



}