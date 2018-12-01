package Models.unidades;

import Models.edificios.*;
import Models.edificios.Estados.*;
import Models.edificios.Errores.*;
import Models.unidades.errores.*;
import Models.unidades.estadosAldeano.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AldeanoTest {

    @Test
    public void Test01verificarVidaAldeanoCreado() {

        Aldeano unAldeano = new Aldeano();
        assertEquals(unAldeano.getVida(), 50);
    }


    @Test
    public void Test02repararDejaEnEstadoConstructor() {

        Aldeano unAldeano = new Aldeano();
        Cuartel unCuartel = new Cuartel();

        unCuartel.setEstadoReparacion(new EstadoDaniado(150));
        unAldeano.reparar(unCuartel);

        EstadoAldeano estadoActual = unAldeano.getEstado();

        assertTrue(estadoActual instanceof EstadoConstructor);
    }

    @Test
    public void Test03reparandoNoGeneraOro() {

        Aldeano unAldeano = new Aldeano();
        Cuartel unCuartel = new Cuartel();

        unCuartel.setEstadoReparacion(new EstadoDaniado(150));
        unAldeano.reparar(unCuartel);

        int oroGenerado = unAldeano.generarOro();

        assertEquals(oroGenerado, 0);
    }

    @Test (expected = EdificioVidaCompletaError.class)
    public void Test04NoPuedeRepararVidaCompleta() {

        Aldeano unAldeano = new Aldeano();
        Cuartel unCuartel = new Cuartel();

        unAldeano.reparar(unCuartel);

    }






}