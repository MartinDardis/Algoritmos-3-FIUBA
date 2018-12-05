package Views;

import Controllers.Acciones.*;
import Controllers.BotonCasilleroHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import Views.layouts.*;

import Models.Posicionable;
import Models.Partida.Partida;
import Models.escenario.Coordenada;

public class PantallaPrincipal extends StackPane{

    private Stage ventana;
    private BotonCasillero[] casilleros;
    private Partida partida;
    private BotonCasillero casilleroActual;

    private Button botonPasarTurno;
    private Button botonMovimientoDerecha;
    private Button botonMovimientoIzquierda;
    private Button botonMovimientoAbajo;
    private Button botonMovimientoArriba;
    private Button botonMovimientoDiagonalArribaDerecha;
    private Button botonMovimientoDiagonalArribaIzquierda;
    private Button botonMovimientoDiagonalAbajoDerecha;
    private Button botonMovimientoDiagonalAbajoIzquierda;

    public PantallaPrincipal(Stage ventana, Partida partida) {

        this.ventana = ventana;
        this.partida = partida;
        this.dibujarCampo();
        this.crearBotonera();
     //   this.cargarCampo();
    }

    public void setActual(BotonCasillero unCasillero){
        this.casilleroActual = unCasillero;
    }

    public BotonCasillero getActual(){
        return this.casilleroActual;
    }


    public void crearBotonera() {

        botonPasarTurno = new Button("Pasar turno");
        botonPasarTurno.setOnAction(new BotonPasarTurnoHandler(partida, this));
        botonPasarTurno.setTranslateX(300);
        botonPasarTurno.getStyleClass().add("botonInicio");

        botonMovimientoDerecha = new Button(" → ");
        botonMovimientoDerecha.setOnAction(new BotonMovimientoDerechaHandler(partida, this));
        botonMovimientoDerecha.setTranslateX(360);
        botonMovimientoDerecha.setTranslateY(200);
        botonMovimientoDerecha.getStyleClass().add("botonInicio");

        botonMovimientoIzquierda = new Button(" ← ");
        botonMovimientoIzquierda.setOnAction(new BotonMovimientoIzquierdaHandler(partida, this));
        botonMovimientoIzquierda.setTranslateX(240);
        botonMovimientoIzquierda.setTranslateY(200);
        botonMovimientoIzquierda.getStyleClass().add("botonInicio");

        botonMovimientoArriba = new Button(" ↑ ");
        botonMovimientoArriba.setOnAction(new BotonMovimientoArribaHandler(partida, this));
        botonMovimientoArriba.setTranslateX(300);
        botonMovimientoArriba.setTranslateY(155);
        botonMovimientoArriba.getStyleClass().add("botonInicio");

        botonMovimientoAbajo = new Button(" ↓ ");
        botonMovimientoAbajo.setOnAction(new BotonMovimientoAbajoHandler(partida, this));
        botonMovimientoAbajo.setTranslateX(300);
        botonMovimientoAbajo.setTranslateY(245);
        botonMovimientoAbajo.getStyleClass().add("botonInicio");

        botonMovimientoDiagonalArribaDerecha = new Button(" ↗ ");
        botonMovimientoDiagonalArribaDerecha.setOnAction(new BotonMovimientoDiagonalArribaDerechaHandler(partida, this));
        botonMovimientoDiagonalArribaDerecha.setTranslateX(360);
        botonMovimientoDiagonalArribaDerecha.setTranslateY(155);
        botonMovimientoDiagonalArribaDerecha.getStyleClass().add("botonInicio");

        botonMovimientoDiagonalArribaIzquierda = new Button(" ↖ ");
        botonMovimientoDiagonalArribaIzquierda.setOnAction(new BotonMovimientoDiagonalArribaIzquierdaHandler(partida, this));
        botonMovimientoDiagonalArribaIzquierda.setTranslateX(240);
        botonMovimientoDiagonalArribaIzquierda.setTranslateY(155);
        botonMovimientoDiagonalArribaIzquierda.getStyleClass().add("botonInicio");

        botonMovimientoDiagonalAbajoDerecha = new Button(" ↘ ");
        botonMovimientoDiagonalAbajoDerecha.setOnAction(new BotonMovimientoDiagonalAbajoDerechaHandler(partida, this));
        botonMovimientoDiagonalAbajoDerecha.setTranslateX(360);
        botonMovimientoDiagonalAbajoDerecha.setTranslateY(245);
        botonMovimientoDiagonalAbajoDerecha.getStyleClass().add("botonInicio");

        botonMovimientoDiagonalAbajoIzquierda = new Button(" ↙ ");
        botonMovimientoDiagonalAbajoIzquierda.setOnAction(new BotonMovimientoDiagonalAbajoIzquierdaHandler(partida, this));
        botonMovimientoDiagonalAbajoIzquierda.setTranslateX(240);
        botonMovimientoDiagonalAbajoIzquierda.setTranslateY(245);
        botonMovimientoDiagonalAbajoIzquierda.getStyleClass().add("botonInicio");

        this.setStyle("-fx-background-color: grey");
        this.desactivarBotonera();

        getChildren().addAll(botonPasarTurno, botonMovimientoDerecha, botonMovimientoIzquierda, botonMovimientoArriba,
                            botonMovimientoAbajo, botonMovimientoDiagonalArribaDerecha, botonMovimientoDiagonalArribaIzquierda,
                            botonMovimientoDiagonalAbajoDerecha, botonMovimientoDiagonalAbajoIzquierda);
    }

