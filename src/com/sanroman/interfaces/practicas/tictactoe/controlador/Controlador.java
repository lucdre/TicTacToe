package com.sanroman.interfaces.practicas.tictactoe.controlador;


import java.io.File;

import com.sanroman.interfaces.practicas.tictactoe.modelo.Ficha;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Partida;

/**
 * Clase del controlador para poder cumplir con el MVC.
 * Solamente puede ser llamado por la vista, y solo se puede comunicar con el modelo.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */


public class Controlador {
	
	private Partida modelo;
	
	/**
	 * Se inicializa el modelo.
	 * 
	 * @param modelo - el modelo.
	 */
	public Controlador(Partida modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * Inicia una partida.
	 */
	public void iniciar(){
		modelo.iniciar();
	}
	
	/**
	 * Cambia el turno.
	 */
	public void cambiaTurno(){
		modelo.cambiarTurno();
	}
	
	/**
	 * Resetea una partida.
	 */
	public void reset() {
		modelo.reset();
		
	}
	
	/**
	 * Devuelve el turno actual en forma de {@link Ficha}.
	 * @return {@link Ficha} - el turno.
	 */
	public Ficha getTurno(){
		return modelo.getTurno();
		
	}

	/**
	 * Añade un observador. 
	 * @param o - el observador.
	 */
	public void addObserver(Observador o) {
		modelo.addObserv(o);
		
	}

	/**
	 * Coloca una ficha en el {@link Tablero}.
	 * @param x - alto del {@link Tablero}.
	 * @param y - ancho del {@link Tablero}.
	 */
	public void colocarFicha(int x, int y) {
		modelo.colocarFicha(x, y);
		
	}

	/**
	 * Devuelve el {@link Tablero} en forma de Array de String.
	 * @return {@link Tablero} - El tablero de la partida.
	 */
	public String[] getTablero() {
		return modelo.getTablero();
	}

	/**
	 * Devuelve el tamaño del {@link Tablero} de la {@link Partida}.
	 * 
	 * @return int - El tamaño del {@link Tablero} de la {@link Partida}.
	 */
	public int getTam() {
		return modelo.getTam();
	}

	/**
	 * Guarda la {@link Partida}.
	 * @param string - La ruta en la que se guarda.
	 */
	public void guardar(String string) {
		modelo.guardar(string);
		
	}

	/**
	 * Carga una {@link Partida}.
	 * @param selectedFile - El archivo que se va a cargar.
	 */
	public void cargar(File selectedFile) {
		modelo.cargar(selectedFile);
		
	}

	
		
	

}
