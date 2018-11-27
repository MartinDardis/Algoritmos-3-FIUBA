package Models.edificios;

import Models.edificios.Errores.EdificioVidaCompletaError;
import Models.edificios.Errores.EdificioYaReparadoError;
import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CuartelTest {

    @Test
    public void Test01VerificarVidaCuartelCreado() {

        Cuartel unCuartel = new Cuartel();
        assertEquals(unCuartel.getVida(), 250);
    }



    @Test(expected = EdificioVidaCompletaError.class)
    public void Test04NoPuedeSerReparadoConVidaCompleta(){

        Cuartel unCuartel = new Cuartel();
        unCuartel.reparar();
    }


    @Test(expected = EdificioYaReparadoError.class)
    public void Test05NoPuedeSerReparadoSiYaFueReparado(){

        Cuartel unCuartel = new Cuartel();
        int vidaActual = 100;
        EstadoReparacion estadoYaReparado = new EstadoYaReparado(vidaActual);
        unCuartel.setEstadoReparacion(estadoYaReparado);

        unCuartel.reparar();

    }

    @Test
    public void Test06SerReparadoSumaVidaPedida(){

        Cuartel unCuartel = new Cuartel();
        int vidaActual = 150;
        EstadoReparacion estadoDaniado = new EstadoDaniado(vidaActual);


        unCuartel.setEstadoReparacion(estadoDaniado);
        unCuartel.reparar();

        assertEquals(unCuartel.getVida(),200);
    }

    @Test
    public void Test07ExcedenteDeReparacionLoDejaEnVidaMaxima(){

        Cuartel unCuartel = new Cuartel();
        int vidaActual = 240;
        EstadoReparacion estadoDaniado = new EstadoDaniado(vidaActual);

        unCuartel.setEstadoReparacion(estadoDaniado);
        unCuartel.reparar();

        assertEquals(unCuartel.getVida(),250);
        assertEquals(unCuartel.getEstadoReparacion().getClass(), EstadoVidaCompleta.class);
    }

}