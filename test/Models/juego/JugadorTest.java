package Models.juego;

import Models.edificios.Errores.OroInsuficienteError;
import Models.edificios.PlazaCentral;
import Models.escenario.Mapa;
import Models.juego.errores.NoHayPoblacionError;
import Models.juego.errores.PoblacionMaximaError;
import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {

    @Test
    public void Test01JugadorCreadoTiene100DeOroInicial(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Nombre", unMapa);

        assertEquals(unJugador.getOro(),100);

    }

    @Test
    public void Test02AgregarOroAUnJugadorActualizaSuCantidad(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Nombre", unMapa);

        unJugador.sumarOro(100);

        assertEquals(unJugador.getOro(),200);//100 agregados + 100 iniciales
    }


    @Test
    public void Test03AumentarLaPoblacionActualizaLaCantidad(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Nombre", unMapa);
        int poblacionInicial = unJugador.getPoblacionActual();

        unJugador.incrementarPoblacion();

        assertEquals(unJugador.getPoblacionActual(),poblacionInicial+1);
    }

    @Test(expected = PoblacionMaximaError.class)
    public void Test04AumentarLaPoblacionSobreElLmiteLanzaError(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Nombre", unMapa);
        for (int i = 0; i<=50;i++){
            unJugador.incrementarPoblacion();//seteo la poblacion en 50, evito agregar un setter a la clase
        }
        unJugador.incrementarPoblacion();//Miembro 51 de la poblacion lanza error

    }

    @Test(expected = NoHayPoblacionError.class)
    public void Test05DiminuirPoblacionEnCeroLanzaError(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Nombre", unMapa);

        unJugador.disminuirPoblacion();
    }

    @Test
    public void Test06CobrarOroRestaLaCantidadIndicada(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Nombre", unMapa);
        int oroInicial = unJugador.getOro();
        int costo = 50;

        unJugador.pagar(costo);

        assertEquals(unJugador.getOro(),oroInicial-costo);

    }

    @Test(expected = OroInsuficienteError.class)
    public void Test07CobrarPrecioMayorAReservaActualDevuelveError(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Nombre", unMapa);
        int oroInicial = unJugador.getOro();

        unJugador.pagar(oroInicial+1);

    }
    @Test
    public void Test08JugadorConoceASuSiguiente(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Pablito", unMapa);
        Jugador otroJugador = new Jugador("Clavito", unMapa, unJugador);

        assertEquals(unJugador, otroJugador.getSiguiente());
    }
    @Test
    public void Test09ElSiguienteDelSiguienteEsSiMismo(){

        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("Pablito", unMapa);
        Jugador otroJugador = new Jugador("Clavito", unMapa, unJugador);
        unJugador.setSiguiente(otroJugador);

        assertEquals(unJugador, unJugador.getSiguiente().getSiguiente());
    }
    @Test
    public void Test10CrearAldeanoAumentaLaPoblacion(){
        Mapa unMapa = new Mapa();
        Jugador unJugador = new Jugador("nombre", unMapa);
        PlazaCentral plaza = new PlazaCentral();
        int poblacionInicial = unJugador.getPoblacionActual();

        unJugador.crearAldeano(plaza);
        int poblacionFinal = unJugador.getPoblacionActual();

        assertEquals(poblacionFinal,poblacionInicial+1);
    }

}