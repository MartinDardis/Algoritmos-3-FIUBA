package Models.edificios;

import org.junit.Test;

import static org.junit.Assert.*;

public class CuartelTest {

    @Test
    public void Test01VerificarVidaCuartelCreado() {

        Cuartel unCuartel = new Cuartel();
        assertEquals(unCuartel.getVida(), 250);
    }

    @Test (expected = OroInsuficienteError.class)
    public void Test02CrearArqueroConOroInsuficienteLanzaExcepcion(){
        Cuartel unCuartel = new Cuartel();
        unCuartel.crearArquero(10);
    }


    @Test (expected = OroInsuficienteError.class)
    public void Test03CrearEspadachinConOroInsuficienteLanzaExcepcion(){
        Cuartel unCuartel = new Cuartel();
        unCuartel.crearEspadachin(10);
    }


    @Test(expected = EdificioVidaCompletaError.class)
    public void Test04NoPuedeSerReparadoConVidaCompleta(){

        Cuartel unCuartel = new Cuartel();
        unCuartel.reparar();
    }


    @Test(expected = EdificioYaReparadoError.class)
    public void Test05NoPuedeSerReparadoSiYaFueReparado(){

        Cuartel unCuartel = new Cuartel();
        EstadoReparacion estadoYaReparado = new EstadoYaReparado();
        unCuartel.setEstadoReparacion(estadoYaReparado);

        unCuartel.reparar();

    }

    @Test
    public void Test06SerReparadoSumaVidaPedida(){

        Cuartel unCuartel = new Cuartel();
        EstadoReparacion estadoDaniado = new EstadoCuartelDaniado();

        unCuartel.setVida(150);
        unCuartel.setEstadoReparacion(estadoDaniado);
        unCuartel.reparar();

        assertEquals(unCuartel.getVida(),200);
    }

    @Test
    public void Test07ExcedenteDeReparacionLoDejaEnVidaMaxima(){

        Cuartel unCuartel = new Cuartel();
        EstadoReparacion estadoDaniado = new EstadoCuartelDaniado();

        unCuartel.setVida(240);
        unCuartel.setEstadoReparacion(estadoDaniado);
        unCuartel.reparar();

        assertEquals(unCuartel.getVida(),250);
        assertEquals(unCuartel.getEstadoReparacion().getClass(),EstadoVidaCompleta.class);
    }

}