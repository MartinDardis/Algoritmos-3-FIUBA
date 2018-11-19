package Controllers;

import Models.Posicionable;
import Models.escenario.Coordenada;
import Models.escenario.LugarVacioError;
import Models.escenario.Mapa;
import Models.escenario.PosicionFueraDeCampoError;
import Models.unidades.*;
import Models.edificios.*;

import org.junit.Test;
import static junit.framework.TestCase.*;


public class MapaControllerTest {

    @Test
    public void test01CrearUnControllerContieneUnMapa(){
        MapaController mp = new MapaController();

        assertNotNull(mp.getCampo());
    }

    @Test
    public void test02ColocarAldeanoEnPosicionValida(){
        MapaController mp = new MapaController();
        Aldeano aldeano = new Aldeano();

        mp.colocar(aldeano,4,4);
        Coordenada posc= new Coordenada(4,4);
        Mapa campo = mp.getCampo();

        assertEquals(aldeano,campo.obtener(posc));

    }

    @Test(expected = LugarVacioError.class)
    public void test03ColocarAldeanoYLuegoRemover(){
        MapaController mp = new MapaController();
        Aldeano aldeano = new Aldeano();

        mp.colocar(aldeano,4,4);
        mp.remover(aldeano);

        Mapa campo = mp.getCampo();
        Coordenada pos = new Coordenada(4,4);
        campo.obtener(pos);
    }

    @Test
    public void test04ColocarCuartelEnPosicionValida(){
        MapaController mp = new MapaController();
        Cuartel cuartel = new Cuartel();

        mp.colocar(cuartel,4,4);
        Coordenada posc0= new Coordenada(4,4);
        Coordenada posc1= new Coordenada(5,5);
        Coordenada posc2= new Coordenada(4,5);
        Coordenada posc3 = new Coordenada(5,4);
        Mapa campo = mp.getCampo();

        assertEquals(cuartel,campo.obtener(posc0));
        assertEquals(cuartel,campo.obtener(posc1));
        assertEquals(cuartel,campo.obtener(posc2));
        assertEquals(cuartel,campo.obtener(posc3));

    }

    @Test(expected = LugarVacioError.class)
    public void test05VerificarEdificioNoEstaFueraDeSusDimensiones(){
        MapaController mp = new MapaController();
        Cuartel cuartel = new Cuartel();

        mp.colocar(cuartel,4,4);
        Coordenada posInvalida = new Coordenada(3,3);
        Mapa campo = mp.getCampo();

        assertEquals(cuartel,campo.obtener(posInvalida));
    }

    @Test
    public void test06VerificarRecaudacionDe3AldeanosInactivos(){

        MapaController mp = new MapaController();
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();

        mp.colocar(aldeano1,0,0);
        mp.colocar(aldeano2,1,1);
        mp.colocar(aldeano3,2,2);

        int oroRecogido = mp.recolectarOro();

        assertEquals(oroRecogido, 60);

    }

    @Test
    public void test07VerificarRecaudacionDe2AldeanosInactivosY1Construyendo(){

        MapaController mp = new MapaController();
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();
        Estado estadoConstructor = new EstadoConstructor();

        aldeano3.setEstado(estadoConstructor);
        mp.colocar(aldeano1,0,0);
        mp.colocar(aldeano2,1,1);
        mp.colocar(aldeano3,2,2);

        int oroRecogido = mp.recolectarOro();

        assertEquals(oroRecogido, 40);

    }

    @Test
    public void test08VerificarRecaudacionDe3AldeanosRestaurados(){

        MapaController mp = new MapaController();

        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();
        Estado estadoConstructor = new EstadoConstructor();

        aldeano1.setEstado(estadoConstructor);
        aldeano2.setEstado(estadoConstructor);
        aldeano3.setEstado(estadoConstructor);

        mp.colocar(aldeano1,0,0);
        mp.colocar(aldeano2,1,1);
        mp.colocar(aldeano3,2,2);

        mp.restaurarAldeanos();

        int oroRecogido = mp.recolectarOro();

        assertEquals(oroRecogido, 60);

    }

