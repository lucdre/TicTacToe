package com.sanroman.interfaces.practicas.tictactoe.modelo;

import java.util.ArrayList;
import java.util.Random;

import com.sanroman.interfaces.practicas.tictactoe.vista.PanelMensajes;

/**
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public class Partida {
	
	/**
	 * De quien es el turno, true - circulo, false - X
	 */
	private boolean turno; 
	private Ficha fichaTurno;
		
	private ArrayList<Observador> observ;
	
	private Tablero tablero;
	
	public Partida() {
		tablero = new Tablero();
		observ = new ArrayList<Observador>();
	}
	
	/**
	 * Busca si hay 3 en raya.
	 * Recorre el tablero en horizontal, {@link Tablero} vertical, y las 2 diagonales en busca de 3 casillas iguales.
	 * @return <code>Boolean</code> si ha encontrado ganador o no
	 */
	public boolean buscarGanador() {
		
		Casilla[][] tab = tablero.getTablero();
		int tam = tab.length;
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
	 * Busca si la partida ha empatado (tablero lleno)
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
	 * Ajustes necesarios al iniciar la partida
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
	 * Coloca la ficha en el tablero si no hay ninguna colocada ya
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
	 * Cambia de turno cada jugada
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
	
	

}
