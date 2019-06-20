
/**
 * Write a description of class Hombre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Hombre {
    private String nombre;
    private String apellido; 
    private Calendar fechaNacio;
    private String estadoCivil;
    private Mujer esposa;

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

    public Mujer getEsposa() {
        return esposa;
    }

    private void setEsposa(Mujer esposa) {
        this.esposa = esposa;
    }
    
    
    
    public Hombre(String pNom, String pApe, Calendar pFN, String pEC, Mujer pEsposa){
        this.setNombre(pNom);
        this.setApellido(pApe);
        this.setFechaNacio(pFN);
        this.casarseCon(pEsposa);
    }
    public Hombre(String pNom, String pApe, Calendar pFN){
        this.setNombre(pNom);
        this.setApellido(pApe);
        this.setFechaNacio(pFN);
        this.setEstadoCivil("Soltero");
    }
    public void casarseCon(Mujer pEsposa){
        if(this.getEsposa() == null){
            this.setEsposa(pEsposa);
            pEsposa.casarseCon(this);
            this.setEstadoCivil("Casado");
        }
    }
    public void divorcio(){
        if(this.getEsposa() != null){
            this.setEsposa(null);
            this.setEstadoCivil("Divorciado");
        }
    }
    public String datos(){
        return this.getNombre()+ " "+this.getApellido()+" de "+ this.edad()+ " años";
    }
    public void mostrarEstadoCivil(){
        System.out.println(this.datos()+" - "+ this.getEstadoCivil());
    }
    public void casadoCon(){
        if(this.getEsposa() != null)
            System.out.println(this.datos()+" está casado con "+ this.getEsposa().datos());
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