package Models.Partida;

import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.PlazaCentral;
import Models.escenario.Mapa;
import Models.juego.Jugador;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartidaTest {

    @Test
    public void TestCrearUnidadAumentaLaPoblacionDeActual(){
        Partida partida = new Partida("uno","dos");
        PlazaCentral unaPlaza = new PlazaCentral();
        Jugador actual = partida.getActual();

        int poblacionInicial = actual.getPoblacionActual();
        partida.crearAldeano(unaPlaza);
        int poblacionFinal = actual.getPoblacionActual();

        assertEquals(poblacionFinal, poblacionInicial + 1);


    }

    @Test (expected = OroInsuficienteError.class)
    public  void TestCrearUnidadSinOroSuficienteLanzaError(){
        Partida partida = new Partida("uno","dos");
        PlazaCentral unaPlaza = new PlazaCentral();
        Jugador actual = partida.getActual();

        int oroInicial = actual.getOro();
        actual.pagar(oroInicial-10);//Lo dejo casi sin reservas

        partida.crearAldeano(unaPlaza);




    }

}