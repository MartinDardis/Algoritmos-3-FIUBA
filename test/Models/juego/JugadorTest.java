package Models.juego;

import Controllers.NoExisteElementoError;
import Models.edificios.Errores.OroInsuficienteError;
import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {

    @Test
    public void Test01JugadorCreadoTiene100DeOroInicial(){
        Jugador unJugador = new Jugador("unNombre");

        assertEquals(unJugador.getOro(),100);

    }

    @Test
    public void Test02AgregarOroAUnJugadorActualizaSuCantidad(){
        Jugador unJugador = new Jugador("unNombre");

        unJugador.sumarOro(100);

        assertEquals(unJugador.getOro(),200);//100 agregados + 100 iniciales
    }



    @Test
    public void Test03AumentarLaPoblacionActualizaLaCantidad(){
        Jugador unJugador  = new Jugador("unNombre");
        int poblacionInicial = unJugador.getPoblacionActual();

        unJugador.incrementarPoblacion();

        assertEquals(unJugador.getPoblacionActual(),poblacionInicial+1);
    }

    @Test(expected = PoblacionMaximaError.class)
    public void Test04AumentarLaPoblacionSobreElLmiteLanzaError(){
        Jugador unJugador = new Jugador("unNombre");
        for (int i = 0; i<=50;i++){
            unJugador.incrementarPoblacion();//seteo la poblacion en 50, evito agregar un setter a la clase
        }
        unJugador.incrementarPoblacion();//Miembro 51 de la poblacion lanza error

    }

    @Test(expected = NoHayPoblacionError.class)
    public void Test05DiminuirPoblacionEnCeroLanzaError(){
        Jugador unJugador = new Jugador("unNombre");

        unJugador.disminuirPoblacion();
    }

    @Test
    public void Test06CobrarOroRestaLaCantidadIndicada(){
        Jugador unJugador = new Jugador("unNombre");
        int oroInicial = unJugador.getOro();
        int costo = 50;

        unJugador.cobrar(costo);

        assertEquals(unJugador.getOro(),oroInicial-costo);

    }
    @Test(expected = OroInsuficienteError.class)
    public void Test07CobrarPrecioMayorAReservaActualDevuelveError(){
        Jugador unJugador = new Jugador("unNombre");
        int oroInicial = unJugador.getOro();

        unJugador.cobrar(oroInicial+1);

    }
}