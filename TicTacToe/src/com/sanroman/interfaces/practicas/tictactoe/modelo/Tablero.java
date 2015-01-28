package com.sanroman.interfaces.practicas.tictactoe.modelo;

/**
 * 
 * @since 28/01/2015 (Java 1.8)
 * @author Luca Thiel (Lucdre)
 *
 */
public class Tablero {
	
	private static final int tableroX = 3; // Ancho
	private static final int tableroY = 3; // Alto
	
	private Casilla[][] tablero;
	
	
	public Tablero() {
		
		tablero = new Casilla[tableroY][tableroX];		
		for (int i = 0; i < tableroY; i++) {
			for (int j = 0; j < tableroX; j++) {
				tablero[i][j] = Casilla.LIBRE;
				if(tablero[i][j] == Casilla.LIBRE)
					System.out.print("L");
				else
					System.out.print("O");
			}
			System.out.println();
		}
	
	}
	
	public static void main(String[] args) {
		new Tablero();
	}

}


