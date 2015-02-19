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
 * @author Luca Thiel (Lucdre)
 *
 */
@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener, Observador {

	private static final int tam = 3;

	private JButton[][] tableroBtns;
	private Controlador controlador;
	private ImageIcon tttX;
	private ImageIcon tttO;

	public PanelJuego(Controlador controlador) {

		this.controlador = controlador;
		addComponentes();
		tttX =  new ImageIcon("res/tictactoeX.png");
		tttO =  new ImageIcon("res/tictactoeO.png");

	}

	private void addComponentes() {
		this.setLayout(new GridLayout(tam, tam));
		tableroBtns = new JButton[tam][tam];

	}

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
	 * Retorna true si es el turno es de cirulo y false si es X
	 * @return
	 */
	public boolean getTurno(){
		if(controlador.getTurno() == Ficha.CIRCULO)
			return true;
		else
			return false;
	}

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

	@Override
	public void finalizaTurno(int i, int j, boolean c) {
		if(c){
			if(getTurno())
				tableroBtns[i][j].setIcon(tttX);
			else
				tableroBtns[i][j].setIcon(tttO);		
		}		
	}

	@Override
	public void finPartida(int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tableroBtns[i][j].setEnabled(false);
			}
		}
	}

	@Override
	public void resetPartida() {
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				this.remove(tableroBtns[i][j]);
				
			}
		}
		
	}

}
