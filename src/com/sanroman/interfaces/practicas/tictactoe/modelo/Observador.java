package com.sanroman.interfaces.practicas.tictactoe.modelo;

/**
 * @author Luca Thiel (Lucdre)
 *
 */
public interface Observador {
	
	public void iniciarPartida();
	/**
	 *  
	 * @param x - Alto del tablero
	 * @param y - Ancho del tablero
	 * @param colocada - Si se coloca o no la ficha
	 */
	public void finalizaTurno(int x, int y, boolean colocada);
	public void finPartida();
	

}
