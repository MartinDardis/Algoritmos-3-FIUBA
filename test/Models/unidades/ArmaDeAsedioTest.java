package Models.unidades;

import Models.escenario.Casillero;
import Models.escenario.Coordenada;
import Models.unidades.errores.*;
import Models.unidades.errores.ArmaDesmontadaNoPuedeAtacarError;
import Models.unidades.estadosUnidad.EstadoMontada;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArmaDeAsedioTest {

    @Test
    public void test01verificarVidaArmaDeAsedioCreada() {

        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        assertEquals(unAsedio.getVida(), 150);
    }

    @Test(expected = ArmaMontadaNoPuedeMoverseError.class)
    public void test02MoverArmaMontadaLanzaError(){
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        unAsedio.montar();
        unAsedio.restaurarEstados();
        Coordenada posDestino = new Coordenada(5,5);
        Casillero destino = new Casillero(posDestino);
        unAsedio.mover(destino);
    }


    @Test(expected = ArmaDesmontadaNoPuedeAtacarError.class)
    public void test03AtacarConArmaDesmontadaLanzaError(){
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Aldeano unAldeano = new Aldeano();
        Casillero posArma = new Casillero(new Coordenada(1,1));
        Casillero posAldeano = new Casillero(new Coordenada(2,2));
        unAldeano.setCasillero(posAldeano);
        unAsedio.setCasillero(posArma);
        int distancia = posAldeano.distanciaHasta(posArma);
        unAsedio.atacar(unAldeano);
    }

    @Test
    public void test04AtacarUnidadConAsedioNoCausaDanio(){
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Aldeano unAldeano = new Aldeano();
        Casillero posArma = new Casillero(new Coordenada(1,1));
        Casillero posAldeano = new Casillero(new Coordenada(2,2));
        unAldeano.setCasillero(posAldeano);
        unAsedio.setCasillero(posArma);
        int vidaInicial = unAldeano.getVida();

        unAsedio.estadoAccion = new EstadoMontada();
        unAsedio.atacar(unAldeano);
        int vidaFinal = unAldeano.getVida();

        assertEquals(vidaFinal , vidaInicial);


    }

    @Test(expected = ArmaEnTransicionError.class)
    public void test05AtacarMientrasSeMontaLanzaError(){
        ArmaDeAsedio unAsedio = new ArmaDeAsedio();
        Aldeano unAldeano = new Aldeano();
        Casillero posArma = new Casillero(new Coordenada(1,1));
        Casillero posAldeano = new Casillero(new Coordenada(2,2));
        unAldeano.setCasillero(posAldeano);
        unAsedio.setCasillero(posArma);

        unAsedio.montar();
        unAsedio.atacar(unAldeano);
    }

}