package Models;

import Models.unidades.*;
import Models.escenario.*;

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
        Coordenada nuevaPosicion = new Coordenada(2,2);

        unMapa.colocarUnidad(unAldeano, origen);
        unMapa.moverUnidad(origen, nuevaPosicion);
        Unidad unidadEnPosicionNueva = unMapa.obtenerUnidad(nuevaPosicion);

        assertEquals(unidadEnPosicionNueva, unAldeano);

    }

    @Test
    public void test03colocarArqueroEnElOrigenYLuegoMover(){

        Mapa unMapa = new Mapa();
        Arquero unArquero = new Arquero();
        Coordenada origen = new Coordenada(0,0);
        Coordenada nuevaPosicion = new Coordenada(4,4);

        unMapa.colocarUnidad(unArquero, origen);
        unMapa.moverUnidad(origen, nuevaPosicion);
        Unidad unidadEnPosicionNueva = unMapa.obtenerUnidad(nuevaPosicion);

        assertEquals(unidadEnPosicionNueva, unArquero);
    }

    @Test
    public void test04colocarAsedioEnElOrigenYLuegoBorrar(){

        Mapa unMapa = new Mapa();
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Coordenada origen = new Coordenada(0,0);
        Coordenada nuevaPosicion = new Coordenada(3,3);

        unMapa.colocarUnidad(unAsedio, origen);
        Unidad unidadRemovida = unMapa.removerUnidad(origen);

        assertEquals(unidadRemovida, unAsedio);
    }

    @Test (expected = LugarVacioError.class)
    public void test05colocarAsedioEnElOrigenYLuegoBorrarDosVeces(){

        Mapa unMapa = new Mapa();
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Coordenada origen = new Coordenada(0,0);
        unMapa.colocarUnidad(unAsedio, origen);

        Unidad unidadRemovida = unMapa.removerUnidad(origen);
        unidadRemovida = unMapa.removerUnidad(origen); //Borro por segunda vez
    }

}
