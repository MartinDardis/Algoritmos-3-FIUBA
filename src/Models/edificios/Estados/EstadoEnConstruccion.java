package Models.edificios.Estados;

import Models.edificios.Errores.EdificioVidaCompletaError;

public class EstadoEnConstruccion implements EstadoReparacion {
    private int turnosRestantes;
    private int vida;

    public  EstadoEnConstruccion(int turnosConstruccion){
        this.turnosRestantes = turnosConstruccion;
    }

    public void reparar(int vidaPorReparacion){
        throw new EdificioEnConstruccionError();
    }

    @Override
    public int getVida() {
        throw new EdificioEnConstruccionError();
    }

    @Override
    public void setVida(int nuevaVida) {
        this.vida = nuevaVida;
    }

    @Override
    public EstadoReparacion actualizarEstado(int vidaMaxima) {
        turnosRestantes --;
        if (turnosRestantes <= 0){
            return new EstadoVidaCompleta(vidaMaxima);
        }
        return this;
    }



}
