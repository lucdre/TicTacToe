package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * @since 09/02/2015 (Java 1.8)
 * @author Luca
 *
 */
@SuppressWarnings("serial")
public class PanelJuego extends JPanel {
	
	private static final int tam = 3;
	
	JButton[][] tableroBtns;
	
	public PanelJuego() {
		
		addComponentes();
		
	}

	private void addComponentes() {
		this.setLayout(new GridLayout(3, 3));
		Border border = new LineBorder(Color.BLACK, 5);
		tableroBtns = new JButton[tam][tam];
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tableroBtns[i][j] = new JButton();
				tableroBtns[i][j].setBorder(border);
				this.add(tableroBtns[i][j]);
			}
		}
		
		
		
	}

}
