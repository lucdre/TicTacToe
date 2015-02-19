package com.sanroman.interfaces.practicas.tictactoe.modelo;

/**
 * Clase simple del tablero de la partida
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public class Tablero {
	
	private static final int tam = 3; // Tamaño del tablero
	
	private Casilla[][] tablero;
	
	/**
	 * Inicializa el tablero, por defecto con todas las {@link Casilla}s libres.
	 */
	public Tablero() {	
		tablero = new Casilla[tam][tam];		
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tablero[i][j] = Casilla.LIBRE;
			}
		}
	}
	
	/**
	 * Devuelve el tablero de tipo {@link Casilla}.
	 * @return el tablero.
	 */
	public Casilla[][] getTablero() {
		return tablero;
	}
	
}


