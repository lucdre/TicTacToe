package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @since 09/02/2015 (Java 1.8)
 * @author Luca
 *
 */
@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	// TODO
	public Menu() {

		JMenu partidaMenu = new JMenu("Partida");
		JMenu ayudaMenu = new JMenu("Ayuda");
		JMenuItem iniciarItem = new JMenuItem("Iniciar");
		JMenuItem guardarItem = new JMenuItem("Guardar");
		guardarItem.setEnabled(false);
		JMenuItem cargarItem = new JMenuItem("Cargar");
		JMenuItem salirItem = new JMenuItem("Salir");
		salirItem.setToolTipText("Salir del juego");
		salirItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (PanelMensajes.exitConfirm() == PanelMensajes.YES_OPTION) {
					System.exit(0);
				}

			}
		});
		JMenuItem acercaDeItem = new JMenuItem("Arcerca de");

		partidaMenu.add(iniciarItem);
		partidaMenu.add(guardarItem);
		partidaMenu.add(cargarItem);
		partidaMenu.add(salirItem);
		ayudaMenu.add(acercaDeItem);

		this.add(partidaMenu);
		this.add(ayudaMenu);
	}

}
