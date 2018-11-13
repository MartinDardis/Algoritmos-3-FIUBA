package Controllers;

import Models.Posicionable;
import Models.escenario.Coordenada;
import Models.escenario.Mapa;
import Models.unidades.*;
import Models.edificios.*;

import org.junit.Test;
import static junit.framework.TestCase.*;


public class MapaControllerTest {
    @Test
    public void test01CrearUnControllerContieneUnMapa(){
        MapaController mp = new MapaController();

        assertNotNull(mp.getCampo());
    }

    @Test
    public void test02ColocarAldeanoEnPosicionValida(){
        MapaController mp = new MapaController();
        Aldeano aldeano = new Aldeano();

        mp.colocar(aldeano,4,4);

        Coordenada posc = mp.getPosicion(aldeano);
        Mapa campo = mp.getCampo();

        assertEquals(aldeano,campo.obtener(posc));

    }



}
