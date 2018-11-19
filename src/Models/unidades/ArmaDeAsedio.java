package Models.unidades;

public class ArmaDeAsedio extends Unidad{

    private EstadoArma estado;

    public ArmaDeAsedio(){
        this.vida = 150;
    }
    public ArmaDeAsedio(String jugador){
        this.pertenece = jugador;
        this.vida = 150;
        this.estado =  new EstadoNoMontada();
    }

    public void montar(){
        this.estado = new EstadoMontada();
    }

    public void desmontar(){
        this.estado = new EstadoNoMontada();
    }
}
