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
import Models.Partida.Partida;
import Models.Posicionable;

public class BotonInicioHandler implements EventHandler<ActionEvent> {

    private Stage ventana;
    private Partida partida;

    public BotonInicioHandler(Stage ventana, String jugadorUno, String jugadorDos){
        this.ventana = ventana;
        this.partida = new Partida(jugadorUno,jugadorDos);
    }

    @Override
    public void handle(ActionEvent e){
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(this.ventana, this.partida);
        Scene escena = new Scene(pantallaPrincipal,1920,1080);
        escena.getStylesheets().add("Views/estilo.css");
        this.ventana.setScene(escena);
        ventana.setFullScreen(true);

    }

}
