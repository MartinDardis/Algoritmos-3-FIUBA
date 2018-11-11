package Models.unidades;

import org.junit.Test;

import static org.junit.Assert.*;

public class AldeanoTest {

    @Test
    public void test01_verificarVidaAldeanoCreado() {

        Aldeano unAldeano = new Aldeano();
        assertEquals(unAldeano.getVida(), 50);
    }
}