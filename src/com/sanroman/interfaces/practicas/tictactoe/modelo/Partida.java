package com.sanroman.interfaces.practicas.tictactoe.modelo;

import java.awt.Panel;
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
	
	/**
	 * Si se sigue jugando o no
	 */
	private boolean jugando;
	private int posX;
	private int posY;
	
	private ArrayList<Observador> observ;
	
	private Tablero tablero;
	
	public Partida() {
		tablero = new Tablero();
		observ = new ArrayList<Observador>();
	}
	
	/**
	 * Busca si hay 3 en raya
	 * @return True - Hay 3 en raya, False - No hay 3 en raya 
	 */
	//TODO
	public boolean buscarGanador() {

		return false;
	}
	
	/**
	 * Busca si la partida ha empatado (tablero lleno)
	 * @return True - ha empatado, False - No ha empatado
	 */
	public boolean buscarEmpate(){
		
		Casilla[][] tab = tablero.getTablero();
		int tam = tab.length;
		
		for (int i = 0; i < tam; i++)
			for (int j = 0; j < tam; j++)
				if (tab[i][j] == Casilla.LIBRE)
					return false;

		return true;
		
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
		
		jugando = true;
		
		while(jugando){
			
		}
		tablero.mostrarTablero();
		
		for (Observador obs : observ) {
			obs.iniciarPartida();
		}
		
	}
	
	/**
	 * El juego
	 */
	
	
	/**
	 * Coloca la ficha en el tablero
	 * @param x - Alto del tablero
	 * @param y - Ancho del tablero
	 */
	public void colocarFicha(int x, int y){
		if(tablero.getTablero()[x][y] == Casilla.LIBRE){
			if(fichaTurno == Ficha.CIRCULO)
				tablero.getTablero()[x][y] = Casilla.OCUPADA_CIRCULO;
			else
				tablero.getTablero()[x][y] = Casilla.OCUPADA_CRUZ;
			cambiarTurno();
		}else{
			System.out.println("NO PUEDES COLOCAR LA FICHA AHÍ");
		}
		
		tablero.mostrarTablero();
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
	
	public void addObserv(Observador o){
		observ.add(o);
	}

	public Ficha getTurno() {
		return fichaTurno;
		
	}

}
