package Models.unidades;

import org.junit.Test;

import static org.junit.Assert.*;

public class EspadachinTest {

    @Test
    public void test01verificarVidaEspadachinCreado(){

        Espadachin unEspadachin = new Espadachin();
        assertEquals(unEspadachin.getVida(), 100);
    }
}