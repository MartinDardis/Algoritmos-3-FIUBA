package Views;

import Models.escenario.Coordenada;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Controllers.*;
import Views.layouts.*;
import Models.Posicionable;
import Models.Partida.Partida;

public class PantallaPrincipal extends StackPane{

    private Stage ventana;
    private BotonCasillero[] casilleros;
    private Partida partida;

    public PantallaPrincipal(Stage ventana, Partida partida) {

        this.ventana = ventana;
        this.partida = partida;
        this.dibujarCampo();
        this.cargarCampo();
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
                //Image fondo = new Image("Views/img/pasto.jpg");
                //ImageView fnd = new ImageView(fondo);
                //actual.setGraphic(fnd);
                actual.setStyle("-fx-background-color: #008000; -fx-border-color: #000000;");
                actual.setTranslateX((j*20)+1-220);
                actual.setTranslateY((i*20)+1-250);
                actual.setMaxSize(20,20);

                getChildren().add(actual);
            }
        }
    }

    public void cargarCampo(){
/*
        int filas = 25;
        int columnas = 25;
        BotonCasillero actual;
        Posicionable entidad;

        for(int i = 12; i < filas*columnas; i++){
            System.out.print( i + " ");
            actual = casilleros[i];
            entidad = this.partida.obtenerElementoEn(actual.obtenerPosicion());
        }
*/
    }



}
