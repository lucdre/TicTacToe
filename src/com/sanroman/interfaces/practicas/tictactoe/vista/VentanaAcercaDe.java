package com.sanroman.interfaces.practicas.tictactoe.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Ventana simple para mostrar el Acerca De.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public class VentanaAcercaDe extends JFrame {

	/**
	 * Automatic-generated Serial
	 */
	private static final long serialVersionUID = 3061858446308380593L;

	private JPanel panel;
	private JTextArea textArea;

	public VentanaAcercaDe() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		addComponentes();
	}

	/**
	 * Añade e inicializa todos los componentes necesarios de la ventana.
	 */
	private void addComponentes() {
		panel = new JPanel();
		textArea = new JTextArea();
		leer();
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		
		panel.setLayout(new BorderLayout());
		panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
		this.add(panel);
	}

	/**
	 * Lee del archivo que contiene la ayuda y la imprime en el JPanel.
	 */
	public String leer() {

		String fileName = "res/ayuda.txt";
		String line = null;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((line = bufferedReader.readLine()) != null) {
				textArea.append(line+"\r\n");
			}

		} catch (FileNotFoundException ex) {
			PanelMensajes.errorMsg(1);
		} catch (IOException ex) {
			PanelMensajes.errorMsg(1);
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException e) {
				PanelMensajes.errorMsg(1);
			}
		}
		
		return line;
	}

}
