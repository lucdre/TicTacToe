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
	 */
	//TODO
	public boolean buscarGanador() {
		
		Casilla[][] tab = tablero.getTablero();
		int tam = tab.length;
		int cont = 0;
		//Circulo true, X false (Sin adaptar)
		
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
		
		return false;
		
		
		
		
		
		
		
		

//		Casilla[][] tab = tablero.getTablero();
//		int tam = tab.length;
//		boolean ganador = false;
//		int cont = 0;
//		int aux = 0;
//		
//		//Horizontal
//		if(!ganador)
//			for (int i = 0; i < tam; i++) {
//				for (int j = 0; j < tam; j++) {
//					if(tab[i][j] == Casilla.OCUPADA_CIRCULO && tab[i][j] != Casilla.LIBRE){
//						cont++;
//						System.out.println(i + "-" + j + "-" + cont);
//					}
//					
//				}
//				System.out.println(i);
//				if(cont==3 || cont==0){
//					ganador = true;
//					System.out.println("gana1");
//					break;
//				}
//				cont = 0;
//			}
//		
//		//Vertical
//		if(!ganador)
//			for (int i = 0; i < tam; i++) {
//				for (int j = 0; j < tam; j++) {
//					if(tab[j][i] == Casilla.OCUPADA_CIRCULO && tab[j][i] != Casilla.LIBRE)
//						cont++;
//				}
//				if(cont==3 || cont==0){
//					ganador = true;
//					System.out.println("gana2");
//					break;
//				}
//				cont = 0;
//			}
//		
//		//Diagonal
//		if (!ganador) {
//			for (int i = 0; i < tam; i++) {
//				for (int j = 0; j < tam; j++) {
//					if (aux == 0 || aux % 4 == 0) {
//						if (tab[i][j] == Casilla.OCUPADA_CIRCULO
//								&& tab[i][j] != Casilla.LIBRE)
//							cont++;
//					}
//					aux++;
//				}
//			}
//			if(cont==3 || cont==0){
//				System.out.println("gana3");
//				ganador = true;	
//			}
//			cont = 0;
//			aux = 0;
//		}
//		if (!ganador) {
//			for (int i = 0; i < tam; i++) {
//				for (int j = 0; j < tam; j++) {
//					if (aux == 0 || aux % 2 == 0 && aux != 8) {
//						if (tab[i][j] == Casilla.OCUPADA_CIRCULO
//								&& tab[i][j] != Casilla.LIBRE)
//							cont++;
//					}
//					aux++;
//				}
//			}
//			if(cont==3 || cont==0){
//				System.out.println("gana4");
//				ganador = true;	
//			}
//				
//		}
//		
//		if(ganador)
//			for (Observador obs : observ) 
//				obs.finPartida();
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
				obs.finPartida();
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
		
		tablero.mostrarTablero();
		
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
		
		if(buscarGanador())
			for (Observador obs : observ) 
				obs.finPartida();
			
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
	
	public void addObserv(Observador o){
		observ.add(o);
	}

	public Ficha getTurno() {
		return fichaTurno;
		
	}

}
