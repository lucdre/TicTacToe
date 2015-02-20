package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Ficha;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;

/**
 * @author Luca Thiel (Lucdre)
 *
 */
@SuppressWarnings("serial")
public class Menu extends JMenuBar implements Observador, ActionListener{
	
	private JMenuItem iniciarItem;
	private JMenuItem guardarItem;
	private JMenuItem cargarItem;
	private JMenuItem finalizarItem;
	private JMenuItem salirItem;
	private JMenuItem acercaDeItem;
	private JFileChooser chooser ;
	
	private Controlador controlador;
	// TODO
	public Menu(Controlador controlador) {
		
		this.controlador = controlador;
		
		JMenu archivoMenu = new JMenu("Archivo");
		JMenu ayudaMenu = new JMenu("Ayuda");
		iniciarItem = new JMenuItem("Iniciar");
		iniciarItem.addActionListener(this);
		
		guardarItem = new JMenuItem("Guardar");
		guardarItem.setEnabled(false);
		guardarItem.addActionListener(this);
		
		cargarItem = new JMenuItem("Cargar");
		
		
		finalizarItem = new JMenuItem("Finalizar partida");
		finalizarItem.setEnabled(false);
		finalizarItem.setToolTipText("Finaliza la partida actual");
		finalizarItem.addActionListener(this);
		
		salirItem = new JMenuItem("Salir");
		salirItem.setToolTipText("Salir del juego");
		salirItem.addActionListener(this);
		
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(iniciarItem))
			controlador.iniciar();	
		
		if(e.getSource().equals(finalizarItem))
			controlador.reset();
			
		if(e.getSource().equals(salirItem))
			if (PanelMensajes.exitConfirm() == PanelMensajes.YES_OPTION) 
				System.exit(0);
		
		if(e.getSource().equals(guardarItem)){
			chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo .txt", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showSaveDialog(null);
			if(returnVal==JFileChooser.APPROVE_OPTION){
				FileWriter fw=null;
				try {
					String[] tablero = controlador.getTablero();
					String turno = "";
					if(controlador.getTurno() == Ficha.CIRCULO){
						turno = "NEGRO";
					}else{
						turno = "ROJO";
					}
					fw = new FileWriter(chooser.getSelectedFile()+".txt");
					fw.write(turno+"\r\n");
					for (int i = 0; i < controlador.getTam()*controlador.getTam(); i++) {
						fw.write(tablero[i]+"\r\n");
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						if(fw != null)
							fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
			
		
	}

}
