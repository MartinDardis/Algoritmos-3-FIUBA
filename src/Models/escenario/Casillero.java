package Models.escenario;
import Models.*;
import Models.escenario.errores.LugarOcupadoError;
import Models.escenario.errores.LugarVacioError;

public class Casillero {

    protected Coordenada ubicacion;
    protected Posicionable posicionable;
    //ver state ocupado/libre

    public Casillero(Coordenada unaCoordenada){
        this.ubicacion = unaCoordenada;
        this.posicionable = null;
    }

    boolean estaOcupado(){
        return (posicionable != null);
    }

    void mover(Coordenada nuevaUbicacion){
        this.ubicacion = nuevaUbicacion;
    }

    Coordenada obtenerPosicion(){
        return this.ubicacion;
    }

    Posicionable obtenerPosicionable(){
        return this.posicionable;
    }

    Posicionable remover(){
        if (!this.estaOcupado()){
            throw new LugarVacioError();
        }
        Posicionable aux = this.posicionable;
        this.posicionable = null;
        return aux;
    }

    void colocar(Posicionable nuevoPosicionable){
        //solucion temporal a arreglar con un state
        if (this.estaOcupado()){
            throw new LugarOcupadoError();
        }
        this.posicionable = nuevoPosicionable;
    }




}
