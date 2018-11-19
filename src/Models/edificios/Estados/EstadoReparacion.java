package Models.edificios.Estados;

public interface EstadoReparacion {

    void reparar(int vidaPorReparacion);
    int getVida();
    void setVida(int nuevaVida);

}
