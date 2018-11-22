package Models.edificios;
import Models.Posicionable;
import Models.edificios.Errores.EdificioNoReparableError;
import Models.edificios.Estados.EstadoReparacion;
import Models.edificios.Estados.EstadoVidaCompleta;
import Models.edificios.Estados.EstadoYaReparado;

public class Edificio implements Posicionable {

    protected int vidaMaxima;
    protected int vidaPorReparacion;
    protected int alto;
    protected int ancho;
    protected int rango;
    protected String pertenece;

    protected EstadoReparacion estadoReparacion;

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }

    public int getVida(){
        return this.estadoReparacion.getVida();
    }

    public void setEstadoReparacion(EstadoReparacion nuevoEstado){
        this.estadoReparacion = nuevoEstado;
    }
    public EstadoReparacion getEstadoReparacion(){
        return this.estadoReparacion;
    }

    public void setVida(int nuevaVida){
        this.estadoReparacion.setVida(nuevaVida);
    }

    public void reparar(){
        this.estadoReparacion.reparar(this.vidaPorReparacion);
        this.actualizarEstado();
    }

    public void actualizarEstado(){
        int vidaActual = this.estadoReparacion.getVida();
        if( vidaActual >= this.vidaMaxima){ this.estadoReparacion = new EstadoVidaCompleta(vidaMaxima); }
        else{ this.estadoReparacion = new EstadoYaReparado(vidaActual); }
    }

    public String perteneceA(){
        return pertenece;
    }

    public boolean dentroRadioDeAtaque(int unaDistancia){
        if(rango > unaDistancia){
            return false;
        }
        return true;
    }
    public void recibirDanio(int danio){
        int vidaActual = getVida();
        setVida(vidaActual-danio);
    }
}
