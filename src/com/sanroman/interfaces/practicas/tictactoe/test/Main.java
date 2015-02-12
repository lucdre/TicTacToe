package com.sanroman.interfaces.practicas.tictactoe.test;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		new VentanaPrincipal(new Controlador()).setVisible(true);
	}
	
	
}
