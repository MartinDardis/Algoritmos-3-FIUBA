package Views;

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

public class PantallaPrincipal extends StackPane{

    private Stage ventana;
    private BotonCasillero[] casilleros;
    private Partida partida;

    public PantallaPrincipal(Stage ventana, Partida partida) {

        this.ventana = ventana;
        this.partida = partida;
        this.dibujarCampo();
     //   this.cargarCampo();
    }

    public void dibujarCampo(){

        int filas = 25;
        int columnas = 25;
        int indice;

        this.casilleros = new BotonCasillero[filas*columnas];

        for (int i = 0; i<filas;i++){
            for (int j = 0; j<columnas;j++){

                Coordenada posicion = new Coordenada(i,j);
                Posicionable entidad = this.partida.obtenerElementoEn(posicion);
                indice = posicion.obtenerNumero();

                BotonCasillero actual = casilleros[indice];
                actual = new BotonCasillero(posicion, entidad);
                actual.setOnAction(new BotonCasilleroHandler(actual, this.partida, this));

                actual.aplicarEstilo();
                actual.setTranslateX((j*40)+1-480);
                actual.setTranslateY((i*40)+1-480);
                actual.setMaxSize(40,40);

                getChildren().add(actual);
            }
        }
    }

    public void actualizarCampo(){

        for(int i = 0; i  < 25*25 ; i++){
            casilleros[i].aplicarEstilo();
        }
    }





}
