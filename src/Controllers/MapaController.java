package Controllers;

import Models.Posicionable;
import Models.edificios.PlazaCentral;
import Models.edificios.Castillo;
import Models.edificios.Edificio;
import Models.edificios.Cuartel;
import Models.escenario.*;
import Models.unidades.*;
import javafx.geometry.Pos;

import java.util.ArrayList;
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

    public void crearAsedioEn(Castillo unCastillo, int oroJugador) throws LugarOcupadoError{
        Coordenada posCastillo = elementos.get(unCastillo);
        Coordenada posAsedio =  new Coordenada(posCastillo.getFila()+unCastillo.getAncho()+1,
                                               posCastillo.getColumna()+unCastillo.getAlto()+1);
        if (!campo.posicionVacia(posAsedio)){
            throw new LugarOcupadoError();
        }
        ArmaDeAsedio nuevaArma = unCastillo.crearArmaDeAsedio(oroJugador);
        this.colocar(nuevaArma,posAsedio.getFila(),posAsedio.getColumna());
    }

    public void crearAldeanoEn(PlazaCentral unaPlaza, int oroJugador) throws LugarOcupadoError{
        Coordenada posPlaza = elementos.get(unaPlaza);
        Coordenada posAldeano =  new Coordenada(posPlaza.getFila()+unaPlaza.getAncho()+1,
                                                posPlaza.getColumna()+unaPlaza.getAlto()+1);

        if (!campo.posicionVacia(posAldeano)){
            throw new LugarOcupadoError();
        }

        Aldeano nuevoAldeano = unaPlaza.crearAldeano(oroJugador);
        this.colocar(nuevoAldeano,posAldeano.getFila(),posAldeano.getColumna());
    }

    public void crearArqueroEn(Cuartel unCuartel, int oroJugador) throws LugarOcupadoError{
        Coordenada posCuartel = elementos.get(unCuartel);
        Coordenada posArquero =  new Coordenada(posCuartel.getFila()+unCuartel.getAncho()+1,
                                                posCuartel.getColumna()+unCuartel.getAlto()+1);
        if (!campo.posicionVacia(posArquero)){
            throw new LugarOcupadoError();
        }

        Arquero nuevoArquero = unCuartel.crearArquero(oroJugador);
        this.colocar(nuevoArquero,posArquero.getFila(),posArquero.getColumna());
    }

    public void crearEspadachinEn(Cuartel unCuartel, int oroJugador) throws LugarOcupadoError{
        Coordenada posCuartel = elementos.get(unCuartel);
        Coordenada posEspadachin =  new Coordenada(posCuartel.getFila()+unCuartel.getAncho()+1,
                posCuartel.getColumna()+unCuartel.getAlto()+1);
        if (!campo.posicionVacia(posEspadachin)){
            throw new LugarOcupadoError();
        }

        Espadachin nuevoEspadachin = unCuartel.crearEspadachin(oroJugador);
        this.colocar(nuevoEspadachin,posEspadachin.getFila(),posEspadachin.getColumna());
    }

    public ArrayList <Posicionable> obtenerAledaneaos(Posicionable unElemento){
        ArrayList <Posicionable> lista = new ArrayList<Posicionable>();
        Coordenada poscElemento = elementos.get(unElemento);
        for(int i=0; i<campo.getFilas();i++){
            for (int j=0; j<campo.getColumnas();j++){
                try{
                    Coordenada tmp = new Coordenada(i,j);
                    int distancia = poscElemento.distanciaHasta(tmp);
                    if(unElemento.dentroRadioDeAtaque(distancia)){
                        Posicionable posicionable = campo.obtener(tmp);
                        lista.add(posicionable);
                    }
                }catch (PosicionFueraDeCampoError | LugarVacioError)
            }
        }
        return lista;
    }

}
