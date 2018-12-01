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
import javafx.stage.Stage;

import javafx.scene.control.*;

import static java.awt.Color.orange;

//import java.awt.*;

public class main extends Application {


    public void start(Stage ventana){
        ventana.setTitle("AlgoEmpire");
        StackPane root = new StackPane();
        Scene scene = new Scene(root,800,600);
        scene.getStylesheets().add("Views/estilo.css");
        Image fondo = new Image("Views/img/mainMenu.jpg");
        ImageView fnd = new ImageView(fondo);
        root.getChildren().add(fnd);
        Button botonIniciarJuego = new Button();
        botonIniciarJuego.getStyleClass().add("botonInicio");
        Button botonSalir = new Button();
        botonSalir.getStyleClass().add("botonSalir");



        botonIniciarJuego.setTranslateX(-225);
        botonIniciarJuego.setTranslateY(250);
        botonSalir.setTranslateX(325);
        botonSalir.setTranslateY(250);
        botonSalir.setMaxSize(120,50);
        botonIniciarJuego.setMaxSize(300,50);
        botonIniciarJuego.setText("Iniciar Partida");
        botonSalir.setText("Salir del juego");
        botonSalir.setOnAction(e -> Platform.exit());
        botonIniciarJuego.setPadding(new Insets(25));
        root.getChildren().add(botonIniciarJuego);
        root.getChildren().add(botonSalir);
        ventana.setScene(scene);
        ventana.show();
    }

    public static void main(){
        launch();
    }
}
