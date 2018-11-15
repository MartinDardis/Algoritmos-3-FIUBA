package Models.edificios;

import Models.edificios.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CastilloTest {

    @Test
    public void Test01VerificarVidaCastilloCreado(){
        Castillo unCastillo = new Castillo();
        assertEquals(unCastillo.getVida(),1000);
    }

    @Test (expected = OroInsuficienteError.class)
    public void Test02CrearArmaAsedioConOroInsuficienteLanzaExcepcion(){
        Castillo unCastillo = new Castillo();
        unCastillo.crearArmaDeAsedio(10);
    }

    @Test(expected = EdificioVidaCompletaError.class)
    public void Test03NoPuedeSerReparadoConVidaCompleta(){

        Castillo unCastillo = new Castillo();
        unCastillo.reparar();
    }

    @Test(expected = EdificioYaReparadoError.class)
    public void Test04NoPuedeSerReparadoSiYaFueReparado(){

        Castillo unCastillo = new Castillo();
        EstadoReparacion estadoYaReparado = new EstadoYaReparado();
        unCastillo.setEstadoReparacion(estadoYaReparado);

        unCastillo.reparar();

    }


    @Test
    public void Test05SerReparadoSumaVidaPedida(){

        Castillo unCastillo = new Castillo();
        EstadoReparacion estadoDaniado = new EstadoCastilloDaniado();

        unCastillo.setVida(900);
        unCastillo.setEstadoReparacion(estadoDaniado);
        unCastillo.reparar();

        assertEquals(unCastillo.getVida(),915);
    }


    @Test
    public void Test06ExcedenteDeReparacionLoDejaEnVidaMaxima(){

        Castillo unCastillo = new Castillo();
        EstadoReparacion estadoDaniado = new EstadoCastilloDaniado();

        unCastillo.setVida(995);
        unCastillo.setEstadoReparacion(estadoDaniado);
        unCastillo.reparar();

        assertEquals(unCastillo.getVida(),1000);
        assertEquals(unCastillo.getEstadoReparacion().getClass(),EstadoVidaCompleta.class);
    }

}