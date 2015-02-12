package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JLabel;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;

/**
 * @author Luca Thiel (Lucdre)
 *
 */
@SuppressWarnings("serial")
public class BarraEstado extends JLabel {
	
	private Controlador controlador;
	
	public BarraEstado(Controlador controlador) {
		this.controlador = controlador;
	}

}
