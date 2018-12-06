package Controllers.Acciones.Movimiento;

import Controllers.Acciones.BotonAccionHandler;
import Models.Partida.Partida;
import javafx.event.ActionEvent;

import Models.unidades.Unidad;
import Views.PantallaPrincipal;
import Views.layouts.BotonCasillero;

public class BotonMovimientoDiagonalAbajoDerechaHandler extends BotonAccionHandler {

    private Partida partida;

    public BotonMovimientoDiagonalAbajoDerechaHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {

        BotonCasillero actual = screen.getActual();
        partida.moverUnidad((Unidad) actual.Posicionable(), actual.coordenadaDiagonalInferiorDerecha());
        screen.dibujarCampo();
        desactivarBotonera();
    }
}
