package Models.edificios.Estados;

import Models.edificios.Errores.EdificioVidaCompletaError;

public class EstadoVidaCompleta implements EstadoReparacion {

    private int vida;

    public EstadoVidaCompleta(int vidaMaxima){
        this.vida = vidaMaxima;
    }

    public void reparar(int vidaPorReparacion){
        throw new EdificioVidaCompletaError();
    }
    public int getVida(){return (this.vida);}
    public void setVida(int nuevaVida){ this.vida = nuevaVida; }

    public EstadoReparacion actualizarEstado(int vidaMaxima){
        return this;
    }
}
