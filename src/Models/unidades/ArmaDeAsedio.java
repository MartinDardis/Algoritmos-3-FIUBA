package Models.unidades;

import Models.juego.Jugador;
import Models.unidades.estadosArmaAsedio.EstadoArma;
import Models.unidades.estadosArmaAsedio.EstadoMontada;
import Models.unidades.estadosArmaAsedio.EstadoNoMontada;

public class ArmaDeAsedio extends Unidad{

    private EstadoArma estado;

    public ArmaDeAsedio(){
        this.vida = 150;
    }
    public ArmaDeAsedio(Jugador jugador){
        this.propietario = jugador;
        this.vida = 150;
        this.estado =  new EstadoNoMontada();
        this.danioAEdificio = 75;
        this.danioAUnidad = 0; //No aplica, deberia lanzar excepcion cuando movamos el comportamiento aca
    }

    public void montar(){
        this.estado = new EstadoMontada();
    }

    public void desmontar(){
        this.estado = new EstadoNoMontada();
    }
}
