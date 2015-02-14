package com.sanroman.interfaces.practicas.tictactoe.test;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Partida;
import com.sanroman.interfaces.practicas.tictactoe.vista.BarraEstado;
import com.sanroman.interfaces.practicas.tictactoe.vista.Menu;
import com.sanroman.interfaces.practicas.tictactoe.vista.PanelJuego;
import com.sanroman.interfaces.practicas.tictactoe.vista.VentanaPrincipal;

/**
 * Programa Principal.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public class Main {

	public static void main(String[] args) {
		Partida modelo = new Partida();
		Controlador cont = new Controlador(modelo);
		Menu menu = new Menu(cont);
		PanelJuego panel = new PanelJuego(cont);
		BarraEstado barra = new BarraEstado(cont);
		VentanaPrincipal vista = new VentanaPrincipal(menu, panel, barra);
		modelo.addObserv(menu);
		modelo.addObserv(panel);
		modelo.addObserv(barra);
		vista.setVisible(true);
	}
	
	
}
