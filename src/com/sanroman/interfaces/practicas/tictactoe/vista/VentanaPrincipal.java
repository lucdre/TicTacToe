package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * @since 20/01/2015 (Java 1.8)
 * @author Luca Thiel (Lucdre)
 * 
 */

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	
	Menu menuBar;
	PanelJuego panelJuego;
	BarraEstado barraEstado;

	public VentanaPrincipal() {
		
		setupFrame();
		
	}

	/**
	 * Ajustes del JFrame básicos
	 */
	private void setupFrame() {
		
		menuBar = new Menu();
		panelJuego = new PanelJuego();
		barraEstado = new BarraEstado();

		this.setLayout(new BorderLayout());
		this.add(panelJuego, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new VentanaPrincipal();
	}
}


