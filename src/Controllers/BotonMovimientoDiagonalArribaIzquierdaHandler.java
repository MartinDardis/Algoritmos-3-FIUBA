package Controllers;

import Models.Partida.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import Models.Posicionable;
import Models.unidades.Unidad;
import Models.Partida.Partida;
import Views.PantallaPrincipal;
import Views.layouts.BotonCasillero;

public class BotonMovimientoDiagonalArribaIzquierdaHandler implements EventHandler<ActionEvent> {

    private Partida partida;
    private PantallaPrincipal screen;

    public BotonMovimientoDiagonalArribaIzquierdaHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {

        BotonCasillero actual = screen.getActual();
        partida.moverUnidad((Unidad) actual.Posicionable(), actual.coordenadaDiagonalSuperiorIzquierda());
        screen.dibujarCampo();
    }
}