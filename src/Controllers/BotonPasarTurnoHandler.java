package Controllers;

import Models.Partida.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPasarTurnoHandler implements EventHandler<ActionEvent> {


    private Partida partida;

    public BotonPasarTurnoHandler(Partida partida) {
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent event) {
        this.partida.terminarTurno();

    }
}
