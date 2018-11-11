package Models.edificios;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlazaCentralTest {

    @Test
    public void Test01VerificarVidaPlazaCentralCreada() {

        PlazaCentral unaPlaza = new PlazaCentral();
        assertEquals(unaPlaza.getVida(), 450);
    }
}
