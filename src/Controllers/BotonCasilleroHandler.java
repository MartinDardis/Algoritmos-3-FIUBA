package Controllers;

import Views.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Views.layouts.*;

public class BotonCasilleroHandler implements EventHandler<ActionEvent> {

    private BotonCasillero boton;

    public BotonCasilleroHandler(BotonCasillero unBoton){
        this.boton = unBoton;
    }

    @Override
    public void handle(ActionEvent e){

        this.boton.setStyle("-fx-background-color: #ff0000; ");
    }

}
