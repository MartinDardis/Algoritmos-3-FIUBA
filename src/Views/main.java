package Views;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.control.*;

import Controllers.*;
import Models.Partida.Partida;


import java.io.File;

import static java.awt.Color.orange;

//import java.awt.*;

public class main extends Application {

    public static MediaPlayer mainMenuMusic;

    public void start(Stage ventana){

        Partida partidaEnCurso = new Partida("Algo","Ritmos");

        ventana.setTitle("AlgoEmpire");

        StackPane root = new StackPane();
        Scene scene = new Scene(root,800,600);
        scene.getStylesheets().add("Views/estilo.css");

        Image fondo = new Image("Views/img/menuAlt.jpg");
        ImageView fnd = new ImageView(fondo);

        //Seteo Boton de Iniciar Juego
        Button botonIniciarJuego = new Button();
        botonIniciarJuego.getStyleClass().add("botonInicio");
        botonIniciarJuego.setText("Iniciar Partida");
        botonIniciarJuego.setTranslateX(-225);
        botonIniciarJuego.setTranslateY(250);
        botonIniciarJuego.setMaxSize(300,50);
        botonIniciarJuego.setPadding(new Insets(25));
        botonIniciarJuego.setOnAction(new BotonInicioHandler(ventana, partidaEnCurso));

        //Seteo Boton de Salir
        Button botonSalir = new Button();
        botonSalir.getStyleClass().add("botonSalir");
        botonSalir.setText("Salir del juego");
        botonSalir.setTranslateX(325);
        botonSalir.setTranslateY(245);
        botonSalir.setMaxSize(120,50);
        botonSalir.setOnAction(e -> Platform.exit());

        //Seteo Sonido
        File musicaPrincipal = new File("src/Views/sonido/musicaMenuPrincipal.mp3");
        Media musicaFondo = new Media(musicaPrincipal.toURI().toString());
        mainMenuMusic = new MediaPlayer(musicaFondo);
        mainMenuMusic.setAutoPlay(true);
        mainMenuMusic.setVolume(0.5);
        mainMenuMusic.setCycleCount(mainMenuMusic.INDEFINITE);
        mainMenuMusic.play();

        root.getChildren().addAll(fnd, botonIniciarJuego, botonSalir);

        ventana.setScene(scene);
        ventana.show();

    }

    public static void main(){
        launch();
    }
}
