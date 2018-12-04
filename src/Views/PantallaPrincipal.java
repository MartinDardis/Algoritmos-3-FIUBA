package Views;

import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

                Coordenada coordenada = new Coordenada(i,j);
                indice = coordenada.obtenerNumero();

                BotonCasillero actual = casilleros[indice];
                actual = new BotonCasillero(coordenada);
                actual.setOnAction(new BotonCasilleroHandler(actual));

                Coordenada origen = actual.obtenerPosicion();
                Posicionable entidad = this.partida.obtenerElementoEn(origen);

                if(entidad instanceof Aldeano) {
                    actual.setStyle("-fx-background-color: #20B2AA; -fx-border-color: #000000;");
                    actual.setTextAlignment(TextAlignment.CENTER);
                    actual.setText("A");

                }
                else if(entidad instanceof Castillo) {
                    actual.setStyle("-fx-background-color: #808080; -fx-border-color: #000000;");
                    actual.setTextAlignment(TextAlignment.CENTER);
                    actual.setText("C");

                }
                else if(entidad instanceof PlazaCentral) {
                    actual.setStyle("-fx-background-color: #FFDEAD; -fx-border-color: #000000;");
                    actual.setTextAlignment(TextAlignment.CENTER);
                    actual.setText("P");
                }
                else {
                    actual.setStyle("-fx-background-color: #008000; -fx-border-color: #000000;");
                }
                actual.setTranslateX((j*40)+1-480);
                actual.setTranslateY((i*40)+1-480);
                actual.setMaxSize(40,40);

                getChildren().add(actual);
            }
        }
    }





}
