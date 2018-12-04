package Views.layouts;
import javafx.scene.control.Button;
import Models.escenario.Coordenada;

public class BotonCasillero extends Button {

    private Coordenada coordenada;

    public BotonCasillero(Coordenada unaCoordenada){
        this.coordenada = unaCoordenada;
    }

    public Coordenada obtenerPosicion(){
        return this.coordenada;
    }

}
