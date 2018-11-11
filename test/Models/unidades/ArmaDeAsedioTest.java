package Models.unidades;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArmaDeAsedioTest {

    @Test
    public void test01verificarVidaArmaDeAsedioCreada() {

        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        assertEquals(unAsedio.getVida(), 150);
    }
}