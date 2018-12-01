package Models.edificios;

import Models.edificios.Errores.EdificioVidaCompletaError;
import Models.edificios.Errores.EdificioYaReparadoError;
import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.*;

import Models.escenario.Coordenada;
import Models.escenario.Mapa;
import Models.juego.Jugador;
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

    @Test
    public void Test07CastilloAtacaAEdificioSoloUnaVez(){//no ataca una vez por cada casillero que ocupa, solo una vez por edificio
        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("unNombre",unMapa);
        Jugador otroJugador = new Jugador("otroNombre",unMapa);
        Castillo unCastillo = new Castillo(unJugador);
        Coordenada origenCastillo = new Coordenada(0,0);
        unMapa.colocarEdificio(unCastillo,origenCastillo);
        PlazaCentral unaPlaza = new PlazaCentral(otroJugador);
        unaPlaza.setEstadoReparacion( new EstadoVidaCompleta(unaPlaza.vidaMaxima));
        Coordenada origenPlaza = new Coordenada(4,4);
        unMapa.colocarEdificio(unaPlaza,origenPlaza);

        int vidaInicialPlaza = unaPlaza.getVida();

        unCastillo.atacar(unaPlaza);
        int vidaFinalPlaza = unaPlaza.getVida();
        int ataqueCastillo = unCastillo.danioAEdificio;

        assertEquals(vidaFinalPlaza, vidaInicialPlaza-ataqueCastillo);

    }

}