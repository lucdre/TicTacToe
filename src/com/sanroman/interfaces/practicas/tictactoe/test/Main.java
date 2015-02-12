package com.sanroman.interfaces.practicas.tictactoe.test;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Partida;
import com.sanroman.interfaces.practicas.tictactoe.vista.VentanaPrincipal;

/**
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public class Main {

	public static void main(String[] args) {
		new VentanaPrincipal(new Controlador(new Partida())).setVisible(true);
	}
	
	
}
