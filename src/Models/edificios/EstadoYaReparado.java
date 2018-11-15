package Models.edificios;

public class EstadoYaReparado implements EstadoReparacion{


    public int obtenerReparacion(){
        throw new EdificioYaReparadoError();
    }

}
