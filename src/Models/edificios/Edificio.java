package Models.edificios;
import Models.edificios.*;
import Models.Posicionable;

public class Edificio implements Posicionable {

    protected int vida;
    protected int vidaMaxima;

    protected EstadoReparacion estadoReparacion;

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }

    public int getVida(){
        return this.vida;
    }

    public void reparar(){

        try{
            int vidaExtra = this.estadoReparacion.obtenerReparacion();

            if((this.vida + vidaExtra) >= vidaMaxima){
                this.estadoReparacion = new EstadoVidaCompleta();
                this.vida = this.vidaMaxima;
            }

            else {
                this.estadoReparacion = new EstadoYaReparado();
                this.vida += vidaExtra;
            }
        }
        catch(EdificioNoReparableError e){
            throw e;
        }
    }

    public void setEstadoReparacion(EstadoReparacion nuevoEstado){
        this.estadoReparacion = nuevoEstado;
    }

    public EstadoReparacion getEstadoReparacion(){
        return this.estadoReparacion;
    }
    public void setVida(int nuevaVida){
        this.vida = nuevaVida;
    }

}
