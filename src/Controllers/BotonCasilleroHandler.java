package Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import Views.layouts.*;
import Views.PantallaPrincipal;

import Models.Partida.Partida;
import Models.unidades.Unidad;

public class BotonCasilleroHandler implements EventHandler<ActionEvent> {

    private BotonCasillero boton;
    private Partida partida;
    private PantallaPrincipal screen;

    public BotonCasilleroHandler(BotonCasillero unBoton, Partida unaPartida, PantallaPrincipal pantalla){
        this.boton = unBoton;
        this.partida = unaPartida;
        this.screen = pantalla;
    }

    @Override
    public void handle(ActionEvent e){
        //this.partida.moverUnidad((Unidad) this.boton.Posicionable(), this.boton.coordenadaDerecha());
        BotonCasillero previo = this.screen.getActual();
        if (previo != null)
            previo.aplicarEstilo();
        this.screen.setActual(this.boton);
        this.boton.aplicarEstiloActivo();
        //screen.dibujarCampo();
       // this.boton.setStyle("-fx-background-color: #ff0000; ");
    }

}
