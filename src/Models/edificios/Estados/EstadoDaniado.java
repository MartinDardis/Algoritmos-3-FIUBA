package Models.edificios.Estados;

public class EstadoDaniado implements EstadoReparacion{

    private int vida;

    public EstadoDaniado(int vidaActual){
        this.vida = vidaActual;
    }

    public void reparar(int vidaPorReparacion){
        this.vida += vidaPorReparacion;
    }
    public int getVida(){ return this.vida;};
    public void setVida(int nuevaVida){ this.vida = nuevaVida;}

}
