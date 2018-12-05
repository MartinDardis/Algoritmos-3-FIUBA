package Views.layouts;
import Models.edificios.Castillo;
import Models.edificios.PlazaCentral;
import Models.unidades.Aldeano;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import Models.escenario.Coordenada;
import Models.Posicionable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;

import Models.escenario.Coordenada;

public class BotonCasillero extends Button {

    private Coordenada coordenada;
    private Posicionable entidad;

    public BotonCasillero(Coordenada unaCoordenada, Posicionable unaEntidad){

        this.coordenada = unaCoordenada;
        this.entidad = unaEntidad;

    }

    public Coordenada obtenerPosicion(){
        return this.coordenada;
    }

    public void aplicarEstilo(){

        if(entidad instanceof Aldeano) {
            //Image fondo = new Image("Views/img/aldeanoAgeBorde.jpg");
            //this.setGraphic(new ImageView(fondo));
            this.setPadding(new Insets(-5,-5,-5,-5));
            //this.setStyle("-fx-background-color: #693121; -fx-border-color: #000000;");
            this.setStyle(null);//vacia las propiedades sin problemas
            this.getStyleClass().clear();
            this.getStyleClass().add("aldeano");

        }
        else if(entidad instanceof Castillo) {
            //Image fondo = new Image("Views/img/castillo.jpg");
            //this.setGraphic(new ImageView(fondo));
            this.setPadding(new Insets(-5,-5,-5,-5));
            this.setStyle("-fx-background-color: #234562; -fx-border-color: #000000;");

        }
        else if(entidad instanceof PlazaCentral) {
            this.setStyle("-fx-background-color: #FFDEAD; -fx-border-color: #000000;");
            //this.setTextAlignment(TextAlignment.CENTER);
            //this.setText("P");
        }
        else {
            //Image fondo = new Image("Views/img/pastoBorde.jpg");
            //this.setGraphic(new ImageView(fondo));
            this.setPadding(new Insets(-5,-5,-5,-5));
            this.setStyle("-fx-background-color: #00FF00; -fx-border-color: #000000;");
            //actual.setStyle("-fx-background-color: #008000; -fx-border-color: #000000;");
        }
    }

    public void aplicarEstiloActivo(){
        this.setPadding(new Insets(-5,-5,-5,-5));
        if (entidad instanceof Aldeano){
            this.setStyle(null);
            this.getStyleClass().add("aldeanoSeleccionado");
        }

    }

    public Posicionable Posicionable(){
        return this.entidad;
    }

    public Coordenada coordenadaDerecha(){
        return new Coordenada(this.coordenada.getFila(), this.coordenada.getColumna()+1);
    }


}
