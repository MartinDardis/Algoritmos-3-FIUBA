package Models.edificios;

import org.junit.Test;

import static org.junit.Assert.*;

public class CuartelTest {

    @Test
    public void Test01VerificarVidaCuartelCreado() {

        Cuartel unCuartel = new Cuartel();
        assertEquals(unCuartel.getVida(), 250);
    }

    @Test (expected = OroInsuficienteError.class)
    public void Test02CrearArqueroConOroInsuficienteLanzaExcepcion(){
        Cuartel unCuartel = new Cuartel();
        unCuartel.crearArquero(10);
    }
    @Test (expected = OroInsuficienteError.class)
    public void Test03CrearEspadachinConOroInsuficienteLanzaExcepcion(){
        Cuartel unCuartel = new Cuartel();
        unCuartel.crearEspadachin(10);
    }
}