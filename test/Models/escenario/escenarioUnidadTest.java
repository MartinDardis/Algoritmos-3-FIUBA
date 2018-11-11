package Models.escenario;

import org.junit.Test;

import static org.jUnit.Assert.*;

public class escenarioUnidadTest {

    @Test
    public void test01CrearUnMapa(){
        Mapa map = new Mapa();
        assertNotNull('No se pudo crear el mapa',map);
    }
}
