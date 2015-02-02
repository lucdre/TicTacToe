package com.sanroman.interfaces.practicas.tictactoe.modelo;

import java.util.Random;

/**
 * 
 * @since 29/01/2015 (Java 1.8)
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
	
	private Tablero tablero;
	
	public Partida() {
		tablero = new Tablero();
	}
	
	/**
	 * Busca si hay 3 en raya
	 * @param x - Alto del tablero
	 * @param y - Ancho del tablero
	 * @return True - Hay 3 en raya, False - No hay 3 en raya 
	 */
	public boolean buscarTresEnRaya(int x, int y) {
				
		return true;
		
	}
	
	/**
	 * Ajustes necesarios al iniciar la partida
	 */
	public void iniciar(){
		Random rnd = new Random();
		turno = rnd.nextBoolean();
		if(turno)
			fichaTurno = Ficha.CIRCULO;
		else
			fichaTurno = Ficha.CRUZ;
		
		jugando = true;
		
		tablero.mostrarTablero();
		
		while(jugando){
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					colocarFicha(i, j);
				}
			}
			jugando = false;
		}
		
		System.out.println("Se ha acabado la partida");
	}
	
	/**
	 * Coloca la ficha en el tablero
	 * @param x - Alto del tablero
	 * @param y - Ancho del tablero
	 */
	public void colocarFicha(int x, int y){
		if(tablero.getTablero()[x][y] == Casilla.LIBRE){
			tablero.getTablero()[x][y] = Casilla.OCUPADA;
			cambiarTurno();
		}else{
			System.out.println("no se ha hecho nada");
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
	
	public static void main(String[] args) {
		new Partida().iniciar();
	}

}
