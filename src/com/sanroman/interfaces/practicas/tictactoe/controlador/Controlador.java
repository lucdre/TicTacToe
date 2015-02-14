package com.sanroman.interfaces.practicas.tictactoe.controlador;

import com.sanroman.interfaces.practicas.tictactoe.modelo.Ficha;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Partida;

/**
 * @author Luca Thiel (Lucdre)
 *
 */
public class Controlador {
	
	private Partida modelo;
	
	public Controlador(Partida modelo) {
		this.modelo = modelo;
	}
	
	public void iniciar(){
		modelo.iniciar();
	}
	
	public void cambiaTurno(){
		modelo.cambiarTurno();
	}
	
	public Ficha getTurno(){
		return modelo.getTurno();
		
	}

	public void addObserver(Observador o) {
		modelo.addObserv(o);
		
	}

	public void colocarFicha(int x, int y) {
		modelo.colocarFicha(x, y);
		
	}
		
	

}
