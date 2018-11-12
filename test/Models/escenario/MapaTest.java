package Models.escenario;

import Models.Posicionable;
import Models.unidades.Aldeano;
import Models.unidades.ArmaDeAsedio;
import Models.unidades.Arquero;
import Models.unidades.Unidad;

import org.junit.Test;
import static junit.framework.TestCase.*;


public class MapaTest {

    @Test
    public void test01crearMapaYVerificarTamañoDefinido() {

        Mapa unMapa = new Mapa();

        assertEquals(50, unMapa.getColumnas());
        assertEquals(50, unMapa.getFilas());
    }

    @Test
    public void test02CrearMapaYVerificarDireccionDeMemoria() {
        Mapa unMapa = new Mapa();
        assertNotNull(unMapa);
    }

    @Test
    public void test03ColocarPosicionableDentroDelCampo() {
        Posicionable unElemento = new Aldeano();
        Mapa unMapa = new Mapa();
        Coordenada posc = new Coordenada(5, 5);

        unMapa.colocar(unElemento, posc);
        assertEquals(unElemento, unMapa.obtener(posc));
    }

    @Test
    public void test04colocarAldeanoEnElOrigenYVerificar() {

        Mapa unMapa = new Mapa();
        Aldeano unAldeano = new Aldeano();
        Coordenada origen = new Coordenada(0, 0);

        unMapa.colocar(unAldeano, origen);

        Unidad unidadEnOrigen = (Unidad) unMapa.obtener(origen);

        assertEquals(unidadEnOrigen, unAldeano);
    }

    @Test
    public void test05colocarAldeanoEnElOrigenYLuegoMover() {

        Mapa unMapa = new Mapa();
        Aldeano unAldeano = new Aldeano();
        Coordenada origen = new Coordenada(0, 0);
        Coordenada nuevaPosicion = new Coordenada(2, 2);

        unMapa.colocar(unAldeano, origen);
        unMapa.mover(origen, nuevaPosicion);
        Aldeano unidadEnPosicionNueva = (Aldeano) unMapa.obtener(nuevaPosicion);

        assertEquals(unidadEnPosicionNueva, unAldeano);

    }

    @Test
    public void test06colocarArqueroEnElOrigenYLuegoMover() {

        Mapa unMapa = new Mapa();
        Unidad unArquero = new Arquero();
        Coordenada origen = new Coordenada(0, 0);
        Coordenada nuevaPosicion = new Coordenada(4, 4);

        unMapa.colocar(unArquero, origen);
        assertEquals(unArquero,unMapa.obtener(origen));

        unMapa.mover(origen, nuevaPosicion);
        Unidad unidadEnPosicionNueva = (Unidad)unMapa.obtener(nuevaPosicion);

        assertEquals(unidadEnPosicionNueva, unArquero);
    }

    @Test
    public void test07colocarAsedioEnElOrigenYLuegoBorrar() {

        Mapa unMapa = new Mapa();
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Coordenada origen = new Coordenada(0, 0);
        Coordenada nuevaPosicion = new Coordenada(3, 3);

        unMapa.colocar(unAsedio, origen);
        Unidad unidadRemovida = (Unidad)unMapa.remover(origen);

        assertEquals(unidadRemovida, unAsedio);
    }

    @Test(expected = LugarVacioError.class)
    public void test08colocarAsedioEnElOrigenYLuegoBorrarDosVeces() {

        Mapa unMapa = new Mapa();
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Coordenada origen = new Coordenada(0, 0);
        unMapa.colocar(unAsedio, origen);

        Unidad unidadRemovida = (Unidad)unMapa.remover(origen);
        unidadRemovida = (Unidad)unMapa.remover(origen); //Borro por segunda vez
    }
}