package Controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import Views.PantallaPrincipal;

public class BotonInicioHandler implements EventHandler<ActionEvent> {

    private Stage ventana;

    public BotonInicioHandler(Stage ventana){
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent e){

        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(this.ventana, Color.AQUA);
        this.ventana.setScene(new Scene(pantallaPrincipal,800,600));

    }

}
