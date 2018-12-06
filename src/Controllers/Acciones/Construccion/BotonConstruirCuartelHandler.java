package Controllers.Acciones.Construccion;

import Controllers.Acciones.BotonAccionHandler;

import Models.Partida.Partida;
import Models.unidades.Unidad;
import Models.unidades.Aldeano;
import Models.Partida.Partida;
import Models.edificios.PlazaCentral;

import javafx.event.ActionEvent;
import Views.PantallaPrincipal;
import Views.layouts.BotonCasillero;


public class BotonConstruirCuartelHandler extends BotonAccionHandler {

    private Partida partida;

    public BotonConstruirCuartelHandler(Partida partida, PantallaPrincipal screen) {
        this.partida = partida;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent e) {
        Aldeano unAldeano = (Aldeano) screen.getActual().Posicionable();
        this.partida.construirCuartel(unAldeano, screen.getActual().coordenadaDerecha());
    }

}