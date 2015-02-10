package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JLabel;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;

/**
 * @since 09/02/2015 (Java 1.8)
 * @author Luca
 *
 */
@SuppressWarnings("serial")
public class BarraEstado extends JLabel {
	
	private Controlador controlador;
	
	public BarraEstado(Controlador controlador) {
		this.controlador = controlador;
	}

}
