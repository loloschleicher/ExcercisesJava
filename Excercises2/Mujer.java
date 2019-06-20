
/**
 * Write a description of class Mujer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Mujer {
    private String nombre;
    private String apellido; 
    private Calendar fechaNacio;
    private String estadoCivil;
    private Hombre esposo;

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

    public Hombre getEsposo() {
        return esposo;
    }

    private void setEsposo(Hombre esposo) {
        this.esposo = esposo;
    }
    
    
    
    public Mujer(String pNom, String pApe, Calendar pFN, String pEC, Hombre pEsposo){
        this.setNombre(pNom);
        this.setApellido(pApe);
        this.setFechaNacio(pFN);
        this.casarseCon(pEsposo);
    }
    public Mujer(String pNom, String pApe, Calendar pFN){
        this.setNombre(pNom);
        this.setApellido(pApe);
        this.setFechaNacio(pFN);
        this.setEstadoCivil("Soltera");
    }
    public void casarseCon(Hombre pEsposo){
        if(this.getEsposo() == null){
            this.setEsposo(pEsposo);
            this.setEstadoCivil("Casada");
        }
    }
    public void divorcio(){
        if(this.getEsposo() != null){
            this.setEsposo(null);
            this.setEstadoCivil("Divorciada");
        }
    }
    public String datos(){
        return this.getNombre()+ " "+this.getApellido()+" de "+ this.edad()+ " años";
    }
    public void mostrarEstadoCivil(){
        System.out.println(this.datos()+" - "+ this.getEstadoCivil());
    }
    public void casadaCon(){
        if(this.getEsposo() != null)
            System.out.println(this.datos()+" está casada con "+ this.getEsposo().datos());
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