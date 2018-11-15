package Models.escenario;

import java.lang.Math;

public class Coordenada {
    private int fila;
    private int columna;

    public Coordenada(int fila,int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public boolean estaDentroDe(int filas,int columnas){
        if(fila > filas || columna > columnas){
            return false;
        }
        return true;
    }

    public int getFila(){
        return this.fila;
    }

    public int getColumna(){
        return this.columna;
    }

    public void sumarCoordenda(Coordenada a){
        this.fila += a.getFila();
        this.columna += a.getColumna();
    }

    public String asKey(){
        String sfila = String.valueOf(this.fila);
        String scolumna = String.valueOf(this.columna);
        return sfila+scolumna;
    }

    public int distanciaHasta(Coordenada otraCoordenada){

        int distanciaHorizontal = Math.abs(this.fila - otraCoordenada.getFila());
        int distanciaVertical = Math.abs(this.columna - otraCoordenada.getColumna());

        if(distanciaHorizontal > distanciaVertical)
            return distanciaHorizontal;
        else
            return distanciaVertical;
    }

}
