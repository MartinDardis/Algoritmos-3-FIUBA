package Controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import Views.PantallaPrincipal;
import Models.Partida.Partida;
import Models.Posicionable;

import javax.xml.soap.Text;

public class BotonInicioHandler implements EventHandler<ActionEvent> {

    private Stage ventana;
    private Partida partida;
    private TextField ingresoUno;
    private TextField ingresoDos;

    public BotonInicioHandler(Stage ventana, TextField jugadorUno, TextField jugadorDos){
        this.ventana = ventana;
        this.ingresoUno = jugadorUno;
        this.ingresoDos = jugadorDos;

    }

    @Override
    public void handle(ActionEvent e){
        this.partida = new Partida(ingresoUno.getText(),ingresoDos.getText());
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(this.ventana, this.partida);
        Scene escena = new Scene(pantallaPrincipal,1000,680);
        escena.getStylesheets().add("Views/estilo.css");
        this.ventana.setScene(escena);
        //ventana.setFullScreen(true);

    }

}
