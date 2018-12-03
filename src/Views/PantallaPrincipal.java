package Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import Controllers.*;


public class PantallaPrincipal extends StackPane{

    private Stage ventana;

    public PantallaPrincipal(Stage ventana, Color unColor) {

        this.ventana = ventana;
        Rectangle rectangulo = new Rectangle(100, 100, unColor);
        rectangulo.setOnMouseClicked(new RectanguloHandler(ventana));
        getChildren().add(rectangulo);

    }


}
