package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

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


