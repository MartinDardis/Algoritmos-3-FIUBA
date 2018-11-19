package Models;

public interface Posicionable {

    int alto = 1;
    int ancho = 1;
    int rango = 0;

    int getAlto();
    int getAncho();
    boolean dentroRadioDeAtaque(int distancia);
}
