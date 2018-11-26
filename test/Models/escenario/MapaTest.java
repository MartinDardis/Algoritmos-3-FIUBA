package Models.escenario;

import Models.Posicionable;
import Models.unidades.*;
import Models.edificios.*;

import org.junit.Test;
import static junit.framework.TestCase.*;


public class MapaTest {

    @Test
    public void test01crearMapaYVerificarTamanioDefinido() {

        Mapa unMapa = new Mapa();

        assertEquals(25, unMapa.getColumnas());
        assertEquals(25, unMapa.getFilas());
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
    public void test05colocarCuartelEnElOrigenYVerificar(){

        Mapa unMapa = new Mapa();
        Cuartel unCuartel = new Cuartel();
        Coordenada origen = new Coordenada(0,0);

        unMapa.colocar(unCuartel, origen);

        Edificio edificioEnOrigen = (Edificio) unMapa.obtener(origen);

        assertEquals(edificioEnOrigen, unCuartel);
    }

    @Test
    public void test06colocarAldeanoEnElOrigenYLuegoMover() {

        Mapa unMapa = new Mapa();
        Coordenada origen = new Coordenada(0, 0);
        Coordenada nuevaPosicion = new Coordenada(2, 2);
        Casillero casilleroOrigen = new Casillero(origen);
        Aldeano unAldeano = new Aldeano(casilleroOrigen);

        unMapa.colocar(unAldeano, origen);
        unMapa.mover(unAldeano, nuevaPosicion);
        Aldeano unidadEnPosicionNueva = (Aldeano) unMapa.obtener(nuevaPosicion);

        assertEquals(unidadEnPosicionNueva, unAldeano);

    }

    @Test
    public void test07colocarArqueroEnElOrigenYLuegoMover() {

        Mapa unMapa = new Mapa();
        Coordenada origen = new Coordenada(0, 0);
        Coordenada nuevaPosicion = new Coordenada(4, 4);
        Casillero casilleroOrigen = new Casillero(origen);
        Unidad unArquero = new Arquero(casilleroOrigen);



        unMapa.colocar(unArquero, origen);
        assertEquals(unArquero,unMapa.obtener(origen));

        unMapa.mover(unArquero, nuevaPosicion);
        Unidad unidadEnPosicionNueva = (Unidad) unMapa.obtener(nuevaPosicion);

        assertEquals(unidadEnPosicionNueva, unArquero);
    }

    @Test
    public void test08colocarAsedioEnElOrigenYLuegoRemover() {

        Mapa unMapa = new Mapa();
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Coordenada origen = new Coordenada(0, 0);
        Coordenada nuevaPosicion = new Coordenada(3, 3);

        unMapa.colocar(unAsedio, origen);
        Unidad unidadRemovida = (Unidad)unMapa.remover(origen);

        assertEquals(unidadRemovida, unAsedio);
    }

    @Test
    public void test09colocarCuartelEnElOrigenYLuegoRemover(){

        Mapa unMapa = new Mapa();
        Cuartel unCuartel = new Cuartel();
        Coordenada origen = new Coordenada(0,0);

        unMapa.colocar(unCuartel, origen);

        Edificio edificioRemovido = (Edificio) unMapa.remover(origen);

        assertEquals(edificioRemovido, unCuartel);
    }

    @Test(expected = LugarVacioError.class)
    public void test10colocarAsedioEnElOrigenYLuegoBorrarDosVeces() {

        Mapa unMapa = new Mapa();
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Coordenada origen = new Coordenada(0, 0);
        unMapa.colocar(unAsedio, origen);

        Unidad unidadRemovida = (Unidad)unMapa.remover(origen);
        unidadRemovida = (Unidad)unMapa.remover(origen); //Removerlo por segunda vez lanza error
    }

    @Test (expected = LugarVacioError.class)
    public void test11colocarUnCastilloYRemoverDosVeces(){

        Mapa unMapa = new Mapa();
        Castillo unCastillo = new Castillo();
        Coordenada origen = new Coordenada(0,0);

        unMapa.colocar(unCastillo, origen);
        Edificio unEdificio = (Edificio) unMapa.remover(origen);
        unEdificio = (Edificio) unMapa.remover(origen); //Removerlo por segunda vez lanza error
    }

    @Test
    public void test12DosAldeanosColocadosSonDistintos() {

        Mapa unMapa = new Mapa();
        Aldeano unAldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();
        Coordenada origen = new Coordenada(0, 0);
        Coordenada otraPosicion = new Coordenada(1,1);

        unMapa.colocar(unAldeano, origen);
        unMapa.colocar(otroAldeano,otraPosicion);

        assertNotSame(unAldeano,otroAldeano);
    }

    @Test
    public void test13colocarDosCuartelesYVerificarSeanDistintos(){

        Mapa unMapa = new Mapa();
        Cuartel unCuartel = new Cuartel();
        Cuartel otroCuartel = new Cuartel();
        Coordenada origen = new Coordenada(0,0);
        Coordenada otroLugar = new Coordenada(2,2);

        unMapa.colocar(unCuartel, origen);
        unMapa.colocar(otroCuartel, otroLugar);

        Edificio unEdificio = (Edificio) unMapa.obtener(origen);
        Edificio otroEdificio = (Edificio) unMapa.obtener(otroLugar);

        assertNotSame(unEdificio, otroEdificio);
    }

    @Test (expected = LugarOcupadoError.class)
    public void test14colocarDosPlazasEnElOrigen(){

        Mapa unMapa = new Mapa();
        PlazaCentral unaPlaza = new PlazaCentral();
        PlazaCentral otraPlaza = new PlazaCentral();
        Coordenada origen = new Coordenada(0,0);

        unMapa.colocar(unaPlaza, origen);
        unMapa.colocar(otraPlaza, origen); //Colocar en el mismo lugar lanza error
    }

}