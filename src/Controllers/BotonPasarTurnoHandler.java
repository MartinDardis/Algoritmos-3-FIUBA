package Controllers;

import Models.Partida.Partida;
import Views.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPasarTurnoHandler implements EventHandler<ActionEvent> {

    private Partida partida;
    private PantallaPrincipal screen;

    public BotonPasarTurnoHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {
        this.partida.terminarTurno();
        System.out.print("Turno finaliazdo");
        this.screen.dibujarCampo();
    }
}
