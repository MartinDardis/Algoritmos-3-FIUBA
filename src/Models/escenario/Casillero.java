package Models.escenario;
import Models.*;

public class Casillero {

    protected Coordenada ubicacion;
    protected Posicionable posicionable;

//    boolean estaOcupado(){ }

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
        return this.posicionable;
    }



}
