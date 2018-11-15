package Models.escenario;

import Models.Posicionable;


import org.junit.Test;
import static org.junit.Assert.*;

public class CoordenadaTest {

    @Test
    public void test01CrearCoordenadaEnParOrigenYVerificar() {

        Coordenada unaCoordenada = new Coordenada(0,0);

        assertEquals(unaCoordenada.getFila(), 0);
        assertEquals(unaCoordenada.getColumna(), 0);
    }


    @Test
    public void test02CrearCoordenadaDentroDeRangoYVerificar() {

        Coordenada unaCoordenada = new Coordenada(5,5);
        assertTrue(unaCoordenada.estaDentroDe(20,20));
    }

    @Test
    public void test03CrearCoordenadaFueraDeRangoYEsperarFalse() {

        Coordenada unaCoordenada = new Coordenada(20,20);
        assertFalse(unaCoordenada.estaDentroDe(5,5));
    }

    @Test
    public void test04CalcularDistanciaEntreDosCoordenadasIguales() {

        Coordenada unaCoordenada = new Coordenada(20,20);
        Coordenada otraCoordenada = new Coordenada(20,20);

        assertEquals(unaCoordenada.distanciaHasta(otraCoordenada),0);
    }

    @Test
    public void test05CalcularDistanciaHorizontalEntreDosCoordenadas() {

        Coordenada unaCoordenada = new Coordenada(20,20);
        Coordenada otraCoordenada = new Coordenada(21,20);

        assertEquals(unaCoordenada.distanciaHasta(otraCoordenada),1);
    }

    @Test
    public void test06CalcularDistanciaVerticalEntreDosCoordenadas() {

        Coordenada unaCoordenada = new Coordenada(20,20);
        Coordenada otraCoordenada = new Coordenada(20,21);

        assertEquals(unaCoordenada.distanciaHasta(otraCoordenada),1);
    }

    @Test
    public void test07CalcularDistanciaDiagonalEntreDosCoordenadas() {

        Coordenada unaCoordenada = new Coordenada(20,20);
        Coordenada otraCoordenada = new Coordenada(23,23);

        assertEquals(unaCoordenada.distanciaHasta(otraCoordenada),3);
    }

    @Test
    public void test08CalcularDistanciaEnEleEntreDosCoordenadas() {

        Coordenada unaCoordenada = new Coordenada(20,20);
        Coordenada otraCoordenada = new Coordenada(14,18);

        assertEquals(unaCoordenada.distanciaHasta(otraCoordenada),6);
    }




}