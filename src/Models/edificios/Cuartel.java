package Models.edificios;

public class Cuartel {
    private int vida;
    private int costo;
    private int turnosConstruccion;

    public Cuartel() {
        vida = 250;
        costo = 50;
        turnosConstruccion = 3;
    }
    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return costo;
    }

    public int getTurnosConstruccion() {
        return turnosConstruccion;
    }
}
