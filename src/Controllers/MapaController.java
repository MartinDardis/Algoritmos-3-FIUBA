package Controllers;

import Models.Posicionable;
import Models.edificios.Castillo;
import Models.edificios.Edificio;
import Models.escenario.*;
import Models.unidades.*;

import java.util.HashMap;

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

    public void mover(Posicionable unidad, int nuevaFila, int nuevaColumna) throws SuperaDistanciaMaximaError, EdificioNoPuedeMoverseError, PosicionFueraDeCampoError{
        if (unidad instanceof Edificio){
            throw new EdificioNoPuedeMoverseError();
        }
        Coordenada posActual = elementos.get(unidad);
        Coordenada nuevaPosicion = new Coordenada(nuevaFila,nuevaColumna);
        if (posActual.distanciaHasta(nuevaPosicion) > 1){
            throw new SuperaDistanciaMaximaError();
        }
        else{
            try {
                campo.mover(posActual, nuevaPosicion);
            }catch (LugarOcupadoError | PosicionFueraDeCampoError e){
                throw e;
            }
            elementos.put(unidad,nuevaPosicion);
        }

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

    public void crearAsedioEn(Castillo unCastillo, int oroJugador){
        Coordenada posCastillo = elementos.get(unCastillo);
        Coordenada posAsedio =  new Coordenada(posCastillo.getFila()+unCastillo.getAncho()+1,posCastillo.getColumna()+unCastillo.getAlto()+1);
        if (!campo.posicionVacia(posAsedio)){
            throw new LugarOcupadoError();
        }
        ArmaDeAsedio nuevaArma = unCastillo.crearArmaDeAsedio(oroJugador);
        this.colocar(nuevaArma,posAsedio.getFila(),posAsedio.getColumna());

    }

}
