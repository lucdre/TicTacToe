package com.sanroman.interfaces.practicas.tictactoe.modelo;

/**
 * Simple interfaz con métodos de Observador personalizados.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public interface Observador {
	
	/**
	 * Ajustes necesarios para iniciar la {@link Partida}.
	 */
	public void iniciarPartida();
	/**
	 * Ajustes tras finalizar un turno. 
	 *  
	 * @param x - Alto del tablero
	 * @param y - Ancho del tablero
	 * @param colocada - Si se coloca o no la ficha
	 */
	public void finalizaTurno(int x, int y, boolean colocada);
	/**
	 * Ajustes tras finalizar la {@link Partida}.
	 * @param n - para determinar si ha habido empate o una victoria.
	 */
	public void finPartida(int n);
	/**
	 * Ajustes necesarios para resettear una {@link Partida}.
	 */
	public void resetPartida();
	

}
