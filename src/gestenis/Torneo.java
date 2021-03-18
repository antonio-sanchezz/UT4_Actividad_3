package gestenis;

import java.io.*;
import java.util.ArrayList;

/**
 * Esta clase nos permite obtener y asociar datos acerca de los torneos.
 * 
 * @author Antonio Sanchez
 *
 */
public class Torneo {

	private String nombreTorneo;
	private int puntuacion;

	/**
	 * Constructor para introducir un nuevo torneo.
	 * 
	 * @param nombreTorneo - nombre del torneo
	 * @param puntuacion   del torneo
	 */
	Torneo(String nombreTorneo, int puntuacion) {
		this.nombreTorneo = nombreTorneo;
		this.puntuacion = puntuacion;
	}

	/**
	 * Devuelve el nombre del torneo
	 * 
	 * @return nombreTorneo - nombre del torneo
	 */
	public String getNombreTorneo() {
		return nombreTorneo;
	}

	/**
	 * Asignamos un nombre de torneo
	 * 
	 * @param nombreTorneo - nombre del torneo
	 */
	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}

	/**
	 * Devuelve la puntuación asignada al torneo
	 * 
	 * @return puntuacion del torneo
	 */
	public int getPuntuacion() {
		return puntuacion;
	}

	/**
	 * Introducimos la puntuación asignada para el torneo
	 * 
	 * @param puntuacion del torneo
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	/**
	 * Carga los datos del fichero en el ArrayList lista y devuelve true si todo ha
	 * ido bien o false si ha fallado algo
	 * 
	 * @param fichero que cargamos
	 * @return validador - true o false
	 */
	public static boolean cargar(File fichero) {
		boolean validador = false;
		ArrayList<Torneo> lista = null;
		try {
			lista = new ArrayList<Torneo>();
			ObjectInputStream ficheroEntrada = null;
			ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
			ficheroEntrada.close();
			validador = true;
		} catch (ClassNotFoundException cnfe) {
			validador = false;
		} catch (FileNotFoundException fnfe) {
			validador = false;
		} catch (IOException ioe) {
			validador = false;
		}
		return validador;
	}

	/**
	 * Guarda los datos del ArrayList lista en el fichero fichero Si todo ha ido
	 * bien devuelve true y en caso contrario false
	 * 
	 * @param lista   de torneos
	 * @param fichero que queremos guardar
	 * @return validador - true o false
	 */
	public static boolean guardar(ArrayList<Torneo> lista, File fichero) {
		boolean validador = false;
		try {
			// Fichero de salida
			ObjectOutputStream ficheroSalida = null;
			ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroSalida.writeObject(lista);
			ficheroSalida.flush();
			ficheroSalida.close();
			validador = true;
		} catch (FileNotFoundException fnfe) {
			validador = false;
		} catch (IOException ioe) {
			validador = false;
		}

		return validador;
	}

	/**
	 * Carga los datos del fichero en el ArrayList lista, luego guarda los datos del
	 * ArrayList lista en el fichero Si todo ha ido bien devuelve true y en caso
	 * contrario false.
	 * 
	 * @param lista   de torneo
	 * @param fichero que queremos cargar
	 * @return validador - true o false
	 */
	public static boolean cargar(ArrayList<Torneo> lista, File fichero) {
		boolean validador = false;
		// Cargar fichero.
		try {
			ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
			ficheroEntrada.close();
			validador = true;
		} catch (ClassNotFoundException cnfe) {
			validador = false;
		} catch (FileNotFoundException fnfe) {
			validador = false;
		} catch (IOException ioe) {
			validador = false;
		}
		return validador;
	}
}