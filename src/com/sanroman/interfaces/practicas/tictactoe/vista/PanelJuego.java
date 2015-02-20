package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Ficha;
import com.sanroman.interfaces.practicas.tictactoe.modelo.Observador;

/**
 * Clase para ajustar el panel de juego principal.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */

public class PanelJuego extends JPanel implements ActionListener, Observador {

	/**
	 * Auto-Generated Serial
	 */
	private static final long serialVersionUID = 7180837344347630995L;

	private static final int tam = 3;

	private JButton[][] tableroBtns;
	private Controlador controlador;
	private ImageIcon tttX;
	private ImageIcon tttO;

	/**
	 * Ajustes básicos para inciar el panel.
	 * 
	 * @param controlador - el controlador.
	 */
	public PanelJuego(Controlador controlador) {

		this.controlador = controlador;
		iniciarComponentes();
		tttX =  new ImageIcon("res/tictactoeX.png");
		tttO =  new ImageIcon("res/tictactoeO.png");
	}

	/**
	 * Para iniciar algunos componentes necesarios.
	 */
	private void iniciarComponentes() {
		this.setLayout(new GridLayout(tam, tam));
		tableroBtns = new JButton[tam][tam];
	}

	/**
	 * Las acciones al pulsar los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < tableroBtns.length; i++) {
			for (int j = 0; j < tableroBtns.length; j++) {
				if (e.getSource() == tableroBtns[i][j]) {				
					controlador.colocarFicha(i, j);
				}
			}
		}
	}
	
	/**
	 * Retorna true si es el turno es de cirulo y false si es X.
	 * @return <code>Boolean</code>
	 */
	public boolean getTurno(){
		if(controlador.getTurno() == Ficha.CIRCULO)
			return true;
		else
			return false;
	}

	/**
	 * Ajustes al inciar la partida.
	 */
	@Override
	public void iniciarPartida() {
		Border border = new LineBorder(Color.BLACK, 5);
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tableroBtns[i][j] = new JButton();
				tableroBtns[i][j].addActionListener(this);
				tableroBtns[i][j].setBorder(border);
				this.add(tableroBtns[i][j]);
			}
		}	
	}

	/**
	 * Ajustes al finalizar cada turno.
	 * 
	 * @param i - Alto del tablero.
	 * @param j - Ancho del tablero.
	 * @param c- El turno, para saber que imagen colocar.
	 */
	@Override
	public void finalizaTurno(int i, int j, boolean c) {

		if (c)
			tableroBtns[i][j].setIcon(tttX);
		else
			tableroBtns[i][j].setIcon(tttO);
	}

	/**
	 * Ajustes al finalizar la partida.
	 */
	@Override
	public void finPartida(int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tableroBtns[i][j].setEnabled(false);
			}
		}
	}

	/**
	 * Ajustes al resettear la partida.
	 */
	@Override
	public void resetPartida() {
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				this.remove(tableroBtns[i][j]);
			}
		}	
	}
}
