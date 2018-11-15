package Models.edificios;

public class EstadoVidaCompleta implements EstadoReparacion {

    public int obtenerReparacion(){
        throw new EdificioVidaCompletaError();
    }
}
