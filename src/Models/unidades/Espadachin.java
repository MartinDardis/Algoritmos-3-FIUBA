package Models.unidades;

public class Espadachin extends Unidad {

    public Espadachin(){ this.vida = 100;
    }
    public Espadachin(String jugador){
        this.vida = 100;
        this.pertenece = jugador;
    }

}
