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
	
	private JMenuItem iniciarItem;
	private JMenuItem guardarItem;
	private JMenuItem cargarItem;
	private JMenuItem finalizarItem;
	private JMenuItem salirItem;
	private JMenuItem acercaDeItem;
	// TODO
	public Menu(Controlador controlador) {
		
		JMenu archivoMenu = new JMenu("Archivo");
		JMenu ayudaMenu = new JMenu("Ayuda");
		iniciarItem = new JMenuItem("Iniciar");
		iniciarItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.iniciar();	
			}
		});
		
		guardarItem = new JMenuItem("Guardar");
		guardarItem.setEnabled(false);
		cargarItem = new JMenuItem("Cargar");
		finalizarItem = new JMenuItem("Finalizar partida");
		finalizarItem.setEnabled(false);
		finalizarItem.setToolTipText("Finaliza la partida actual");
		finalizarItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.reset();
				
			}
		});
		salirItem = new JMenuItem("Salir");
		salirItem.setToolTipText("Salir del juego");
		salirItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (PanelMensajes.exitConfirm() == PanelMensajes.YES_OPTION) {
					System.exit(0);
				}

			}
		});
		acercaDeItem = new JMenuItem("Arcerca de");

		archivoMenu.add(iniciarItem);
		archivoMenu.add(guardarItem);
		archivoMenu.add(cargarItem);
		archivoMenu.add(finalizarItem);
		archivoMenu.add(salirItem);
		ayudaMenu.add(acercaDeItem);

		this.add(archivoMenu);
		this.add(ayudaMenu);
	}
	@Override
	public void iniciarPartida() {
		iniciarItem.setEnabled(false);
		guardarItem.setEnabled(true);
		cargarItem.setEnabled(false);
		finalizarItem.setEnabled(true);
		
	}
	
	@Override
	public void finalizaTurno(int x, int y, boolean c) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void finPartida(int n) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resetPartida() {
		iniciarItem.setEnabled(true);
		guardarItem.setEnabled(false);
		cargarItem.setEnabled(true);
		finalizarItem.setEnabled(false);
		
	}

}
