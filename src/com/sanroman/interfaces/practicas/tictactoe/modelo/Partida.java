package com.sanroman.interfaces.practicas.tictactoe.modelo;

import java.util.ArrayList;
import java.util.Random;

import com.sanroman.interfaces.practicas.tictactoe.vista.PanelMensajes;

/**
 * Lógica principal del juego, controla el transcurso de la partida.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public class Partida {
	
	//De quien es el turno, true - circulo, false - X
	private boolean turno; 
	private Ficha fichaTurno;
		
	private ArrayList<Observador> observ;
	
	private Tablero tablero;
	
	/**
	 * Inicializa un {@link Tablero} y la lista de {@link Observador}es.
	 */
	public Partida() {
		tablero = new Tablero();
		observ = new ArrayList<Observador>();
	}
	
	/**
	 * Busca si hay 3 en raya.
	 * Recorre el {@link Tablero} en horizontal, {@link Tablero} vertical, y las 2 diagonales en busca de 3 {@link Casilla}s iguales.
	 * @return <code>Boolean</code> si ha encontrado ganador o no
	 */
	public boolean buscarGanador() {
		
		Casilla[][] tab = tablero.getTablero();
		int tam = getTam();
		int cont = 0;
		
		//horizontal
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if(!turno){
					if(tab[i][j] == Casilla.OCUPADA_CIRCULO)
						cont++;
				}
				else if(turno)
					if(tab[i][j] == Casilla.OCUPADA_CRUZ)
						cont++;
			}
			if(cont!=3)
				cont = 0;
			else return true;
		}
		
		//vertical
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if(!turno){
					if(tab[j][i] == Casilla.OCUPADA_CIRCULO)
						cont++;
				}
				else if(turno)
					if(tab[j][i] == Casilla.OCUPADA_CRUZ)
						cont++;
			}
			if(cont!=3)
				cont = 0;
			else return true;
		}
		
		//Diagonal 1
		for (int j = 0; j < tam; j++) {
			if (!turno) {
				if (tab[j][j] == Casilla.OCUPADA_CIRCULO)
					cont++;
			} else if (turno)
				if (tab[j][j] == Casilla.OCUPADA_CRUZ)
					cont++;
		}
		if (cont != 3)
			cont = 0;
		else
			return true;
		
		//Diagonal 2
		int n=tab.length-1;
		 for (int i = 0; i < tab.length; i++) {
			 if (!turno) {
					if (tab[n-i][i] == Casilla.OCUPADA_CIRCULO)
						cont++;
				} else if (turno)
					if (tab[n-i][i] == Casilla.OCUPADA_CRUZ)
						cont++;
		}
		 if (cont != 3)
				cont = 0;
			else
				return true;

		return false;	
	}
	
	/**
	 * Busca si la {@link Partida} ha empatado (tablero lleno)
	 */
	public void buscarEmpate(){
		
		Casilla[][] tab = tablero.getTablero();
		int tam = tab.length;
		boolean empate = true;
		
		for (int i = 0; i < tam; i++)
			for (int j = 0; j < tam; j++)
				if (tab[i][j] == Casilla.LIBRE)
					empate = false;

		if(empate)
			for (Observador obs : observ) 
				obs.finPartida(0);
	}
	
	/**
	 * Ajustes necesarios al iniciar la {@link Partida}.
	 */
	public void iniciar(){
		Random rnd = new Random();
		turno = rnd.nextBoolean();
		cambiarTurno();
		if(fichaTurno == Ficha.CRUZ) PanelMensajes.startMsg("CRUZ");
		else PanelMensajes.startMsg("CÍRCULO");
		
		for (Observador obs : observ) {
			obs.iniciarPartida();
		}
		
	}
	
	/**
	 * Coloca la {@link Ficha} en el {@link Tablero} si no hay ninguna colocada ya.
	 * @param x - Alto del tablero
	 * @param y - Ancho del tablero
	 */
	public void colocarFicha(int x, int y){
		boolean colocada = true;
		if(tablero.getTablero()[x][y] == Casilla.LIBRE){
			if(fichaTurno == Ficha.CIRCULO)
				tablero.getTablero()[x][y] = Casilla.OCUPADA_CIRCULO;
			else
				tablero.getTablero()[x][y] = Casilla.OCUPADA_CRUZ;
			cambiarTurno();
		}else
			colocada = false;
		
		for (Observador obs : observ) {
			obs.finalizaTurno(x, y, colocada);
		}
		
		if(buscarGanador()){
			for (Observador obs : observ){
				if(!turno)
					obs.finPartida(1);
				else
					obs.finPartida(2);
		
			}
		}
		else
			buscarEmpate();			
		
	}
	
	
	/**
	 * Cambia de turno cada vez que se mueve una {@link Ficha}.
	 */
	public void cambiarTurno() {
		if (turno) {
			turno = false;
			fichaTurno = Ficha.CRUZ;
		} else {
			turno = true;
			fichaTurno = Ficha.CIRCULO;
		}

	}
	
	/**
	 * Resettea el {@link Tablero}.
	 */
	public void reset(){
		tablero = new Tablero();
		for (Observador obs : observ) {
			obs.resetPartida();
		}
	}
	
	public void addObserv(Observador o){
		observ.add(o);
	}

	public Ficha getTurno() {
		return fichaTurno;
		
	}

	/**
	 * Devuelve el {@link Tablero} en formato array, cada linea es una posición del {@link Tablero} y de que color es la {@link Ficha}.
	 * Si no hay ficha, está libre.
	 * 
	 * @return un array de String con la posición del {@link Tablero} y la {@link Ficha} que ocupa.
	 */
	public String[] getTablero() {
		int tam = getTam();
		String[] linea = new String[tam*tam];
		int l=0;
		String color = "";
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				//ESTOS 3 IF SOBRAN SI NO TENDRÍA QUE ADAPTARLO A COLORES EN VEZ DE DEJARLO CON EL TIPO DE FICHA
				if(tablero.getTablero()[i][j]==Casilla.OCUPADA_CIRCULO)
					color = "NEGRO";
				else if(tablero.getTablero()[i][j]==Casilla.OCUPADA_CRUZ)
					color = "ROJO";
				else if (tablero.getTablero()[i][j]==Casilla.LIBRE)
					color = tablero.getTablero()[i][j].toString();
				linea[l] = i + " " + j + " " + color;
				l++;
			}
		}
		return linea;
	}

	/**
	 * Devuelve el tamaño del {@link Tablero}.
	 * 
	 * @return el tamaño de una linea {@link Tablero} (por defecto 3).
	 */
	public int getTam() {
		return tablero.getTablero().length;
	}
	
	

}
