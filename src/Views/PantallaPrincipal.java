package Views;

import Controllers.*;
import Controllers.Acciones.*;
import Controllers.Acciones.Construccion.*;
import Controllers.Acciones.Movimiento.*;
import Controllers.Acciones.Creacion.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import Views.layouts.*;

import Models.Posicionable;
import Models.Partida.Partida;
import Models.juego.Jugador;
import Models.escenario.Coordenada;
import org.apache.commons.lang3.ObjectUtils;

public class PantallaPrincipal extends StackPane{

    private Stage ventana;
    private BotonCasillero[] casilleros;
    private Partida partida;
    private BotonCasillero casilleroActual;

    private Button botonPasarTurno;
    private Button botonCrearAldeano;
    private Button botonConstruirCuartel;

    private Button botonMovimientoDerecha;
    private Button botonMovimientoIzquierda;
    private Button botonMovimientoAbajo;
    private Button botonMovimientoArriba;
    private Button botonMovimientoDiagonalArribaDerecha;
    private Button botonMovimientoDiagonalArribaIzquierda;
    private Button botonMovimientoDiagonalAbajoDerecha;
    private Button botonMovimientoDiagonalAbajoIzquierda;

    private Button cartelNombre;
    private Button cartelOro;
    private Button cartelPoblacion;
    private Button cartelSalud;

    public PantallaPrincipal(Stage ventana, Partida partida) {

        this.ventana = ventana;
        this.partida = partida;
        this.dibujarCampo();
        this.crearBotonera();
        this.crearCartelesJugador();
    }

    public void setActual(BotonCasillero unCasillero){
        this.casilleroActual = unCasillero;
    }

    public BotonCasillero getActual(){
        return this.casilleroActual;
    }

    public void crearCartelesJugador(){

        Jugador jugadorActual = partida.getActual();

        String nombreJugador = jugadorActual.getNombre();
        nombreJugador = "Jugador: " + nombreJugador;
        cartelNombre = new Button(nombreJugador);
        cartelNombre.setTranslateX(250);
        cartelNombre.setTranslateY(-225);
        cartelNombre.getStyleClass().add("recuadroInfo");
        getChildren().addAll(cartelNombre);

        int oro = jugadorActual.getOro();

        String oroJugador = Integer.toString(oro);
        oroJugador = "Oro: " + oroJugador;
        cartelOro = new Button(oroJugador);
        cartelOro.setTranslateX(410);
        cartelOro.setTranslateY(-225);
        cartelOro.getStyleClass().add("recuadroInfo");
       /* if (oro <= 0){
            cartelOro.getStyleClass().removeAll();
            cartelOro.setStyle(null);
            cartelOro.getStyleClass().add("infoBorde");
        }*/
        getChildren().addAll(cartelOro);

        int poblacion = jugadorActual.getPoblacionActual();
        String poblacionJugador = Integer.toString(poblacion);
        poblacionJugador = "Poblacion: " + poblacionJugador + "/50";
        cartelPoblacion = new Button(poblacionJugador);
        cartelPoblacion.setTranslateX(250);
        cartelPoblacion.setTranslateY(-165);
        cartelPoblacion.getStyleClass().add("recuadroInfo");
        /*if (poblacion == 50){
            cartelPoblacion.getStyleClass().add("infoBorde");
        }*/
        getChildren().addAll(cartelPoblacion);




    }

    public void actualizarCartelesJugador(){

        getChildren().remove(cartelNombre);
        getChildren().remove(cartelOro);
        getChildren().remove(cartelPoblacion);


        Jugador jugadorActual = partida.getActual();

        String nombreJugador = jugadorActual.getNombre();
        nombreJugador = "Jugador actual: " + nombreJugador;
        cartelNombre = new Button(nombreJugador);
        cartelNombre.setTranslateX(250);
        cartelNombre.setTranslateY(-225);
        cartelNombre.getStyleClass().add("recuadroInfo");
        cartelOro.getStyleClass().add("recuadroInfo");
        getChildren().addAll(cartelNombre);

        int oro = jugadorActual.getOro();
        String oroJugador = Integer.toString(oro);
        oroJugador = "Oro: " + oroJugador;
        cartelOro = new Button(oroJugador);
        cartelOro.setTranslateX(410);
        cartelOro.setTranslateY(-225);
        cartelOro.getStyleClass().add("recuadroInfo");
        cartelOro.getStyleClass().add("recuadroInfo");
        getChildren().addAll(cartelOro);

        int poblacion = jugadorActual.getPoblacionActual();
        String poblacionJugador = Integer.toString(poblacion);
        poblacionJugador = "Poblacion: " + poblacionJugador + "/50";
        cartelPoblacion = new Button(poblacionJugador);
        cartelPoblacion.setTranslateX(250);
        cartelPoblacion.setTranslateY(-165);
        cartelPoblacion.getStyleClass().add("recuadroInfo");
        cartelPoblacion.getStyleClass().add("recuadroInfo");
        getChildren().addAll(cartelPoblacion);

    }


