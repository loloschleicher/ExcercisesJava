
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Persona
{
   private String nombre;
    private String apellido; 
    private Calendar fechaNacio;
    private String estadoCivil;
    private Persona esposx;

    /* GETTERS AND SETTERS */
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Calendar getFechaNacio() {
        return fechaNacio;
    }

    private void setFechaNacio(Calendar fechaNac) {
        fechaNac.add(Calendar.MONTH,-1);
        this.fechaNacio = fechaNac;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    private void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Persona getEsposx() {
        return esposx;
    }

    private void setEsposx(Persona esposx) {
        this.esposx = esposx;
    }
    
    
    
    public Persona(String pNom, String pApe, Calendar pFN, String pEC, Persona pEsposx){
        this.setNombre(pNom);
        this.setApellido(pApe);
        this.setFechaNacio(pFN);
        this.casarseCon(pEsposx);
    }
    public Persona(String pNom, String pApe, Calendar pFN){
        this.setNombre(pNom);
        this.setApellido(pApe);
        this.setFechaNacio(pFN);
        this.setEstadoCivil("Solterx");
    }
    public void casarseCon(Persona pEsposx){
        if(this.getEsposx() == null){
            this.setEsposx(pEsposx);
            this.setEstadoCivil("Casadx");
        }
    }
    public void divorcio(){
        if(this.getEsposx() != null){
            this.setEsposx(null);
            this.setEstadoCivil("Divorciadx");
        }
    }
    public String datos(){
        return this.getNombre()+ " "+this.getApellido()+" de "+ this.edad()+ " años";
    }
    public void mostrarEstadoCivil(){
        System.out.println(this.datos()+" - "+ this.getEstadoCivil());
    }
    public void casadxCon(){
        if(this.getEsposx() != null)
            System.out.println(this.datos()+" está casadx con "+ this.getEsposx().datos());
    }
    public int edad(){
        Calendar fechaActual = new GregorianCalendar();
        int edad =  fechaActual.get(Calendar.YEAR) - this.getFechaNacio().get(Calendar.YEAR);
        if(fechaActual.get(Calendar.MONTH) < this.getFechaNacio().get(Calendar.MONTH))
        {
            return edad -1;
        }else{
            return edad;
        }
    }
}
