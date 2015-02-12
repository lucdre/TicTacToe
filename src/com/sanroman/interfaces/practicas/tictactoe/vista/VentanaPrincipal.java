package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;

/**
 * 
 * @author Luca Thiel (Lucdre)
 * 
 */

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	
	private Menu menuBar;
	private PanelJuego panelJuego;
	private BarraEstado barraEstado;
	private Controlador controlador;

	public VentanaPrincipal(Controlador controlador) {
		
		this.controlador = controlador;
		setupFrame();
		
	}

	/**
	 * Ajustes del JFrame básicos
	 */
	private void setupFrame() {
		
		menuBar = new Menu(controlador);
		panelJuego = new PanelJuego(controlador);
		barraEstado = new BarraEstado(controlador);

		this.setLayout(new BorderLayout());
		this.add(panelJuego, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	
}


