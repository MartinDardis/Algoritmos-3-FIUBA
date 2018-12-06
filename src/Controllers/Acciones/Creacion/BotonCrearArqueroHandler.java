package Controllers.Acciones.Creacion;

import Controllers.Acciones.BotonAccionHandler;
import Models.Partida.Partida;
import Models.edificios.Cuartel;
import Models.edificios.PlazaCentral;
import Views.PantallaPrincipal;
import Views.layouts.BotonCasillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearArqueroHandler extends BotonAccionHandler {
    private Partida partida;

    public BotonCrearArqueroHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {

        BotonCasillero actual = screen.getActual();
        partida.crearArquero((Cuartel) actual.Posicionable());
        screen.dibujarCampo();
        this.screen.actualizarCartelesJugador();
        desactivarBotonera();

    }
}
