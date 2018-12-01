package Models.edificios;

import Models.edificios.Errores.EdificioVidaCompletaError;
import Models.edificios.Errores.EdificioYaReparadoError;
import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class CastilloTest {

    @Test
    public void Test01VerificarVidaCastilloCreado(){
        Castillo unCastillo = new Castillo();
        assertEquals(unCastillo.getVida(),1000);
    }

    @Test(expected = EdificioVidaCompletaError.class)
    public void Test02NoPuedeSerReparadoConVidaCompleta(){

        Castillo unCastillo = new Castillo();
        unCastillo.reparar();
    }

    @Test(expected = EdificioYaReparadoError.class)
    public void Test03NoPuedeSerReparadoSiYaFueReparado(){

        Castillo unCastillo = new Castillo();
        int vidaActual = 500;

        EstadoReparacion estadoYaReparado = new EstadoYaReparado(vidaActual);
        unCastillo.setEstadoReparacion(estadoYaReparado);

        unCastillo.reparar();
    }


    @Test
    public void Test04SerReparadoSumaVidaPedida(){

        Castillo unCastillo = new Castillo();
        int vidaActual = 500;
        EstadoReparacion estadoDaniado = new EstadoDaniado(vidaActual);

        unCastillo.setEstadoReparacion(estadoDaniado);
        unCastillo.reparar();

        assertEquals(unCastillo.getVida(),515);
    }


    @Test
    public void Test05ExcedenteDeReparacionLoDejaEnVidaMaxima() {

        Castillo unCastillo = new Castillo();
        int vidaActual = 995;
        EstadoReparacion estadoDaniado = new EstadoDaniado(vidaActual);

        unCastillo.setEstadoReparacion(estadoDaniado);
        unCastillo.reparar();

        assertEquals(unCastillo.getVida(), 1000);

    }

    @Test
    public void Test06ExcedenteDeReparacionLoDejaEnEstadoVidaCompleta() {

        Castillo unCastillo = new Castillo();
        int vidaActual = 995;
        EstadoReparacion estadoDaniado = new EstadoDaniado(vidaActual);

        unCastillo.setEstadoReparacion(estadoDaniado);
        unCastillo.reparar();

        assertEquals(unCastillo.getEstadoReparacion().getClass(), EstadoVidaCompleta.class);
    }

}