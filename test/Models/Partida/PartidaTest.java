package Models.Partida;

import Models.Posicionable;
import Models.edificios.Castillo;
import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.Estados.EdificioEnConstruccionError;
import Models.edificios.PlazaCentral;
import Models.escenario.Casillero;
import Models.escenario.Coordenada;
import Models.escenario.Mapa;
import Models.juego.Jugador;
import Models.unidades.Aldeano;
import Models.unidades.Espadachin;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartidaTest {

    @Test
    public void TestCrearUnidadAumentaLaPoblacionDeActual(){
        Partida partida = new Partida("uno","dos");
        PlazaCentral unaPlaza = new PlazaCentral();
        Coordenada posSalida = new Coordenada(24,24);//al usar una plaza nueva en este test, dejo esta pos que NO CHOCA con lo inicializado por partida
        Casillero salida = new Casillero(posSalida);
        unaPlaza.setSalida(salida);
        Jugador actual = partida.getActual();

        int poblacionInicial = actual.getPoblacionActual();
        partida.crearAldeano(unaPlaza);
        int poblacionFinal = actual.getPoblacionActual();

        assertEquals(poblacionFinal, poblacionInicial + 1);

    }
    @Test
    public void testInicializarPartidaGeneraTresAldeanos(){
        Partida partida = new Partida("uno","dos");
        int poblacionJugador = partida.getJugador1().getPoblacionActual();
        int poblacionEsperada = 3;

        assertEquals(poblacionJugador,poblacionEsperada);
    }

    @Test
    public void testInciarNuevaPartidaPreparaJugadores(){
        Partida partida = new Partida("uno","dos");
        Jugador jugador1 = partida.getJugador1();
        Jugador jugador2 = partida.getJugador2();

        assertEquals(jugador1.listaElementos().size(),5);
        assertEquals(jugador2.listaElementos().size(),5);
    }

    @Test
    public void testTerminarTurno(){
        Partida partida = new Partida("uno","dos");
        Jugador jugador1 = partida.getJugador1();
        Jugador jugador2 = partida.getJugador2();

        assertEquals(partida.getActual(),jugador1);

        partida.terminarTurno();

        assertEquals(partida.getActual(),jugador2);
    }

    @Test
    public void testPlazaCentralCreaUnAldeano(){
        Partida partida = new Partida("uno","dos");
        Posicionable plazaJugador1 = partida.obtenerElementoEn(new Coordenada(4,4));
        for (int i = 0; i<6; i++){//3 turnos propios pasan para habilitar el edificio
            partida.terminarTurno();
        }

        partida.crearAldeano((PlazaCentral)plazaJugador1);
        Coordenada salida = new Coordenada(4,6);

        Posicionable aldeanoCreado = partida.obtenerElementoEn(salida);
        Aldeano dePrueba = new Aldeano();

        assertEquals(dePrueba.getClass(),aldeanoCreado.getClass());

    }
    @Test(expected = EdificioEnConstruccionError.class)
    public void testEdificioEnConstruccionLanzaErrorAlPedirleCrear(){
        Partida partida = new Partida("uno","dos");
        Posicionable plazaJugadorUno = partida.obtenerElementoEn(new Coordenada(4,4));

        partida.crearAldeano((PlazaCentral) plazaJugadorUno);
    }

    @Test(expected = partidaFinalizadaError.class)
    public void testCastilloEnemigoDestruidoGanaPartidaNoPasaTurno(){
        Partida partida = new Partida("uno","dos");
        Coordenada posCastilloEnemigo = new Coordenada(12,15);
        Castillo castilloEnemigo = (Castillo)partida.obtenerElementoEn(posCastilloEnemigo);
        castilloEnemigo.setVida(1);
        Espadachin unEspadachin = new Espadachin();
        Casillero posEspadachin = new Casillero(new Coordenada(11,15));
        unEspadachin.setCasillero(posEspadachin);

        partida.atacar(unEspadachin,castilloEnemigo);

        partida.terminarTurno();
    }
}