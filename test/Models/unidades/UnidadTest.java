package Models.unidades;

import Models.escenario.Coordenada;
import Models.escenario.Casillero;
import Models.escenario.errores.*;
import Models.unidades.errores.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;

public class UnidadTest {

    @Test
    public void test01moverUnidadALaDerecha() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(1,0);
        Casillero casilleroOrigen = new Casillero(origen);
        Casillero casilleroDestino = new Casillero(destino);

        Unidad unaUnidad = new Aldeano(casilleroOrigen);
        casilleroOrigen.colocar(unaUnidad);
        unaUnidad.mover(casilleroDestino);

        assertEquals(casilleroDestino.obtenerPosicionable(), unaUnidad);
    }

    @Test
    public void test02moverUnidadEnDiagonal() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(1,1);
        Casillero casilleroOrigen = new Casillero(origen);
        Casillero casilleroDestino = new Casillero(destino);

        Unidad unaUnidad = new Aldeano(casilleroOrigen);
        casilleroOrigen.colocar(unaUnidad);
        unaUnidad.mover(casilleroDestino);

        assertEquals(casilleroDestino.obtenerPosicionable(), unaUnidad);
    }

    @Test (expected = CasilleroAlejadoError.class)
    public void test03moverUnidadTresCasilleros() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(0,3);
        Casillero casilleroOrigen = new Casillero(origen);
        Casillero casilleroDestino = new Casillero(destino);

        Unidad unaUnidad = new Aldeano(casilleroOrigen);
        casilleroOrigen.colocar(unaUnidad);
        unaUnidad.mover(casilleroDestino);

        assertEquals(casilleroDestino.obtenerPosicionable(), unaUnidad);
    }

    @Test (expected = LugarOcupadoError.class)
    public void test04moverUnidadAUnCasilleroOcupado() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(0,1);
        Casillero casilleroOrigen = new Casillero(origen);
        Casillero casilleroDestino = new Casillero(destino);

        Unidad unaUnidad = new Aldeano(casilleroOrigen);
        casilleroOrigen.colocar(unaUnidad);
        Unidad otraUnidad = new Aldeano(casilleroDestino);
        casilleroDestino.colocar(otraUnidad);

        unaUnidad.mover(casilleroDestino);
    }

    @Test
    public void test05moverUnidadDejaElCasilleroVacio() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(0,1);
        Casillero casilleroOrigen = new Casillero(origen);
        Casillero casilleroDestino = new Casillero(destino);

        Unidad unaUnidad = new Aldeano(casilleroOrigen);
        casilleroOrigen.colocar(unaUnidad);

        unaUnidad.mover(casilleroDestino);

        assertFalse(casilleroOrigen.estaOcupado());
    }

    @Test
    public void test06atacarUnidadDisminuyeVidaObjetivo() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(0,1);
        Casillero casillero1 = new Casillero(origen);
        Casillero casillero2 = new Casillero(destino);

        Unidad unaUnidad = new Arquero(casillero1);
        Unidad otraUnidad = new Arquero(casillero2);

        unaUnidad.atacar(otraUnidad);

        assertEquals(otraUnidad.getVida(), 60);
    }

    @Test  (expected = UnidadYaUtilizadaError.class)
    public void test07atacarDosVecesLanzaExcepcion() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(0,1);
        Casillero casillero1 = new Casillero(origen);
        Casillero casillero2 = new Casillero(destino);

        Unidad unaUnidad = new Arquero(casillero1);
        Unidad otraUnidad = new Arquero(casillero2);

        unaUnidad.atacar(otraUnidad);
        unaUnidad.atacar(otraUnidad);

        assertEquals(otraUnidad.getVida(), 60);
    }


    @Test  (expected = CasilleroAlejadoError.class)
    public void test08atacarFueraDelRangoLanzaExcepcion() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(0,4);
        Casillero casillero1 = new Casillero(origen);
        Casillero casillero2 = new Casillero(destino);

        Unidad unaUnidad = new Arquero(casillero1);
        Unidad otraUnidad = new Arquero(casillero2);

        unaUnidad.atacar(otraUnidad);
    }

    @Test
    public void test09EspadachinAtacaArquero() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(0,1);
        Casillero casillero1 = new Casillero(origen);
        Casillero casillero2 = new Casillero(destino);

        Unidad unaUnidad = new Espadachin(casillero1);
        Unidad otraUnidad = new Arquero(casillero2);

        unaUnidad.atacar(otraUnidad);

        assertEquals(otraUnidad.getVida(), 50);
    }

    @Test
    public void test10EspadachinAtacaAldeano() {

        Coordenada origen = new Coordenada(0,0);
        Coordenada destino = new Coordenada(0,1);
        Casillero casillero1 = new Casillero(origen);
        Casillero casillero2 = new Casillero(destino);

        Unidad unaUnidad = new Espadachin(casillero1);
        Unidad otraUnidad = new Aldeano(casillero2);

        unaUnidad.atacar(otraUnidad);

        assertEquals(otraUnidad.getVida(), 25);
    }

}
