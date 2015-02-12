package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JOptionPane;

/**
 * Simple clase para las ventanas emergentes
 *
 * @author Luca Thiel (Lucdre)
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
