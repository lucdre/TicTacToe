package com.sanroman.interfaces.practicas.tictactoe.modelo;

/**
 * 
 * @since 28/01/2015 (Java 1.8)
 * @author Luca Thiel (Lucdre)
 *
 */
public class Tablero {
	
	private static final int tableroX = 3; // Alto
	private static final int tableroY = 3; // Ancho
	
	private Casilla[][] tablero;
	
	
	public Tablero() {
		
		tablero = new Casilla[tableroX][tableroY];		
		for (int i = 0; i < tableroX; i++) {
			for (int j = 0; j < tableroY; j++) {
				tablero[i][j] = Casilla.LIBRE;
			}
		}
	}
	
	public Casilla[][] getTablero() {
		return tablero;
	}
	
	public void mostrarTablero(){
		for (int i = 0; i < tableroX; i++) {
			for (int j = 0; j < tableroY; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}


