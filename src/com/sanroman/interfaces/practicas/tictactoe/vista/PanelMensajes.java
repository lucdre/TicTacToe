package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JOptionPane;

/**
 * Simple clase para las ventanas emergentes. 
 *
 * @author Luca Thiel (Lucdre)
 *
 * @see JOptionPane
 */

public class PanelMensajes extends JOptionPane{
	
	/**
	 * Auto-Generated Serial
	 */
	private static final long serialVersionUID = 1442215391963317073L;

	/**
	 * Muestra la ventana emergente de confirmación al salir de la aplicación.
	 * @return
	 */
	public static int exitConfirm(){
		return PanelMensajes.showConfirmDialog(null, "¿Estas seguro de que quieres salir del juego?", "ATENCIÓN", PanelMensajes.YES_NO_OPTION);
	}
	
	/**
	 * Muestra la ventana emergente con el turno del jugador al iniciar la partida.
	 * @param turno - el turno actual.
	 */
	public static void startMsg(String turno){
		PanelMensajes.showMessageDialog(null, "Empieza " + turno);
	}
	
	/**
	 * Muestra la ventana emergente al finalizar la partida
	 * 
	 * @param n - 0: Empate, 1: Gana círculo, 2: Gana cruz.
	 */
	public static void finMsg(int n){
		switch(n){
		case 0:
			PanelMensajes.showMessageDialog(null, "EMPATE, FIN DE LA PARTIDA");
			break;
		case 1:
			PanelMensajes.showMessageDialog(null, "LA PARTIDA HA FINALIZADO, HA GANADO CÍRCULO");
			break;
		case 2:
			PanelMensajes.showMessageDialog(null, "LA PARTIDA HA FINALIZADO, HA GANADO CRUZ");
			break;
		}
	}
	
	/**
	 * Muestra la ventana emergente acorde al error ocurrido.
	 * @param n - que error ha ocurrido.
	 */
	public static void errorMsg(int n){
		switch(n){
		case 0:
			PanelMensajes.showMessageDialog(null, "No se ha podido crear el archivo");
			break;
		case 1:
			PanelMensajes.showMessageDialog(null, "No se ha podido encontrar el archivo");
			break;
		case 2:
			PanelMensajes.showMessageDialog(null, "El fichero está vacío");
			break;
		case 3:
			PanelMensajes.showMessageDialog(null, "El fichero está corrupto, no se puede cargar la partida");
			break;	
		}	
	}
}
