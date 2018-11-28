package Models.Partida;

import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.PlazaCentral;
import Models.escenario.Casillero;
import Models.escenario.Coordenada;
import Models.escenario.Mapa;
import Models.juego.Jugador;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartidaTest {

    @Test
    public void TestCrearUnidadAumentaLaPoblacionDeActual(){
        Partida partida = new Partida("uno","dos");
        PlazaCentral unaPlaza = new PlazaCentral();
        Coordenada posSalida = new Coordenada(4,4);
        Casillero salida = new Casillero(posSalida);
        unaPlaza.setSalida(salida);
        Jugador actual = partida.getActual();

        int poblacionInicial = actual.getPoblacionActual();
        partida.crearAldeano(unaPlaza);
        int poblacionFinal = actual.getPoblacionActual();

        assertEquals(poblacionFinal, poblacionInicial + 1);


    }

}