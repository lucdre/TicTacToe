package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JLabel;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Ficha;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;

/**
 * Clase para la barra de estado. Mostrará información útil de la partida.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */

public class BarraEstado extends JLabel implements Observador{
	
	/**
	 * Auto-Generated Serial
	 */
	private static final long serialVersionUID = -4955082050482165455L;
	
	private Controlador controlador;
	
	/**
	 * Inicializa algunos ajustes necesarios.
	 * 
	 * @param controlador - El controlador.
	 */
	public BarraEstado(Controlador controlador) {
		this.controlador = controlador;
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setText("PARTIDA NO INCIADA");
		
	}

	/**
	 * Cambia el turno actual en la barra de estado.
	 */
	public void setTurnoText(){
		if(controlador.getTurno() == Ficha.CIRCULO)
			this.setText("TURNO CÍRCULO");
		else
			this.setText("TURNO CRUZ");
	}
	
	/**
	 * Ajusta el texto de la barra de estado al inciar la {@link com.sanroman.interfaces.practicas.tictactoe.modelo.Partida Partida}.
	 */
	@Override
	public void iniciarPartida() {
		setTurnoText();
		
	}

	/**
	 * Cambia el texto de la barra de estado tras finalizar el turno.
	 */
	@Override
	public void finalizaTurno(int x, int y, boolean c) {
		setTurnoText();
	}

	/**
	 * Cambia el texto de la barra de estado acorde al ganador de la partida o si ha habido un empate.
	 * @param n - Especifica si ha habido empate o quién ha sido el ganador.
	 */
	@Override
	public void finPartida(int n) {
		PanelMensajes.finMsg(n);
		switch(n){
		case 0:
			this.setText("EMPATE, FIN DE LA PARTIDA");
			break;
		case 1:
			this.setText("LA PARTIDA HA FINALIZADO, HA GANADO CÍRCULO");
			break;
		case 2:
			this.setText("LA PARTIDA HA FINALIZADO, HA GANADO CRUZ");
			break;
		}
		
	}

	/**
	 * Resettea el texto de la barra de estado.
	 */
	@Override
	public void resetPartida() {
		this.setText("");
		
	}

}
