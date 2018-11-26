package Models.edificios;
import Models.Posicionable;
import Models.edificios.Estados.EstadoReparacion;
import Models.edificios.Estados.EstadoVidaCompleta;
import Models.edificios.Estados.EstadoYaReparado;
import Models.juego.Jugador;

public class Edificio implements Posicionable {

    protected int vidaMaxima;
    protected int vidaPorReparacion;
    protected int alto;
    protected int ancho;
    protected int rangoAtaque;
    protected int danioAEdificio;
    protected int danioAUnidad;
    protected Jugador propietario;
    //

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
        this.estadoReparacion = this.estadoReparacion.actualizarEstado(this.vidaMaxima);
    }

    public String perteneceA(){
        return propietario.getNombre();
    }

    public boolean dentroRadioDeAtaque(int unaDistancia){
        if(rangoAtaque < unaDistancia){
            return false;
        }
        return true;
    }
    public void recibirDanio(int danio){
        int vidaActual = getVida();
        setVida(vidaActual-danio);
    }

    public int getRangoAtaque() {
        return rangoAtaque;
    }

    public int getDanioAEdificio() {
        return danioAEdificio;
    }

    public int getDanioAUnidad() {
        return danioAUnidad;
    }

    public int generarOro(){return 0;}
}
