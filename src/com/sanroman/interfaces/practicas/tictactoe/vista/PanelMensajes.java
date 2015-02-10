package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JOptionPane;

/**
 * Simple clase para las ventanas emergentes
 *
 * @since 09/02/2015 (Java 1.8)
 * @author Luca
 *
 */
@SuppressWarnings("serial")
public class PanelMensajes extends JOptionPane{
	
	public static int exitConfirm(){
		return PanelMensajes.showConfirmDialog(null, "¿Estas seguro de que quieres salir del juego?", "ATENCIÓN", PanelMensajes.YES_NO_OPTION);
	}
	
	public static void startMsg(String turno){
		PanelMensajes.showMessageDialog(null, "Empieza " + turno);
	}

}
