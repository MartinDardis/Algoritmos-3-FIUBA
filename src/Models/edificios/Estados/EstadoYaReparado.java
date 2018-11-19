package Models.edificios.Estados;

import Models.edificios.Errores.EdificioYaReparadoError;

public class EstadoYaReparado implements EstadoReparacion{

    private int vida;

    public EstadoYaReparado(int vidaActual){
        this.vida = vidaActual;
    }

    public void reparar(int vidaPorReparacion){
        throw new EdificioYaReparadoError();
    }
    public int getVida(){ return this.vida;}
    public void setVida(int nuevaVida){ this.vida = nuevaVida; }

}
