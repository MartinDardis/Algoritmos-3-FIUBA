package Controllers.Acciones;

import Models.Partida.Partida;
import Views.PantallaPrincipal;
import javafx.event.ActionEvent;

public class BotonPasarTurnoHandler extends BotonAccionHandler {

    private Partida partida;

    public BotonPasarTurnoHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {
        this.partida.terminarTurno();
        System.out.print("Turno finaliazdo");
        this.screen.dibujarCampo();
        desactivarBotonera();
    }
}
