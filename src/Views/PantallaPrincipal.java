package Views;

import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;

import Controllers.*;
import Views.layouts.*;

import Models.Posicionable;
import Models.Partida.Partida;
import Models.escenario.Coordenada;
import Models.unidades.Aldeano;
import Models.edificios.Castillo;
import Models.edificios.PlazaCentral;

import java.awt.*;
import java.util.regex.Pattern;

public class PantallaPrincipal extends StackPane{

    private Stage ventana;
    private BotonCasillero[] casilleros;
    private Partida partida;
    private BotonCasillero casilleroActual;

    public PantallaPrincipal(Stage ventana, Partida partida) {

        this.ventana = ventana;
        this.partida = partida;
        this.dibujarCampo();
        this.cargarBotonera();
     //   this.cargarCampo();
    }

    public void setActual(BotonCasillero unCasillero){
        this.casilleroActual = unCasillero;
    }

    public BotonCasillero getActual(){
        return this.casilleroActual;
    }


    private void cargarBotonera() {

        Button botonPasarTurno = new Button("Pasar turno");
        botonPasarTurno.setOnAction(new BotonPasarTurnoHandler(partida, this));
        getChildren().add(botonPasarTurno);
        botonPasarTurno.setTranslateX(300);
        botonPasarTurno.getStyleClass().add("botonInicio");

        Button botonMovimientoDerecha = new Button(" -> ");
        botonMovimientoDerecha.setOnAction(new BotonMovimientoDerechaHandler(partida, this));
        getChildren().add(botonMovimientoDerecha);
        botonMovimientoDerecha.setTranslateX(300);
        botonMovimientoDerecha.setTranslateY(200);
        botonMovimientoDerecha.getStyleClass().add("botonInicio");

    }

    public void dibujarCampo(){

        int filas = 25;
        int columnas = 25;
        int indice;
        this.casilleros = new BotonCasillero[filas*columnas];
        System.out.println("El nombre es " +  partida.getActual().getNombre());//para probar ingreso
        for (int i = 0; i<filas;i++){
            for (int j = 0; j<columnas;j++){

                Coordenada posicion = new Coordenada(i,j);
                Posicionable entidad = this.partida.obtenerElementoEn(posicion);
                indice = posicion.obtenerNumero();

                BotonCasillero actual = casilleros[indice];
                actual = new BotonCasillero(posicion, entidad);
                actual.setOnAction(new BotonCasilleroHandler(actual, this.partida, this));

                actual.aplicarEstilo();
                actual.setTranslateX((j*25)+1-450);
                actual.setTranslateY((i*25)+1-300);
                actual.setMaxSize(25,25);
                getChildren().add(actual);
                this.setStyle("-fx-background-color: antiquewhite");
            }
        }
    }

    public void actualizarCampo(){

        for(int i = 0; i  < 25*25 ; i++){
            casilleros[i].aplicarEstilo();
        }
    }





}
