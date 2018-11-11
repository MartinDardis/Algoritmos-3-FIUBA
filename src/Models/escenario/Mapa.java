
package Models.escenario;
import java.util.HashMap;
import java.util.Map;
import Models.unidades.Unidad;

public class Mapa{

    private int columnas;
    private int filas;
    private Map <Coordenada,Unidad> campo;

    public Mapa(){
        this.filas = 50;
        this.columnas = 50;
        this.campo = new HashMap<Coordenada,Unidad>();
    }

    private boolean posicionDentroCampo(Coordenada posicion){
        return posicion.estaDentroDe(this.filas,this.columnas);
    }

    public void colocarUnidad(Unidad nuevo,Coordenada posicion)throws LugarOcupadoError,PosicionFueraDeCampoError{
        if(!this.posicionDentroCampo(posicion))
            throw new PosicionFueraDeCampoError();
        if(this.campo.containsKey(posicion))
            this.campo.put(posicion,nuevo);
        else
            throw new  LugarOcupadoError();
    }

    public Unidad obtenerUnidad(Coordenada posc)throws PosicionFueraDeCampoError,LugarVacioError{
        if(!this.posicionDentroCampo(posc))
            throw new PosicionFueraDeCampoError();
        if(this.campo.containsKey(posc))
            throw new LugarVacioError();
        else
            return (Unidad)this.campo.get(posc);
    }

    public Unidad removerUnidad(Coordenada coord)throws PosicionFueraDeCampoError,LugarVacioError{
        if(!this.posicionDentroCampo(coord))
            throw new PosicionFueraDeCampoError();
        if(!this.campo.containsKey(coord))
            throw new LugarVacioError();
        else
            return (Unidad)this.campo.remove(coord);
    }

    public void moverUnidad(Coordenada viejaPosc,Coordenada nuevaPosc)throws LugarVacioError,PosicionFueraDeCampoError,LugarOcupadoError{
        if(this.campo.containsKey(nuevaPosc)) {
            try {
                Unidad temp = removerUnidad(viejaPosc);
                colocarUnidad(temp, nuevaPosc);
            } catch (LugarVacioError | PosicionFueraDeCampoError e) {
                throw e;
            }
        } else
            throw new LugarOcupadoError();
    }

    public int getFilas(){
        return this.filas;
    }

    public int getColumnas(){
        return this.columnas;
    }

}