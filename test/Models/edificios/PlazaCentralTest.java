package Models.edificios;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlazaCentralTest {

    @Test
    public void Test01VerificarVidaPlazaCentralCreada() {

        PlazaCentral unaPlaza = new PlazaCentral();
        assertEquals(unaPlaza.getVida(), 450);
    }

    @Test(expected = OroInsuficienteError.class)
    public void Test02CrearAldeanoConOroInsuficiente() {

        PlazaCentral unaPlaza = new PlazaCentral();
        unaPlaza.crearAldeano(5);
    }


    @Test(expected = EdificioVidaCompletaError.class)
    public void Test03NoPuedeSerReparadoConVidaCompleta(){

        PlazaCentral unaPlaza = new PlazaCentral();
        unaPlaza.reparar();
    }


    @Test(expected = EdificioYaReparadoError.class)
    public void Test04NoPuedeSerReparadoSiYaFueReparado(){

        PlazaCentral unaPlaza = new PlazaCentral();
        EstadoReparacion estadoYaReparado = new EstadoYaReparado();
        unaPlaza.setEstadoReparacion(estadoYaReparado);

        unaPlaza.reparar();
    }

    @Test
    public void Test05SerReparadoSumaVidaPedida(){

        PlazaCentral unaPlaza = new PlazaCentral();
        EstadoReparacion estadoDaniado = new EstadoPlazaDaniada();
        unaPlaza.setVida(400);
        unaPlaza.setEstadoReparacion(estadoDaniado);

        unaPlaza.reparar();

        assertEquals(unaPlaza.getVida(),425);
    }

    @Test
    public void Test07ExcedenteDeReparacionLoDejaEnVidaMaxima(){

        PlazaCentral unaPlaza = new PlazaCentral();
        EstadoReparacion estadoDaniado = new EstadoCuartelDaniado();

        unaPlaza.setVida(445);
        unaPlaza.setEstadoReparacion(estadoDaniado);
        unaPlaza.reparar();

        assertEquals(unaPlaza.getVida(),450);
        assertEquals(unaPlaza.getEstadoReparacion().getClass(),EstadoVidaCompleta.class);
    }


}
