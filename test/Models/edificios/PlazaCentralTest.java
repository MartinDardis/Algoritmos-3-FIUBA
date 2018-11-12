package Models.edificios;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlazaCentralTest {

    @Test
    public void Test01VerificarVidaPlazaCentralCreada() {

        PlazaCentral unaPlaza = new PlazaCentral();
        assertEquals(unaPlaza.getVida(), 450);
    }
    @Test (expected = OroInsuficienteError.class)
    public void Test02CrearAldeanoConOroInsuficiente(){

        PlazaCentral unaPlaza = new PlazaCentral();
        unaPlaza.crearAldeano(5);


    }
}
