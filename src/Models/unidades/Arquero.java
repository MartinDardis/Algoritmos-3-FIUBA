package Models.unidades;

public class Arquero extends Unidad {

    public Arquero(){
        this.vida = 75;
    }

    public Arquero(String jugador){
        this.pertenece = jugador;
        this.vida = 75;
    }

}