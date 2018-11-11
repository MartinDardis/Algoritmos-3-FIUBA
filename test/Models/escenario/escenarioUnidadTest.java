package Models.escenario;


import junit.framework.*;
import org.junit.*;

import sun.jvm.hotspot.utilities.Assert;

public class escenarioUnidadTest {

    @Test
    public void test01CrearUnMapa(){
        Mapa mp = new Mapa();
        assertNotNull(mp);
    }
}
