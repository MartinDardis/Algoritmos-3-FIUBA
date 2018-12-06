package Models.edificios.Estados;

public class EstadoDestruido implements EstadoReparacion {
    @Override
    public void reparar(int vidaPorReparacion) {

    }

    @Override
    public int getVida() {
        return 0;
    }

    @Override
    public void setVida(int nuevaVida) {

    }

    @Override
    public EstadoReparacion actualizarEstado(int vidaMaxima) {
        return null;
    }
}
