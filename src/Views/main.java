package Views;

import javafx.application.Application;
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

//import java.awt.*;

public class main extends Application {

    public void start(Stage ventana){
        ventana.setTitle("AlgoEmpire");
        StackPane root = new StackPane();
        Scene scene = new Scene(root,800,600);
        Image fondo = new Image("https://i.blogs.es/ad63cd/190218-xataka-age/800_600.jpg");
        ImageView fnd = new ImageView(fondo);
        root.getChildren().add(fnd);
        Button boton = new Button();
        boton.setText("Iniciar Partida");
        boton.setPadding(new Insets(25));
        root.getChildren().add(boton);
        ventana.setScene(scene);
        ventana.show();
    }

    public static void main(){
        launch();
    }
}
