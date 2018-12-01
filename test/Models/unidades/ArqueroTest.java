package Models.unidades;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArqueroTest {

    @Test
    public void test01verificarVidaArqueroCreado() {

        Arquero unArquero = new Arquero();
        assertEquals(unArquero.getVida(), 75);
    }
}