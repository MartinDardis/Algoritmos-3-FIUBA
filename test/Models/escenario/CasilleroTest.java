package Models.escenario;

import Models.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.*;

public class CasilleroTest {

    @Test
    public void test01CasilleroNuevoEstaVacio(){
        Coordenada unaCoordenada = new Coordenada(1,1);
        Casillero unCasillero =  new Casillero(unaCoordenada);

        assertFalse(unCasillero.estaOcupado());
    }
    @Test
    public void test02CasilleroOcupadoSeMuestraOcupado(){
        Coordenada unaCoordenada = new Coordenada(1,1);
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

    @Test (expected = LugarOcupadoError.class)
    public void test04ColocarEnCasilleroOcupado(){
        Coordenada unaCoordenada = new Coordenada(1,1);
        Casillero unCasillero =  new Casillero(unaCoordenada);
        Aldeano unAldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();

        unCasillero.colocar(unAldeano);
        unCasillero.colocar(otroAldeano);
    }
}