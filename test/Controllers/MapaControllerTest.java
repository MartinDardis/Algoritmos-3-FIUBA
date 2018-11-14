package Controllers;

import Models.Posicionable;
import Models.escenario.Coordenada;
import Models.escenario.LugarVacioError;
import Models.escenario.Mapa;
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
        Coordenada posInvalida =  new Coordenada(6,6);
        Mapa campo = mp.getCampo();

        assertEquals(cuartel,campo.obtener(posc0));
        assertEquals(cuartel,campo.obtener(posc1));
        assertEquals(cuartel,campo.obtener(posc2));

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

}
