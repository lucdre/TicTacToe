package com.sanroman.interfaces.practicas.tictactoe.modelo;

import java.util.Random;

/**
 * 
 * @since 29/01/2015 (Java 1.8)
 * @author Luca Thiel (Lucdre)
 *
 */
public class Partida {
	
	/**
	 * De quien es el turno, true - circulo, false - X
	 */
	private boolean turno; 
	private Ficha fichaTurno;
	
	/**
	 * Si se sigue jugando o no
	 */
	private boolean jugando;
	
	private Tablero tablero;
	
	public Partida() {
		tablero = new Tablero();
	}
	
	/**
	 * Busca si hay 3 en raya
	 * @return True - Hay 3 en raya, False - No hay 3 en raya 
	 */
	public boolean buscarGanador() {

		Casilla[][] tab = tablero.getTablero();
		
		// HORIZONTAL DERECHA-IZQUIERDA
		if (tab[0][0] == tab[0][0 + 1])
			if (tab[0][0] == tab[0][0 + 2])
				return true;
		// VERTICAL ARRIBA-ABAJO
		if (tab[0][0] == tab[0 + 1][0])
			if (tab[0][0] == tab[0 + 2][0])
				return true;
		// DIAGONAL ARRIBA-ABAJO
		if (tab[0][0] == tab[0 + 1][0 + 1])
			if (tab[0][0] == tab[0 + 2][0 + 2])
				return true;

		return false;
	}
	
	/**
	 * Busca si la partida ha empatado (tablero lleno)
	 * @return True - ha empatado, False - No ha empatado
	 */
	public boolean buscarEmpate(){
		
		Casilla[][] tab = tablero.getTablero();
		int tam = tab.length;
		
		for (int i = 0; i < tam; i++)
			for (int j = 0; j < tam; j++)
				if (tab[i][j] == Casilla.LIBRE)
					return false;

		return true;
		
	}
	
	/**
	 * Ajustes necesarios al iniciar la partida
	 */
	public void iniciar(){
		Random rnd = new Random();
		turno = rnd.nextBoolean();
		cambiarTurno();
		
		jugando = true;
		
		tablero.mostrarTablero();
		
	}
	
	/**
	 * Coloca la ficha en el tablero
	 * @param x - Alto del tablero
	 * @param y - Ancho del tablero
	 */
	public void colocarFicha(int x, int y){
		if(tablero.getTablero()[x][y] == Casilla.LIBRE){
			if(fichaTurno == Ficha.CIRCULO)
				tablero.getTablero()[x][y] = Casilla.OCUPADA_CIRCULO;
			else
				tablero.getTablero()[x][y] = Casilla.OCUPADA_CRUZ;
			cambiarTurno();
		}else{
			System.out.println("NO PUEDES COLOCAR LA FICHA AHÍ");
		}
		
		tablero.mostrarTablero();
	}
	
	
	/**
	 * Cambia de turno cada jugada
	 */
	public void cambiarTurno() {
		if (turno) {
			turno = false;
			fichaTurno = Ficha.CRUZ;
		} else {
			turno = true;
			fichaTurno = Ficha.CIRCULO;
		}

	}
	
	public static void main(String[] args) {
		new Partida().iniciar();
	}

}
