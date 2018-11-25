package Models.escenario;

import Models.Posicionable;
import Models.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.*;

public class CasilleroTest {

    @Test
    public void test01CasilleroNuevoEstaVacio(){
        Casillero unCasillero =  new Casillero();

        assertFalse(unCasillero.estaOcupado());
    }
    @Test
    public void test02CasilleroOcupadoSeMuestraOcupado(){
        Casillero unCasillero =  new Casillero();
        Aldeano unAldeano = new Aldeano();

        unCasillero.colocar(unAldeano);

        assertTrue(unCasillero.estaOcupado());

    }

    @Test
    public void test03RemoverDejaVacioElCasillero(){
        Casillero unCasillero =  new Casillero();
        Aldeano unAldeano = new Aldeano();

        unCasillero.colocar(unAldeano);
        unCasillero.remover();

        assertFalse(unCasillero.estaOcupado());
    }

    @Test (expected = LugarOcupadoError.class)
    public void test04ColocarEnCasilleroOcupado(){
        Casillero unCasillero = new Casillero();
        Aldeano unAldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();

        unCasillero.colocar(unAldeano);
        unCasillero.colocar(otroAldeano);
    }
}