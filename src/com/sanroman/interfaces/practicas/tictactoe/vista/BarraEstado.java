package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JLabel;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;

/**
 * @author Luca Thiel (Lucdre)
 *
 */
@SuppressWarnings("serial")
public class BarraEstado extends JLabel implements Observador{
	
	private Controlador controlador;
	
	public BarraEstado(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void iniciarPartida() {
		// TODO Auto-generated method stub
		
	}

}
