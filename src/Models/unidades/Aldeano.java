package Models.unidades;

public class Aldeano extends Unidad {

    private Estado estado;

    public Aldeano(){
        this.vida = 50;
        this.estado = new EstadoInactivo();
    }

    public int generarOro(){
        return this.estado.generarOro();
    }

    public void setEstado(Estado unEstado) {
        this.estado = unEstado;
    }

}
