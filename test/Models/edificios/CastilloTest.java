package Models.edificios;

import org.junit.Test;

import static org.junit.Assert.*;

public class CastilloTest {

    @Test
    public void Test01VerificarVidaCastilloCreado(){
        Castillo unCastillo = new Castillo();
        assertEquals(unCastillo.getVida(),1000);
    }

    @Test (expected = OroInsuficienteError.class)
    public void Test02CrearArmaAsedioConOroInsuficienteLanzaExcepcion(){
        Castillo unCastillo = new Castillo();
        unCastillo.crearArmaDeAsedio(10);
    }

}