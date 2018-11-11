package Models;

import Models.unidades.Aldeano;
import Models.escenario.Mapa;
import Models.escenario.Coordenada;
import Models.unidades.Unidad;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class escenarioUnidadTest {

    @Test
    public void test01colocarAldeanoEnElOrigenYVerificar(){

        Mapa unMapa = new Mapa();
        Aldeano unAldeano = new Aldeano();
        Coordenada origen = new Coordenada(0,0);

        unMapa.colocarUnidad(unAldeano, origen);

        Unidad unidadEnOrigen = unMapa.obtenerUnidad(origen);

        assertEquals(unidadEnOrigen, unAldeano);

    }

    @Test
    public void test02colocarAldeanoEnElOrigenYLuegoMover(){

        Mapa unMapa = new Mapa();
        Aldeano unAldeano = new Aldeano();
        Coordenada origen = new Coordenada(0,0);
        Coordenada nuevaPosicion = new Coordenada(0,0);

        unMapa.colocarUnidad(unAldeano, origen);
        unMapa.moverUnidad(origen, nuevaPosicion);
        Unidad unidadEnPosicionNueva = unMapa.obtenerUnidad(nuevaPosicion);

        assertEquals(unidadEnPosicionNueva, unAldeano);

    }

}
