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
		return PanelMensajes.showConfirmDialog(null, "�Estas seguro de que quieres salir del juego?", "ATENCI�N", PanelMensajes.YES_NO_OPTION);
	}
	
	public static void startMsg(String turno){
		PanelMensajes.showMessageDialog(null, "Empieza " + turno);
	}
	
	public static void empateMsg(){
		
	}
	
	public static void finMsg(int n){
		switch(n){
		case 0:
			PanelMensajes.showMessageDialog(null, "EMPATE, FIN DE LA PARTIDA");
			break;
		case 1:
			PanelMensajes.showMessageDialog(null, "LA PARTIDA HA FINALIZADO, HA GANADO C�RCULO");
			break;
		case 2:
			PanelMensajes.showMessageDialog(null, "LA PARTIDA HA FINALIZADO, HA GANADO CRUZ");
			break;
		}
	}

}
