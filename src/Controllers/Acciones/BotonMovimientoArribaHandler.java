package Controllers.Acciones;

import Models.Partida.Partida;
import javafx.event.ActionEvent;

import Models.unidades.Unidad;
import Views.PantallaPrincipal;
import Views.layouts.BotonCasillero;

public class BotonMovimientoArribaHandler extends BotonAccionHandler {

    private Partida partida;

    public BotonMovimientoArribaHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {

        BotonCasillero actual = screen.getActual();
        partida.moverUnidad((Unidad) actual.Posicionable(), actual.coordenadaArriba());
        screen.dibujarCampo();
        desactivarBotonera();
    }
}

