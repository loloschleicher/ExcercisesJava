
/**
 * Write a description of class Pelicula here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.text.*;
public class Pelicula
{
    private String nombre;
    private Calendar fechaEstreno;
    private String genero;
    private int duracion;
    private Director director;
    
    /* SETTERS */
    private void setNombre(String pNom){
        this.nombre = pNom;
    }
    private void setFechaEstreno(Calendar pFecha){
        pFecha.add(Calendar.MONTH,-1);
        this.fechaEstreno = pFecha;
    }
    private void setGenero(String pGen){
        this.genero = pGen;
    }
    private void setDuracion(int pDura){
        this.duracion = pDura;
    }
    private void setDirector(Director pDir){
        this.director = pDir;
    }
    /* GETTERS */
    public String getNombre(){
        return this.nombre;
    }
    public Calendar getFechaEstreno(){
        return this.fechaEstreno;
    }
    public String getGenero(){
        return this.genero;
    }
    public int getDuracion(){
        return this.duracion;
    }
    public Director getDirector(){
        return this.director;
    }
    /* CONSTRUCTOR */
    public Pelicula(String pNom, Director pDir, Calendar pFecha, String pGen, int pDura){
        this.setNombre(pNom);
        this.setDirector(pDir);
        this.setFechaEstreno(pFecha);
        this.setGenero(pGen);
        this.setDuracion(pDura);
    }
    public Pelicula(String pNom, int pAnioEstreno, String pGen){
        this.setNombre(pNom);
        this.setFechaEstreno(new GregorianCalendar(pAnioEstreno,01,01));
        this.setGenero(pGen);
        this.setDuracion(0);
    }

    /**
     * El método cambiarFechaEstreno(int) actualiza el valor de la fecha de estreno, a
     * partir del año recibido como parámetro y considerando día 01 y mes enero.
     */
    public void cambiarFechaEstreno(int pAnioEstreno){
        this.setFechaEstreno(new GregorianCalendar(pAnioEstreno,01,01));
    }
    public int anioEstreno(){
        return getFechaEstreno().get(Calendar.YEAR);
    }
    public int antiguedad(){
        Calendar fechaActual = new GregorianCalendar();
        int ant =  fechaActual.get(Calendar.YEAR) - getFechaEstreno().get(Calendar.YEAR);
        if(fechaActual.get(Calendar.MONTH) < getFechaEstreno().get(Calendar.MONTH))
        {
            return ant -1;
        }else{
            return ant;
        }
    }
    /**
     * El método mostrar() presenta la siguiente salida por pantalla:
     *      Película: Los Vengadores
     *      Director: Joss Whedon
     *      Estreno: 2012 - Genero: Ciencia ficción
     *      Duración: 143 minutos.
     */
    public void mostrar(){
        System.out.println("Pelicula: " + getNombre());
        if (getDirector() != null) {
            System.out.println("Director: " + getDirector().nomYape());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("Estreno: %s - Genero: %s \n", sdf.format(getFechaEstreno().getTime()), getGenero());
        if (getDuracion() == 0) {
            System.out.println("Duracion: No tiene duracion definida.");
        }else{
            System.out.printf("Duracion: %s minutos.\n", getDuracion() );
        }
    }
}
