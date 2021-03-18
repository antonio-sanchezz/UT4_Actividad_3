package gestenis;

import java.io.*;
import java.util.ArrayList;


public class Torneo  {
	
	//No usado:
    public static String GRAND_SLAM = "Grand Slam";
    public static String MASTER1000 = "ATP World Tour Master 1000";
    public static String MASTER500 = "ATP World Tour 500";
    public static String MASTER250 = "ATP World Tour 250";
    
    private String nombreTor;
    private int punt;
    
    Torneo (String nombreTor,int punt){
        this.nombreTor=nombreTor;
        this.punt=punt;
    }

    /**
     * Devuelve el nombre del torneo
     * @return
     */
    public String getNombreTor() {
        return nombreTor;
    }

    /**
     * Asignamos un nombre de torneo
     * @param nombreTor del torneo
     */
    public void setNombreTor(String nombreTor) {
        this.nombreTor = nombreTor;
    }

    /**
     * Devuelve la puntuación asignada al torneo
     * @return
     */
    public int getPunt() {
        return punt;
    }

    /**
     * Introducimos la puntuación asignada para el torneo
     * @param
     */
    public void setPunt(int punt) {
        this.punt = punt;
    }
    /**
     * Carga los datos del fichero en el ArrayList lista
     * y devuelve true si todo ha ido bien o false si ha fallado algo
     * @param fichero
     * @return
     */
    public static ArrayList<Torneo> cargar(File fichero){
        ArrayList<Torneo> lista = null;
        try{
        	lista = new ArrayList<Torneo>();
            ObjectInputStream ficheroEntrada = null;
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
            ficheroEntrada.close();
            return lista;
        }catch(ClassNotFoundException cnfe){
            return null;
        }catch(FileNotFoundException fnfe){
            return null;
        }catch (IOException ioe){
            return null;
        }
    }
    /**
     * Guarda los datos del ArrayList lista en el fichero fichero
     * Si todo ha ido bien devuelve true y en caso contrario false 
     * @param lista
     * @param fichero
     * @return
     */
    public static boolean guardar(ArrayList<Torneo> lista,File fichero){
        try{
        	//Fichero de salida
            ObjectOutputStream sal = null; 
            sal = new ObjectOutputStream(new FileOutputStream (fichero));
            sal.writeObject(lista);
            sal.flush();
            sal.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
    
    /**
     * Carga los datos del fichero en el ArrayList lista, luego guarda los datos del ArrayList lista en el fichero fichero
     * Si todo ha ido bien devuelve true y en caso contrario false.
     * @param lista
     * @param fichero
     * @return
     */
    public static boolean cargarYGuardar(ArrayList<Torneo> lista, File fichero){
        
    	//cargar
        try{
            ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
            ficheroEntrada.close();

        }catch(ClassNotFoundException cnfe){
            return false;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch (IOException ioe){
            return false;
        }
        
        //guardar
    	try{
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream (fichero));
            ficheroSalida.writeObject(lista);
            ficheroSalida.flush();
            ficheroSalida.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
}