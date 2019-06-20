
/**
 * Ejemplo de herencia, clase hija 
 */
//Código de la clase profesor, subclase de la clase Persona 

public class Profesor extends Persona {

    //Campos específicos de la subclase.

    private String IdProfesor;

    //Constructor de la subclase: incluimos como parámetros al menos los del constructor de la superclase

    public Profesor (String nombre, String apellidos, int edad) {

        super(nombre, apellidos, edad);

        IdProfesor = "Unknown";  
    } //Cierre del constructor

    //Métodos específicos de la subclase

    public void setIdProfesor (String IdProfesor) { 
        this.IdProfesor = IdProfesor;  
    }

    public String getIdProfesor () {
        return IdProfesor;  
    }
    
    // editamos el metodo mostrar de persona
    @Override
    public void mostrar() {

        // nombre = "Paco"; Si tratáramos de acceder directamente a un campo privado de la superclase, salta un error

        // Sí podemos acceder a variables de instancia a través de los métodos de acceso públicos de la superclase

        System.out.println ("nombre del Profesor: " + getNombre() + " " +  getApellidos() +

         " Id : " + getIdProfesor() );
        }

} //Cierre de la clase
