package Controllers.Acciones.Movimiento;

import Controllers.Acciones.BotonAccionHandler;
import Models.Partida.Partida;
import Models.unidades.ArmaDeAsedio;
import Views.PantallaPrincipal;
import Views.layouts.BotonCasillero;
import javafx.event.ActionEvent;

public class BotonDesmontarAsedioHandler extends BotonAccionHandler {

    private Partida partida;

    public BotonDesmontarAsedioHandler(Partida partida, PantallaPrincipal pantallaPrincipal) {
        this.partida = partida;
        this.screen = pantallaPrincipal;
    }

    @Override
    public void handle(ActionEvent event) {
        BotonCasillero actual = screen.getActual();
        ArmaDeAsedio asedio = (ArmaDeAsedio) actual.Posicionable();
        asedio.desmontar();
        screen.dibujarCampo();
        this.screen.actualizarCartelesJugador();
        desactivarBotonera();


    }
}
