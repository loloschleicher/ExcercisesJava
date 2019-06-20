
/**
 * Ejemplo de herencia
 */
// clase padre
public class Persona
{
    private String nombre;

    private String apellidos;

    private int edad;

    //Constructor

    public Persona (String nombre, String apellidos, int edad) {

        this.nombre = nombre;

        this.apellidos = apellidos;

        this.edad = edad;  
    }

    //Métodos

    public String getNombre () { 
      return nombre; 
    }

    public String getApellidos () {
        return apellidos; 
    }
    
    // metodo en estado polimosfico con el de profesor 
    public void mostrar(){
        System.out.println( this.getNombre () + " "+ this.getApellidos ());
    }
    
    public int getEdad () { return edad;   }

} //Cierre de la clase

