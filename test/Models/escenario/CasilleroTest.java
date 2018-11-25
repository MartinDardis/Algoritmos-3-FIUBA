package Models.escenario;

import Models.Posicionable;
import Models.escenario.Coordenada;
import Models.unidades.Aldeano;
import Models.unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.*;

public class CasilleroTest {

    @Test
    public void test01CasilleroNuevoEstaVacio(){

        Coordenada unaCoordenada = new Coordenada(2,3);
        Casillero unCasillero =  new Casillero(unaCoordenada);

        assertFalse(unCasillero.estaOcupado());
    }

    @Test
    public void test02CasilleroOcupadoSeMuestraOcupado(){

        Coordenada unaCoordenada = new Coordenada(4,4);
        Casillero unCasillero =  new Casillero(unaCoordenada);
        Aldeano unAldeano = new Aldeano();

        unCasillero.colocar(unAldeano);

        assertTrue(unCasillero.estaOcupado());
    }

    @Test
    public void test03RemoverDejaVacioElCasillero(){

        Coordenada unaCoordenada = new Coordenada(1,1);
        Casillero unCasillero =  new Casillero(unaCoordenada);
        Aldeano unAldeano = new Aldeano();

        unCasillero.colocar(unAldeano);
        unCasillero.remover();

        assertFalse(unCasillero.estaOcupado());
    }

    @Test
    public void test04RemoverDevuelveLoQueHabia(){

        Coordenada unaCoordenada = new Coordenada(1,1);
        Casillero unCasillero =  new Casillero(unaCoordenada);
        Aldeano unAldeano = new Aldeano();

        unCasillero.colocar(unAldeano);
        Posicionable unElemento = unCasillero.remover();

        assertEquals(unAldeano, unElemento);
    }

    @Test (expected = LugarOcupadoError.class)
    public void test05ColocarEnCasilleroOcupado(){

        Coordenada unaCoordenada = new Coordenada(5,5);
        Casillero unCasillero = new Casillero(unaCoordenada);
        Aldeano unAldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();

        unCasillero.colocar(unAldeano);
        unCasillero.colocar(otroAldeano);
    }
}