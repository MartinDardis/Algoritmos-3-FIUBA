package Controllers;

import Models.Posicionable;
import Models.edificios.Edificio;
import Models.escenario.Coordenada;
import Models.escenario.Mapa;
import Models.unidades.Unidad;

import java.util.Dictionary;

public class MapaController {
    private Dictionary <Unidad> unidades;
    private Dictionary <Edificio> edificios;
    private Mapa campo;

    public MapaController(){
        unidades = new Dictionary;
        edificios = new Dictionary();
        campo = new Mapa;
    }

    public void colocar(Posicionable elemento, int fila, int columna){
        Coordenada posc = new Coordenada(fila,columna);
        if(elemento instanceof Unidad){
            unidades.put(posc,elemento);
            campo.colocar(elemento,posc);
        }else{
            edificios.put(posc,elemento);
            for(int i=0; i < elemento.getAlto; i++){
                for(int j=0; j < elemento.getAncho;j++){
                    Coordenada aux = new Coordenada(i,j);
                    campo.colocar(elemento,aux);
                }
            }
        }
    }



    
}
