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

    public boolean estaOcupado(){
        return (posicionable != null);
    }

    public void mover(Coordenada nuevaUbicacion){
        this.ubicacion = nuevaUbicacion;
    }

    public Coordenada obtenerPosicion(){
        return this.ubicacion;
    }

    public Posicionable obtenerPosicionable(){
        return this.posicionable;
    }

    public Posicionable remover(){
        if (!this.estaOcupado()){
            throw new LugarVacioError();
        }
        Posicionable aux = this.posicionable;
        this.posicionable = null;
        return aux;
    }

    public void colocar(Posicionable nuevoPosicionable){
        //solucion temporal a arreglar con un state
        if (this.estaOcupado()){
            throw new LugarOcupadoError();
        }
        this.posicionable = nuevoPosicionable;
    }




}
