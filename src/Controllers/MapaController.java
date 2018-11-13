package Controllers;

import Models.Posicionable;
import Models.edificios.Edificio;
import Models.escenario.Coordenada;
import Models.escenario.Mapa;
import Models.unidades.Unidad;
import javafx.geometry.Pos;

import java.util.HashMap;


public class MapaController {
    private HashMap <Posicionable,Coordenada> unidades;
    private HashMap <Posicionable,Coordenada> edificios;
    private Mapa campo;

    public MapaController(){
        unidades = new HashMap();
        edificios = new HashMap();
        campo = new Mapa();
    }

    public void colocar(Posicionable elemento, int fila, int columna){
        Coordenada posc = new Coordenada(fila,columna);
        if(elemento instanceof Unidad){
            campo.colocar(elemento,posc);
            unidades.put(elemento,posc);
        }else{
            for(int i=0; i < elemento.getAlto(); i++){
                for(int j=0; j < elemento.getAncho();j++){
                    Coordenada aux = new Coordenada(i+fila,j+columna);
                    campo.colocar(elemento,aux);
                }
            }
            edificios.put(elemento,posc);
        }
    }

    public void remover(Posicionable elemento){
        if(elemento instanceof Unidad){
            if(unidades.containsKey(elemento)){
                campo.remover(unidades.get(elemento));
            }
        }else{
            if(edificios.containsKey(elemento)){
                for(int i=0; i < elemento.getAlto(); i++){
                    for(int j=0; j < elemento.getAncho();j++){
                        Coordenada aux = new Coordenada(i,j);//Creo una coord aux con el i,j
                        aux.sumarCoordenda(edificios.get(elemento));//Le sumo la posc inicial del edificio
                        campo.remover(aux);
                    }
                }
            }
        }
    }

    public void mover(Posicionable elemento,int nuevaFila,int nuevaColumna){
        if(elemento instanceof Unidad){
            Coordenada nuevaPosc = new Coordenada(nuevaFila,nuevaColumna);
            Coordenada viejaPosc = unidades.get(elemento);
            campo.mover(viejaPosc,nuevaPosc);
        }
    }
    
}
