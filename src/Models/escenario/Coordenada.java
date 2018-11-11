package Models.escenario;

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

}
