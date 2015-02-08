package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * @since 20/01/2015 (Java 1.8)
 * @author Luca Thiel (Lucdre)
 * 
 */

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal() {
		setupFrame();
		
	}

	/**
	 * Basic JFrame Settings
	 */
	private void setupFrame() {
		
		//Menu
		JMenuBar menuBar = new JMenuBar();
		JMenu partidaMenu = new JMenu("Partida");
		JMenu ayudaMenu = new JMenu("Ayuda");
		JMenuItem iniciarItem = new JMenuItem("Iniciar");
		JMenuItem guardarItem = new JMenuItem("Guardar");
		JMenuItem cargarItem = new JMenuItem("Cargar");
		JMenuItem salirItem = new JMenuItem("Salir");
		JMenuItem acercaDeItem = new JMenuItem("Arcerca de");
		
		partidaMenu.add(iniciarItem);
		partidaMenu.add(guardarItem);
		partidaMenu.add(cargarItem);
		partidaMenu.add(salirItem);
		ayudaMenu.add(acercaDeItem);
		
		menuBar.add(partidaMenu);
		menuBar.add(ayudaMenu);

		
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


