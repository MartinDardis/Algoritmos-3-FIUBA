package Controllers.Acciones.Creacion;

import Controllers.Acciones.BotonAccionHandler;

import Models.Partida.Partida;
import Models.unidades.Unidad;
import Models.Partida.Partida;
import Models.edificios.PlazaCentral;

import javafx.event.ActionEvent;
import Views.PantallaPrincipal;
import Views.layouts.BotonCasillero;


public class BotonCrearAldeanoHandler extends BotonAccionHandler {

    private Partida partida;

    public BotonCrearAldeanoHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {

        BotonCasillero actual = screen.getActual();
        partida.crearAldeano((PlazaCentral) actual.Posicionable());
        screen.dibujarCampo();
        this.screen.actualizarCartelesJugador();
        desactivarBotonera();

    }

}
