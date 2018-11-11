package Models.edificios;

public class PlazaCentral {

    private int vida;
    private int costo;
    private int turnosConstruccion;

    public PlazaCentral() {
        vida = 450;
        costo = 100;
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