    public void crearBotonera() {

        botonPasarTurno = new Button("Pasar turno");
        botonPasarTurno.setOnAction(new BotonPasarTurnoHandler(partida, this));
        botonPasarTurno.setTranslateX(325);
        botonPasarTurno.setTranslateY(-280);
        botonPasarTurno.getStyleClass().add("botonInicio");

        botonCrearAldeano = new Button("Crear Aldeano");
        botonCrearAldeano.setOnAction(new BotonCrearAldeanoHandler(partida, this));
        botonCrearAldeano.setTranslateX(325);
        botonCrearAldeano.setTranslateY(-50);
        botonCrearAldeano.getStyleClass().add("botonInicio");

        botonConstruirCuartel = new Button("Construir Cuartel");
        botonConstruirCuartel.setOnAction(new BotonConstruirCuartelHandler(partida, this));
        botonConstruirCuartel.setTranslateX(325);
        botonConstruirCuartel.setTranslateY(-50);
        botonConstruirCuartel.getStyleClass().add("botonInicio");

       /* botonConstruirPlaza = new Button("Construir Plaza Central");
        botonConstruirPlaza.setOnAction(new botonConstruirPlazaHandler(partida, this));
        botonConstruirPlaza.setTranslateX(325);
        botonConstruirPlaza.setTranslateY(-50);
        botonConstruirPlaza.getStyleClass().add("botonInicio");
        */

        botonMovimientoDerecha = new Button(" → ");
        botonMovimientoDerecha.setOnAction(new BotonMovimientoDerechaHandler(partida, this));
        botonMovimientoDerecha.setTranslateX(385);
        botonMovimientoDerecha.setTranslateY(200);
        botonMovimientoDerecha.getStyleClass().add("botonInicio");

        botonMovimientoIzquierda = new Button(" ← ");
        botonMovimientoIzquierda.setOnAction(new BotonMovimientoIzquierdaHandler(partida, this));
        botonMovimientoIzquierda.setTranslateX(265);
        botonMovimientoIzquierda.setTranslateY(200);
        botonMovimientoIzquierda.getStyleClass().add("botonInicio");

        botonMovimientoArriba = new Button(" ↑ ");
        botonMovimientoArriba.setOnAction(new BotonMovimientoArribaHandler(partida, this));
        botonMovimientoArriba.setTranslateX(325);
        botonMovimientoArriba.setTranslateY(155);
        botonMovimientoArriba.getStyleClass().add("botonInicio");

        botonMovimientoAbajo = new Button(" ↓ ");
        botonMovimientoAbajo.setOnAction(new BotonMovimientoAbajoHandler(partida, this));
        botonMovimientoAbajo.setTranslateX(325);
        botonMovimientoAbajo.setTranslateY(245);
        botonMovimientoAbajo.getStyleClass().add("botonInicio");

        botonMovimientoDiagonalArribaDerecha = new Button(" ↗ ");
        botonMovimientoDiagonalArribaDerecha.setOnAction(new BotonMovimientoDiagonalArribaDerechaHandler(partida, this));
        botonMovimientoDiagonalArribaDerecha.setTranslateX(385);
        botonMovimientoDiagonalArribaDerecha.setTranslateY(155);
        botonMovimientoDiagonalArribaDerecha.getStyleClass().add("botonInicio");

        botonMovimientoDiagonalArribaIzquierda = new Button(" ↖ ");
        botonMovimientoDiagonalArribaIzquierda.setOnAction(new BotonMovimientoDiagonalArribaIzquierdaHandler(partida, this));
        botonMovimientoDiagonalArribaIzquierda.setTranslateX(265);
        botonMovimientoDiagonalArribaIzquierda.setTranslateY(155);
        botonMovimientoDiagonalArribaIzquierda.getStyleClass().add("botonInicio");

        botonMovimientoDiagonalAbajoDerecha = new Button(" ↘ ");
        botonMovimientoDiagonalAbajoDerecha.setOnAction(new BotonMovimientoDiagonalAbajoDerechaHandler(partida, this));
        botonMovimientoDiagonalAbajoDerecha.setTranslateX(385);
        botonMovimientoDiagonalAbajoDerecha.setTranslateY(245);
        botonMovimientoDiagonalAbajoDerecha.getStyleClass().add("botonInicio");

        botonMovimientoDiagonalAbajoIzquierda = new Button(" ↙ ");
        botonMovimientoDiagonalAbajoIzquierda.setOnAction(new BotonMovimientoDiagonalAbajoIzquierdaHandler(partida, this));
        botonMovimientoDiagonalAbajoIzquierda.setTranslateX(265);
        botonMovimientoDiagonalAbajoIzquierda.setTranslateY(245);
        botonMovimientoDiagonalAbajoIzquierda.getStyleClass().add("botonInicio");

        this.setStyle("-fx-background-color: grey");
        this.desactivarBotonera();

        getChildren().addAll(botonPasarTurno, botonMovimientoDerecha, botonMovimientoIzquierda, botonMovimientoArriba,
                            botonMovimientoAbajo, botonMovimientoDiagonalArribaDerecha, botonMovimientoDiagonalArribaIzquierda,
                            botonMovimientoDiagonalAbajoDerecha, botonMovimientoDiagonalAbajoIzquierda, botonCrearAldeano,
                            botonConstruirCuartel);
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
        this.botonCrearAldeano.setVisible(false);
        this.botonConstruirCuartel.setVisible(false);
        //this.botonConstruirPlaza.setVisible(false);
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

    public void activarBotoneraPlazaCentral(){
        this.botonCrearAldeano.setVisible(true);
    }

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

    public void activarBotoneraAldeano(){
        this.botonConstruirCuartel.setVisible(true);
        //this.botonConstruirPlaza.setVisible(true);
    }


    public void imprimirVida(Posicionable entidad) {
            int saludActual = getActual().Posicionable().getVida();
            String saludPosionableActual = Integer.toString(saludActual);
            saludPosionableActual = "Salud: " + saludPosionableActual;
            cartelSalud = new Button(saludPosionableActual);
            cartelSalud.setTranslateX(410);
            cartelSalud.setTranslateY(-165);
            cartelSalud.setMinWidth(150);
            cartelSalud.getStyleClass().add("recuadroInfo");
            getChildren().add(cartelSalud);
    }
}
