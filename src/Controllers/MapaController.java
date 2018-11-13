package Controllers;

import Models.Posicionable;
import Models.escenario.Coordenada;
import Models.escenario.LugarOcupadoError;
import Models.escenario.Mapa;
import Models.escenario.PosicionFueraDeCampoError;
import Models.unidades.Unidad;
import javafx.geometry.Pos;

import java.util.HashMap;


public class MapaController {
    private HashMap <Posicionable,Coordenada> elementos;
    private Mapa campo;

    public MapaController(){
        elementos = new HashMap();
        campo = new Mapa();
    }

    public void colocar(Posicionable elemento, int fila, int columna){
        Coordenada posc = new Coordenada(fila,columna);
        for(int i=0; i < elemento.getAlto(); i++){
            for(int j=0; j < elemento.getAncho();j++){
                Coordenada aux = new Coordenada(i+fila,j+columna);
                campo.colocar(elemento,aux);
            }
        }
        elementos.put(elemento,posc);
    }

    public void remover(Posicionable elemento){
        if(elementos.containsKey(elemento)){
            for(int i=0; i < elemento.getAlto(); i++){
                for(int j=0; j < elemento.getAncho();j++){
                    Coordenada aux = new Coordenada(i,j);//Creo una coord aux con el i,j
                    aux.sumarCoordenda(elementos.get(elemento));//Le sumo la posc inicial del edificio
                    campo.remover(aux);
                }
            }
        }
    }

    public void mover(Posicionable elemento,int nuevaFila,int nuevaColumna)throws EdificioNoPuedeMoverseError, NoExisteElementoError{
        if(elemento instanceof Unidad){
            if(!elementos.containsKey(elemento))
                throw new NoExisteElementoError();
            Coordenada nuevaPosc = new Coordenada(nuevaFila,nuevaColumna);
            Coordenada viejaPosc = elementos.get(elemento);
            try{
                campo.mover(viejaPosc,nuevaPosc);
            }catch (LugarOcupadoError | PosicionFueraDeCampoError e){
                throw e;
            }
        }else
            throw new EdificioNoPuedeMoverseError();
    }
    
}
