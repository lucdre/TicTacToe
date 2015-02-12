package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;

/**
 * @author Luca Thiel (Lucdre)
 *
 */
@SuppressWarnings("serial")
public class Menu extends JMenuBar implements Observador{
	
	private Controlador controlador;
	// TODO
	public Menu(Controlador controlador) {

		this.controlador = controlador;
		
		JMenu partidaMenu = new JMenu("Partida");
		JMenu ayudaMenu = new JMenu("Ayuda");
		JMenuItem iniciarItem = new JMenuItem("Iniciar");
		iniciarItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.iniciar();	
			}
		});
		
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
	@Override
	public void iniciarPartida() {
		// TODO Auto-generated method stub
		
	}

}
