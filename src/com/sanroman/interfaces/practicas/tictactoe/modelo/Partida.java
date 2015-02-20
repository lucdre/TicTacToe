package com.sanroman.interfaces.practicas.tictactoe.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.sanroman.interfaces.practicas.tictactoe.vista.PanelMensajes;

/**
 * Lógica principal del juego, controla el transcurso de la partida.
 * 
 * @author Luca Thiel (Lucdre)
 *
 */
public class Partida {
	
	//De quien es el turno, true - circulo, false - X
	private boolean turno; 
	private Ficha fichaTurno;
		
	private ArrayList<Observador> observ;
	
	private Tablero tablero;
	
	/**
	 * Inicializa un {@link Tablero} y la lista de {@link Observador}es.
	 */
	public Partida() {
		tablero = new Tablero();
		observ = new ArrayList<Observador>();
	}
	
	/**
	 * Busca si hay 3 en raya.
	 * Recorre el {@link Tablero} en horizontal, {@link Tablero} vertical, y las 2 diagonales en busca de 3 {@link Casilla}s iguales.
	 * @return <code>Boolean</code> - si ha encontrado ganador o no.
	 */
	public boolean buscarGanador() {
		
		Casilla[][] tab = tablero.getTablero();
		int tam = getTam();
		int cont = 0;
		
		//horizontal
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if(!turno){
					if(tab[i][j] == Casilla.OCUPADA_CIRCULO)
						cont++;
				}
				else if(turno)
					if(tab[i][j] == Casilla.OCUPADA_CRUZ)
						cont++;
			}
			if(cont!=3)
				cont = 0;
			else return true;
		}
		
		//vertical
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if(!turno){
					if(tab[j][i] == Casilla.OCUPADA_CIRCULO)
						cont++;
				}
				else if(turno)
					if(tab[j][i] == Casilla.OCUPADA_CRUZ)
						cont++;
			}
			if(cont!=3)
				cont = 0;
			else return true;
		}
		
		//Diagonal 1
		for (int j = 0; j < tam; j++) {
			if (!turno) {
				if (tab[j][j] == Casilla.OCUPADA_CIRCULO)
					cont++;
			} else if (turno)
				if (tab[j][j] == Casilla.OCUPADA_CRUZ)
					cont++;
		}
		if (cont != 3)
			cont = 0;
		else
			return true;
		
		//Diagonal 2
		int n=tab.length-1;
		 for (int i = 0; i < tab.length; i++) {
			 if (!turno) {
					if (tab[n-i][i] == Casilla.OCUPADA_CIRCULO)
						cont++;
				} else if (turno)
					if (tab[n-i][i] == Casilla.OCUPADA_CRUZ)
						cont++;
		}
		 if (cont != 3)
				cont = 0;
			else
				return true;
		 
		return false;	
	}
	
	/**
	 * Busca si la {@link Partida} ha empatado (tablero lleno).
	 */
	public void buscarEmpate(){
		
		Casilla[][] tab = tablero.getTablero();
		int tam = tab.length;
		boolean empate = true;
		
		for (int i = 0; i < tam; i++)
			for (int j = 0; j < tam; j++)
				if (tab[i][j] == Casilla.VACIO)
					empate = false;

		if(empate)
			for (Observador obs : observ) 
				obs.finPartida(0);
	}
	
	/**
	 * Ajustes necesarios al iniciar la {@link Partida}.
	 */
	public void iniciar(){
		Random rnd = new Random();
		turno = rnd.nextBoolean();
		cambiarTurno();
		if(fichaTurno == Ficha.CRUZ) PanelMensajes.startMsg("CRUZ");
		else PanelMensajes.startMsg("CÍRCULO");
		
		for (Observador obs : observ) {
			obs.iniciarPartida();
		}	
	}
	
	/**
	 * Coloca la {@link Ficha} en el {@link Tablero} si no hay ninguna colocada ya.
	 * @param x - Alto del tablero
	 * @param y - Ancho del tablero
	 */
	public void colocarFicha(int x, int y){
		boolean colocada = true;
		if(tablero.getTablero()[x][y] == Casilla.VACIO){
			if(fichaTurno == Ficha.CIRCULO)
				tablero.getTablero()[x][y] = Casilla.OCUPADA_CIRCULO;
			else
				tablero.getTablero()[x][y] = Casilla.OCUPADA_CRUZ;
			cambiarTurno();
		}else
			colocada = false;
		
		if(colocada)
			for (Observador obs : observ) {
				obs.finalizaTurno(x, y, turno);
			}
		
		if(buscarGanador()){
			for (Observador obs : observ){
				if(!turno)
					obs.finPartida(1);
				else
					obs.finPartida(2);
			}
		}
		else
			buscarEmpate();				
	}
	
	
	/**
	 * Cambia de turno cada vez que se mueve una {@link Ficha}.
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
	
	/**
	 * Resettea el {@link Tablero}.
	 */
	public void reset(){
		tablero = new Tablero();
		for (Observador obs : observ) {
			obs.resetPartida();
		}
	}
	
	/**
	 * Añade un observador.
	 * @param o - el observador que se quiere añadir.
	 */
	public void addObserv(Observador o){
		observ.add(o);
	}

	/**
	 * Devuelve el turno en forma de {@link Ficha}.
	 * @return {@link Ficha} - el turno.
	 */
	public Ficha getTurno() {
		return fichaTurno;	
	}

	/**
	 * Devuelve el {@link Tablero} en formato array, cada linea es una posición del {@link Tablero} y de que color es la {@link Ficha}.
	 * Si no hay ficha, está libre.
	 * 
	 * @return un array de String con la posición del {@link Tablero} y la {@link Ficha} que ocupa.
	 */
	public String[] getTablero() {
		int tam = getTam();
		String[] linea = new String[tam*tam];
		int l=0;
		String color = "";
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				//ESTOS 3 IF SOBRAN SI NO TENDRÍA QUE ADAPTARLO A COLORES EN VEZ DE DEJARLO CON EL TIPO DE FICHA
				if(tablero.getTablero()[i][j]==Casilla.OCUPADA_CIRCULO)
					color = "NEGRO";
				else if(tablero.getTablero()[i][j]==Casilla.OCUPADA_CRUZ)
					color = "ROJO";
				else if (tablero.getTablero()[i][j]==Casilla.VACIO)
					color = tablero.getTablero()[i][j].toString();
				linea[l] = i + " " + j + " " + color;
				l++;
			}
		}
		return linea;
	}

	/**
	 * Devuelve el tamaño del {@link Tablero}.
	 * 
	 * @return el tamaño de una linea {@link Tablero} (por defecto 3).
	 */
	public int getTam() {
		return tablero.getTablero().length;
	}
	
	/**
	 * Método para guardar la {@link Partida} en un fichero de texto.
	 * Tendrá esta estructura:
	 * 		- Primera línea: El turno actual.
	 * 		- Las demás líneas: 
	 * 			- Primer dato: Alto del {@link Tablero}.	
	 *			- Segundo dato: Ancho del {@link Tablero}.
	 *			- Tercer dato: {@link Ficha} que ocupa las posiciones en las coordenadas anteriormente dichas, o si está libre,
	 * 
	 * @param fileName - El nombre del archivo (Sin incluir extensión, por defecto se guarda en .txt).
	 */
	public void guardar(String fileName) {
		String[] tablero = getTablero();
		String turno = "";
		FileWriter fw = null;
		if (getTurno() == Ficha.CIRCULO) {
			turno = "NEGRO";
		} else {
			turno = "ROJO";
		}

		try {
			fw = new FileWriter(fileName);
			fw.write(turno + "\r\n");
			for (int i = 0; i < getTam() * getTam(); i++) {
				fw.write(tablero[i] + "\r\n");
			}

		} catch (IOException e) {
			PanelMensajes.errorMsg(0);
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e1) {
				PanelMensajes.errorMsg(0);
			}
		}
	}

	/**
	 * Carga la {@link Partida} del fichero del parámetro.
	 * 
	 * @param selectedFile - En fichero que se va a cargar.
	 */
	public void cargar(File selectedFile) {
		BufferedReader in = null;
		String[] lineas = null;
		boolean seguirComprobando = true;
		try {
			in = new BufferedReader(new FileReader(selectedFile));
			lineas = new String[1+(getTam()*getTam())]; //Por defecto 10 líneas, 1 del turno y 3*3 del tablero
			String line = null;
			int i=0; //contador
			while((line=in.readLine()) != null && seguirComprobando){
				try{
					lineas[i] = line.trim();
					i++;
				}catch(ArrayIndexOutOfBoundsException e){
					PanelMensajes.errorMsg(3);
					seguirComprobando = false;
				}
			}
		} catch (FileNotFoundException e) {
			PanelMensajes.errorMsg(1);
		} catch (IOException e) {
			PanelMensajes.errorMsg(0);
		}finally{
			try {
				if(in!=null)
					in.close();
			} catch (IOException e) {
				PanelMensajes.errorMsg(0);
			}
		}
		
		if(seguirComprobando){
			comprobarArchivo(lineas);			
		}
	}

	/**
	 * Método necesario para comprobar si los datos cargados del ficheros son válidos o no.
	 * 
	 * @param lineas - Los datos cargados del fichero
	 * @return <code>Boolean</code> - True si son válidos, False si no son válidos.
	 */
	private boolean comprobarArchivo(String[] lineas) {
		// Comprueba que se ha pasado algo, lineas no es null.
		if (lineas == null) {
			PanelMensajes.errorMsg(2);
			return false;
		}
		// Comprueba que lineas tenga el número de líneas que debe tener.
		for (int i = 0; i < 1 + (getTam() * getTam()); i++) {
			if (lineas[i] == null) {
				PanelMensajes.errorMsg(2);
				return false;
			}
		}
		
		for (Observador obs : observ) {
			obs.iniciarPartida();
		}
		String[] resul;
		int conRojas = 0;
		int contNegras = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < lineas.length; i++) {
			resul = lineas[i].split(" ");
			// Primera linea, comprueba que solo esté el turno.
			if (i == 0) {
				switch (resul[0]) {
				case "ROJO":
					turno = false;
					fichaTurno = Ficha.CRUZ;
					break;
				case "NEGRO":
					turno = true;
					fichaTurno = Ficha.CIRCULO;
					break;
				default:
					PanelMensajes.errorMsg(3);
					return false;
				}
			}
			else{
				//Comprobación fichas correctas (solo rojo, negra y libre).
				x = Integer.valueOf(resul[0]);
				y = Integer.valueOf(resul[1]);
				switch(resul[2]){
				case "NEGRO":
					contNegras++;
					for (Observador obs : observ) {
						obs.finalizaTurno(x, y, false);
					}
					break;
				case "ROJO":
					conRojas++;
					for (Observador obs : observ) {
						obs.finalizaTurno(x, y, true);
					}
					break;
				case "VACIO":
					tablero.getTablero()[x][y]=Casilla.VACIO;
					break;
				default:
					PanelMensajes.errorMsg(3);
					reset();
					return false;
				}
			}	
		}
		//comprobacion fichas correctas (no puede haber 3 fichas negras y una roja por ejemplo).
		if(contNegras-conRojas>1 || conRojas-contNegras>1){
			PanelMensajes.errorMsg(3);
			reset();
			return false;
		}
		return true;
	}
}


