package Models.unidades;

public class ArmaDeAsedio extends Unidad{

    public ArmaDeAsedio(){
        this.vida = 150;
    }
    public ArmaDeAsedio(String jugador){
        this.pertenece = jugador;
        this.vida = 150;
    }

}
