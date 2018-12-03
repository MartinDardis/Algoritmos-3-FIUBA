package Controllers;

import Views.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.Random;


public class RectanguloHandler implements EventHandler<MouseEvent> {

    private Stage ventana;

    public RectanguloHandler(Stage ventana){
        this.ventana = ventana;
    }

    @Override
    public void handle(MouseEvent e){
        int random1 = (int) (Math.random() * 255) + 1;
        int random2 = (int) (Math.random() * 255) + 1;
        int random3 = (int) (Math.random() * 255) + 1;
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(ventana, Color.rgb(random1, random2, random3));
        this.ventana.setScene(new Scene(pantallaPrincipal,800,600));
    }

}