    @Test
    public void test09MoverAldeanoAPosicionValida() {

        MapaController mp = new MapaController();

        Aldeano unAldeano = new Aldeano();

        mp.colocar(unAldeano, 0, 0);
        Coordenada posAledania = new Coordenada(1, 1);
        mp.mover(unAldeano, posAledania.getFila(), posAledania.getColumna());
        Mapa campo = mp.getCampo();

        assertEquals(unAldeano, campo.obtener(posAledania));
    }

    @Test (expected = SuperaDistanciaMaximaError.class)
    public void test10MoverAldeanoAPosicionInvalidaLanzaError() {

        MapaController mp = new MapaController();

        Aldeano unAldeano = new Aldeano();

        mp.colocar(unAldeano, 0, 0);
        Coordenada posAledania = new Coordenada(2, 1);
        mp.mover(unAldeano, posAledania.getFila(), posAledania.getColumna());
    }

    @Test (expected = PosicionFueraDeCampoError.class)
    public void test11MoverAldeanoAPosicionAledaniaFueraDeCampoLanzaError() {

        MapaController mp = new MapaController();

        Aldeano unAldeano = new Aldeano();

        mp.colocar(unAldeano, 0, 0);
        Coordenada posAledania = new Coordenada(-1, 0);
        mp.mover(unAldeano, posAledania.getFila(), posAledania.getColumna());
    }

    @Test
    public void test12ContruirArmaAsedioConOroSuficienteYColocarEnPosicionVacia() {

        MapaController mp = new MapaController();

        Castillo unCastillo = new Castillo();
        mp.colocar(unCastillo,0,0);

        mp.crearAsedioEn(unCastillo,1000); //Simula oro suficiente
        Mapa campo = mp.getCampo();
        Coordenada posSupuesta = new Coordenada(5,5);

        assertEquals(campo.obtener(posSupuesta).getClass(),ArmaDeAsedio.class);
    }

    @Test
    public void test13CrearAldeanoConOroSuficienteYColocarEnPosicionVacia() {

        MapaController mp = new MapaController();
        PlazaCentral unaPlaza = new PlazaCentral();

        mp.colocar(unaPlaza,0,0);
        mp.crearAldeanoEn(unaPlaza,5000); //Simula oro suficiente
        Mapa campo = mp.getCampo();
        Coordenada posSupuesta = new Coordenada(3,3);

        assertEquals(campo.obtener(posSupuesta).getClass(),Aldeano.class);
    }

    @Test
    public void test14CrearArqueroConOroSuficienteYColocarEnPosicionVacia() {

        MapaController mp = new MapaController();
        Cuartel unCuartel = new Cuartel();

        mp.colocar(unCuartel,0,0);
        mp.crearArqueroEn(unCuartel,5000); //Simula oro suficiente
        Mapa campo = mp.getCampo();
        Coordenada posSupuesta = new Coordenada(3,3);

        assertEquals(campo.obtener(posSupuesta).getClass(),Arquero.class);
    }

    @Test
    public void test15CrearEspadachinConOroSuficienteYColocarEnPosicionVacia() {

        MapaController mp = new MapaController();
        Cuartel unCuartel = new Cuartel();

        mp.colocar(unCuartel,0,0);
        mp.crearEspadachinEn(unCuartel,5000); //Simula oro suficiente
        Mapa campo = mp.getCampo();
        Coordenada posSupuesta = new Coordenada(3,3);

        assertEquals(campo.obtener(posSupuesta).getClass(),Espadachin.class);
    }

    @Test (expected = NoExisteElementoError.class)
    public void test16RemoverMismaUnidadDosVecesLanzaError() {

        MapaController mp = new MapaController();
        Aldeano unAldeano = new Aldeano();

        mp.colocar(unAldeano,0,0);
        mp.remover(unAldeano);
        mp.remover(unAldeano);
    }

}
