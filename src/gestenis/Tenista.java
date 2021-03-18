package gestenis;

import java.io.*;
import java.util.ArrayList;

/**
 * Esta clase nos permite obtener y asociar datos acerca de los tenistas
 * registrados en una competicion.
 * 
 * @author Antonio Sanchez
 *
 */
public class Tenista {
	private String nombre;
	private int edad;
	private ArrayList<Torneo> palmares;

	/**
	 * Constructor para introducir un nuevo tenista.
	 * 
	 * @param nombre del tenista
	 * @param edad   del tenista
	 */
	Tenista(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		// lista de torneos
		palmares = new ArrayList<Torneo>();
	}

	/**
	 * Obtenemos el nombre del tenista
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asignamos el nombre del tenista
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Nos devuelve la edad del tenista
	 * 
	 * @return la edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Asigna la edad del tenista
	 * 
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/*
	 * Devuelve el palmares con los nombres de los torneos ganados
	 * 
	 * @return
	 */
	public String[] getPalmares() {
		String[] p = new String[palmares.size()];
		for (int i = 0; i < p.length; i++) {
			p[i] = palmares.get(i).getNombreTorneo();
		}
		return p;
	}

	/**
	 * Añade el torneo ganado al palmares
	 * 
	 * @param torneo objeto torneo
	 */
	public void aniadirPalmares(Torneo torneo) {
		palmares.add(torneo);
	}

	/**
	 * Recorre un bucle acumulando la puntuación obtenida.
	 * 
	 * @return p - puntacion obtenida de los torneos
	 */
	public int getPuntuacionATP() {
		int p = 0;
		for (Torneo t : palmares) {
			p += t.getPuntuacion();
		}
		return p;
	}

	/**
	 * Carga el archivo seleccionado e introduce sus datos en el ArrayList Tenista y
	 * devuelve la lista con los tenista.
	 * 
	 * @param fichero - fichero que cargamos
	 * @return l - lista de los tenistas
	 */
	public static ArrayList<Tenista> cargar(File fichero) {
		ArrayList<Tenista> l = null;
		ObjectInputStream ficheroEntrada = null;
		try {
			ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			l = (ArrayList<Tenista>) ficheroEntrada.readObject();
			ficheroEntrada.close();
		} catch (ClassNotFoundException onfe) {
			l = null;
		} catch (FileNotFoundException fnfe) {
			l = null;
		} catch (IOException ioe) {
			l = null;
		}
		return l;
	}

	/**
	 * Guarda en un fichero los datos de la lista de los tenistas devolviendo true
	 * si ha sido todo correcto o false en caso contrario.
	 * 
	 * @param lista   de los tenistas
	 * @param fichero donde vamos a guardar la lista
	 * @return validador - true o false
	 */
	public static boolean guardar(ArrayList<Tenista> lista, File fichero) {
		boolean validador = false;
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
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
	 * Cargar un fichero con los datos los tenistas devolviendo true si ha sido todo
	 * correcto o false en caso contrario.
	 * 
	 * @param lista   de los tenistas
	 * @param fichero de donde vamos a cargar la lista
	 * @return validador - true o false
	 */
	public static boolean cargar(ArrayList<Tenista> lista, File fichero) {
		boolean validador = false;
		ArrayList<Tenista> l = null;
		ObjectInputStream ficheroEntrada = null;
		try {
			ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			l = (ArrayList<Tenista>) ficheroEntrada.readObject();
			validador = true;
			ficheroEntrada.close();

		} catch (ClassNotFoundException onfe) {
			validador = false;
		} catch (FileNotFoundException fnfe) {
			validador = false;
		} catch (IOException ioe) {
			validador = false;
		}
		return validador;
	}
}