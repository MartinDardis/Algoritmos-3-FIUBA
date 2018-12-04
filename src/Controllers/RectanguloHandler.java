package Controllers;

import Views.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.util.Random;
import javafx.scene.shape.Rectangle;


public class RectanguloHandler implements EventHandler<MouseEvent> {

    private Rectangle rectangulo;

    public RectanguloHandler(Rectangle unRectangulo){
        this.rectangulo = unRectangulo;
    }

    @Override
    public void handle(MouseEvent e){
        int random1 = (int) (Math.random() * 255) + 1;
        int random2 = (int) (Math.random() * 255) + 1;
        int random3 = (int) (Math.random() * 255) + 1;

        rectangulo.setFill(Color.rgb(random1, random2, random3));
    }


}
