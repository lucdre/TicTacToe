package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Clase para la Ventana Principal que reune todos los componentes de la vista.
 * 
 * @author Luca Thiel (Lucdre)
 * 
 */


public class VentanaPrincipal extends JFrame {
	
	/**
	 * Auto-Generated Serial
	 */
	private static final long serialVersionUID = 2879019417236604564L;
	
	private Menu menuBar;
	private PanelJuego panelJuego;
	private BarraEstado barraEstado;

	/**
	 * Constructor básico para crear la vista.
	 * @param menu - El menú del juego.
	 * @param panel - El panel principal del juego.
	 * @param barra - La barra de estados del juego.
	 */
	public VentanaPrincipal(Menu menu, PanelJuego panel, BarraEstado barra) {
		
		this.menuBar = menu;
		this.panelJuego = panel;
		this.barraEstado = barra;
		setupFrame();
		
	}

	/**
	 * Ajustes del JFrame básicos
	 */
	private void setupFrame() {
		
		this.setLayout(new BorderLayout());
		this.add(panelJuego, BorderLayout.CENTER);
		this.add(barraEstado, BorderLayout.SOUTH);
		this.setJMenuBar(menuBar);
		this.setVisible(false);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
}