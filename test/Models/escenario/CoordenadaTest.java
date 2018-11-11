package Models.escenario;

import static org.junit.Assert.*;

public class CoordenadaTest {

    @org.junit.Test
    public void test01CrearCoordenadaEnParOrigenYVerificar() {

        Coordenada unaCoordenada = new Coordenada(0,0);

        assertEquals(unaCoordenada.getFila(), 0);
        assertEquals(unaCoordenada.getColumna(), 0);
    }


    @org.junit.Test
    public void test02CrearCoordenadaDentroDeRangoYVerificar() {

        Coordenada unaCoordenada = new Coordenada(5,5);
        assertTrue(unaCoordenada.estaDentroDe(20,20));
    }

    @org.junit.Test
    public void test03CrearCoordenadaFueraDeRangoYEsperarFalse() {

        Coordenada unaCoordenada = new Coordenada(20,20);
        assertFalse(unaCoordenada.estaDentroDe(5,5));
    }


}