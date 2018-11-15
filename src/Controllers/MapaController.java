package Controllers;

import Models.Posicionable;
import Models.escenario.*;
import Models.unidades.*;
import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.Map;

public class MapaController {
    private HashMap <Posicionable,Coordenada> elementos;
    private Mapa campo;

    public MapaController(){
        elementos = new HashMap();
        campo = new Mapa();
    }

    public Mapa getCampo(){
        return campo;
    }

    public Coordenada getPosicion(Posicionable elemento){
        return elementos.get(elemento);
    }

    public void colocar(Posicionable elemento, int fila, int columna)throws PosicionFueraDeCampoError,LugarOcupadoError{
        Coordenada posc = new Coordenada(fila,columna);
       for(int i=0; i < elemento.getAlto(); i++){
            for(int j=0; j < elemento.getAncho();j++){
                Coordenada aux = new Coordenada(i+fila,j+columna);
                try{
                    campo.colocar(elemento,aux);
                }catch(PosicionFueraDeCampoError | LugarOcupadoError e){
                    throw e;
                }
            }
        }

        elementos.put(elemento,posc);
    }

    public void remover(Posicionable elemento)throws NoExisteElementoError{
        if(elementos.containsKey(elemento)){
            for(int i=0; i < elemento.getAlto(); i++){
                for(int j=0; j < elemento.getAncho();j++){
                    Coordenada aux = new Coordenada(i,j);//Creo una coord aux con el i,j
                    aux.sumarCoordenda(elementos.get(elemento));//Le sumo la posc inicial del edificio
                    campo.remover(aux);
                }
            }
        }else{
            throw new NoExisteElementoError();
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

    public void restaurarAldeanos() {

        for (HashMap.Entry<Posicionable, Coordenada> unElemento : elementos.entrySet()) {
            Posicionable unPosicionable = unElemento.getKey();
            if (unPosicionable instanceof Aldeano) {
                Estado nuevoEstado = new EstadoInactivo();
                ((Aldeano) unPosicionable).setEstado(nuevoEstado);
            }
        }
    }

    public int recolectarOro(){

        int acumulado = 0;

        for (HashMap.Entry<Posicionable, Coordenada> unElemento : elementos.entrySet()) {
            Posicionable unPosicionable = unElemento.getKey();
            if (unPosicionable instanceof Aldeano) {
               acumulado += ((Aldeano) unPosicionable).generarOro();
            }
        }

        return acumulado;
    }

}
