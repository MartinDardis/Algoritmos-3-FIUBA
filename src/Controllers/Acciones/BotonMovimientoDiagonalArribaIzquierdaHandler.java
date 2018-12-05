package Controllers.Acciones;

import Models.Partida.Partida;
import javafx.event.ActionEvent;

import Models.unidades.Unidad;
import Views.PantallaPrincipal;
import Views.layouts.BotonCasillero;

public class BotonMovimientoDiagonalArribaIzquierdaHandler extends BotonAccionHandler {

    private Partida partida;

    public BotonMovimientoDiagonalArribaIzquierdaHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {

        BotonCasillero actual = screen.getActual();
        partida.moverUnidad((Unidad) actual.Posicionable(), actual.coordenadaDiagonalSuperiorIzquierda());
        screen.dibujarCampo();
        desactivarBotonera();
    }
}