    public void desactivarBotonera(){
        this.botonMovimientoDerecha.setVisible(false);
        this.botonMovimientoIzquierda.setVisible(false);
        this.botonMovimientoAbajo.setVisible(false);
        this.botonMovimientoArriba.setVisible(false);
        this.botonMovimientoDiagonalArribaDerecha.setVisible(false);
        this.botonMovimientoDiagonalArribaIzquierda.setVisible(false);
        this.botonMovimientoDiagonalAbajoDerecha.setVisible(false);
        this.botonMovimientoDiagonalAbajoIzquierda.setVisible(false);
    }


    public void dibujarCampo(){

        int filas = 25;
        int columnas = 25;
        int indice;
        this.casilleros = new BotonCasillero[filas*columnas];
        System.out.println("El nombre es " +  partida.getActual().getNombre());//para probar ingreso
        for (int i = 0; i<filas;i++){
            for (int j = 0; j<columnas;j++){

                Coordenada posicion = new Coordenada(i,j);
                Posicionable entidad = this.partida.obtenerElementoEn(posicion);
                indice = posicion.obtenerNumero();

                BotonCasillero actual = casilleros[indice];
                actual = new BotonCasillero(posicion, entidad);
                actual.setOnAction(new BotonCasilleroHandler(actual, this.partida, this));

                actual.aplicarEstilo();
                actual.setTranslateX((j*25)+1-450);
                actual.setTranslateY((i*25)+1-300);
                actual.setMaxSize(25,25);
                getChildren().add(actual);
            }
        }

    }

    public void actualizarCampo(){

        for(int i = 0; i  < 25*25 ; i++){
            casilleros[i].aplicarEstilo();
        }
    }

    public void activarBotoneraPlazaCentral(){ }

    public void activarBotoneraMovimiento(){
        this.botonMovimientoDerecha.setVisible(true);
        this.botonMovimientoIzquierda.setVisible(true);
        this.botonMovimientoAbajo.setVisible(true);
        this.botonMovimientoArriba.setVisible(true);
        this.botonMovimientoDiagonalArribaDerecha.setVisible(true);
        this.botonMovimientoDiagonalArribaIzquierda.setVisible(true);
        this.botonMovimientoDiagonalAbajoDerecha.setVisible(true);
        this.botonMovimientoDiagonalAbajoIzquierda.setVisible(true);
    }




}
