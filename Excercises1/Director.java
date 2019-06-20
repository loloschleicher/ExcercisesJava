
/**
 * Write a description of class Director here.
 * 
 * @author Augusto Portillo 
 * @version (a version number or a date)
 */
import java.util.*;
import java.text.*;
public class Director
{
    private String nombre;
    private String apellido;
    private Calendar fechaNacio;

    /* SETTERS */
    private void setNombre(String pNom) {
        this.nombre = pNom;
    }
    private void setApellido(String pApe) {
        this.apellido = pApe;
    }
    private void setFechaNacio(Calendar pFecha) {
        pFecha.add(Calendar.MONTH,-1);
        this.fechaNacio = pFecha;
    }
    /* GETTERS */
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public Calendar getFechaNacio() {
        return this.fechaNacio;
    }
    /* CONSTRUCTOR */
    public Director(String pNom, String pApe, Calendar pFecha) {
        setNombre(pNom);
        setApellido(pApe);
        setFechaNacio(pFecha);
    }
    public String nomYape(){
        return getNombre() + " " + getApellido();
    }
    public String apeYnom(){
        return getApellido() + ", " + getNombre();
    }
    public int edad(){
        Calendar fechaActual = new GregorianCalendar();
        int edad =  fechaActual.get(Calendar.YEAR) - getFechaNacio().get(Calendar.YEAR);
        if(fechaActual.get(Calendar.MONTH) < getFechaNacio().get(Calendar.MONTH))
        {
            return edad -1;
        }else{
            return edad;
        }
    }
    public void mostrar(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Director: " + nomYape());
        System.out.println("Fecha de Nacimiento: " + sdf.format(getFechaNacio().getTime()));
    }
}
