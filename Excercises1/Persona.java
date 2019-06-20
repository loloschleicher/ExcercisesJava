
/**
 * ********* EJERCICIO 5 *********
 * Write a description of class Persona here.
 * 
 * @author Augusto Portillo 
 * @version 1.0
 */
public class Persona
{
    // instance variables - replace the example below with your own
    private int nroDni;
    private String nombre;
    private String apellido;

    /**
     * Constructor for objects of class Persona
     */
    public Persona(int dni,String nombre, String apellido)
    {
        // initialise instance variables
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
    }
    
    private void setDni(int dni)
    {
        this.nroDni = dni;
    }
    
    private void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    private void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    
    public int getDni()
    {
        return nroDni;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getApellido()
    {
        return apellido;
    }
    
    public void mostrarDatos()
    {
        System.out.printf("Nombre y Apellido: %s \nDni: %d \n", 
                            nombreYapellido(), getDni());
    }
    
    public String nombreYapellido()
    {
        return getNombre() + " " + getApellido();
    }
}
