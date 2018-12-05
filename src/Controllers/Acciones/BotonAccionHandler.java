package Controllers.Acciones;

import Views.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionHandler implements EventHandler<ActionEvent> {

    protected PantallaPrincipal screen;

    public void desactivarBotonera(){
        this.screen.desactivarBotonera();
    }

    @Override
    public void handle(ActionEvent event) {
    }

}
