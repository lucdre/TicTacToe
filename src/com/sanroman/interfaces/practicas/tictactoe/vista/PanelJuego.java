package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.sanroman.interfaces.practicas.tictactoe.controlador.Controlador;

/**
 * @since 09/02/2015 (Java 1.8)
 * @author Luca
 *
 */
@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener {

	private static final int tam = 3;

	private JButton[][] tableroBtns;
	private Controlador controlador;

	public PanelJuego(Controlador controlador) {

		this.controlador = controlador;
		addComponentes();

	}

	private void addComponentes() {
		this.setLayout(new GridLayout(3, 3));
		Border border = new LineBorder(Color.BLACK, 5);
		tableroBtns = new JButton[tam][tam];
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
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < tableroBtns.length; i++) {
			for (int j = 0; j < tableroBtns.length; j++) {
				if (e.getSource() == tableroBtns[i][j]) {
					
				}
			}
		}

	}

}
