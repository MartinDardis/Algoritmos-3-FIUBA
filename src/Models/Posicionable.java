package Models;

import Models.escenario.Casillero;

import java.util.ArrayList;

public interface Posicionable {

    int alto = 1;
    int ancho = 1;

    int getAlto();
    int getAncho();
    boolean dentroRadioDeAtaque(int distancia);
    void recibirDanio(int danio);
    int getRangoAtaque();
    int generarOro();
    ArrayList<Casillero> getCasillero();
}
