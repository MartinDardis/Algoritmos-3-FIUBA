package Models.escenario;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

public class MapaTest {

    @Test
    public void test01crearMapaYVerificarTamañoDefinido() {

      Mapa unMapa = new Mapa();

      assertEquals(50, unMapa.getColumnas());
      assertEquals(50, unMapa.getFilas());
    }

    @Test
    public void test02CrearMapaYVerificarDireccionDeMemoria(){
        Mapa unMapa = new Mapa();
        assertNotNull(unMapa);
    }
}