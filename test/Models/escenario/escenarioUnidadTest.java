package Models.escenario;


import org.junit.Test;

import static junit.framework.TestCase.*;

public class escenarioUnidadTest {

    @Test
    public void test01CrearUnMapa(){
        Mapa mp = new Mapa();
        assertNotNull(mp);
    }
}
