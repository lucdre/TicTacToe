package com.sanroman.interfaces.practicas.tictactoe.vista;

import javax.swing.JLabel;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Ficha;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;

/**
 * @author Luca Thiel (Lucdre)
 *
 */
@SuppressWarnings("serial")
public class BarraEstado extends JLabel implements Observador{
	
	private Controlador controlador;
	
	public BarraEstado(Controlador controlador) {
		this.controlador = controlador;
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setText("PARTIDA NO INCIADA");
		
	}

	public void setTurnoText(){
		if(controlador.getTurno() == Ficha.CIRCULO)
			this.setText("TURNO CÍRCULO");
		else
			this.setText("TURNO CRUZ");
	}
	
	@Override
	public void iniciarPartida() {
		setTurnoText();
		
	}

	@Override
	public void finalizaTurno(int x, int y, boolean c) {
		setTurnoText();
		
	}

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

	@Override
	public void resetPartida() {
		this.setText("");
		
	}

}
