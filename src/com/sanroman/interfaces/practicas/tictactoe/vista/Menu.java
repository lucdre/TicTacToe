package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;

/**
 * Clase para ajustar el menú de la ventana, antes y durante el transcurso del juego.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */

public class Menu extends JMenuBar implements Observador, ActionListener{
	
	/**
	 * Auto-Generated Serial
	 */
	private static final long serialVersionUID = 5511595074079359200L;
	
	private JMenuItem iniciarItem;
	private JMenuItem guardarItem;
	private JMenuItem cargarItem;
	private JMenuItem finalizarItem;
	private JMenuItem salirItem;
	private JMenuItem acercaDeItem;
	private JFileChooser chooser;
	private JFileChooser cargarChooser;
	
	private Controlador controlador;
	
	/**
	 * Ajustes necesarios para crear el menú.
	 * 
	 * @param controlador
	 */
	public Menu(Controlador controlador) {
		
		this.controlador = controlador;
		
		JMenu archivoMenu = new JMenu("Archivo");
		JMenu ayudaMenu = new JMenu("Ayuda");
		iniciarItem = new JMenuItem("Iniciar");
		iniciarItem.setToolTipText("Iniciar partida");
		iniciarItem.addActionListener(this);
		
		guardarItem = new JMenuItem("Guardar");
		guardarItem.setEnabled(false);
		guardarItem.setToolTipText("Guardar partida");
		guardarItem.addActionListener(this);
		
		cargarItem = new JMenuItem("Cargar");
		cargarItem.setToolTipText("Cargar partida");
		cargarItem.addActionListener(this);
		
		finalizarItem = new JMenuItem("Finalizar partida");
		finalizarItem.setEnabled(false);
		finalizarItem.setToolTipText("Finaliza la partida actual");
		finalizarItem.addActionListener(this);
		
		salirItem = new JMenuItem("Salir");
		salirItem.setToolTipText("Salir del juego");
		salirItem.addActionListener(this);
		
		acercaDeItem = new JMenuItem("Arcerca de");
		acercaDeItem.setToolTipText("Ayuda");
		acercaDeItem.addActionListener(this);

		archivoMenu.add(iniciarItem);
		archivoMenu.add(guardarItem);
		archivoMenu.add(cargarItem);
		archivoMenu.add(finalizarItem);
		archivoMenu.add(salirItem);
		ayudaMenu.add(acercaDeItem);

		this.add(archivoMenu);
		this.add(ayudaMenu);
	}
	
	/**
	 * Ajustes del menú al iniciar la Partida.
	 */
	@Override
	public void iniciarPartida() {
		iniciarItem.setEnabled(false);
		guardarItem.setEnabled(true);
		cargarItem.setEnabled(false);
		finalizarItem.setEnabled(true);		
	}
	
	/**
	 * Ajustes del menú al finalizar el turno.
	 */
	@Override
	public void finalizaTurno(int x, int y, boolean c) {}
	
	/**
	 * Ajustes necesarios del menú al finalizar la partida.
	 */
	@Override
	public void finPartida(int n) {
		guardarItem.setEnabled(false);	
	}
	/**
	 * Ajustes necesarios del menú al resettear la partida.
	 */
	@Override
	public void resetPartida() {
		iniciarItem.setEnabled(true);
		guardarItem.setEnabled(false);
		cargarItem.setEnabled(true);
		finalizarItem.setEnabled(false);		
	}
	/**
	 * Las acciones al pulsar las distintas opciones del menú.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(iniciarItem))
			controlador.iniciar();	
		
		if(e.getSource().equals(finalizarItem))
			controlador.reset();
			
		if(e.getSource().equals(salirItem))
			if (PanelMensajes.exitConfirm() == PanelMensajes.YES_OPTION) 
				System.exit(0);
		
		if (e.getSource().equals(guardarItem)) {
			chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Archivo de texto", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				controlador.guardar(chooser.getSelectedFile() + ".txt");
			}
		}
		
		if (e.getSource().equals(cargarItem)){
			cargarChooser = new JFileChooser();
			cargarChooser.setApproveButtonText("Seleccionar archivo");
			cargarChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
			cargarChooser.setFileFilter(filter);
			int returnVal = cargarChooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				controlador.cargar(cargarChooser.getSelectedFile());
			}
		}
		
		if(e.getSource().equals(acercaDeItem)){
			new VentanaAcercaDe();
		}
	}
}
