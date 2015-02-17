package com.sanroman.interfaces.practicas.tictactoe.modelo;

/**
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public class Tablero {
	
	private static final int tam = 3; // Tamaño del tablero
	
	private Casilla[][] tablero;
	
	
	public Tablero() {
		
		tablero = new Casilla[tam][tam];		
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tablero[i][j] = Casilla.LIBRE;
			}
		}
	}
	
	public Casilla[][] getTablero() {
		return tablero;
	}
	
	public void mostrarTablero(){
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}


