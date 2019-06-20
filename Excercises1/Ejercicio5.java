
/**
 * Write a description of class Ejercicio5 here.
 * 
 * @author Augusto Portillo 
 * @version (a version number or a date)
 */
public class Ejercicio5
{
    public static void main() {
        System.out.println("Creando Persona...");
        Persona p1 = new Persona(36194082, "Augusto", "Portillo");//(int dni,String nombre, String apellido)
        System.out.println("------------------------");
        p1.mostrarDatos();
        System.out.println("------------------------");
        System.out.println("Creando Cuenta Bancaria...");
        CuentaBancaria cb1 = new CuentaBancaria(123456,p1);//(int pNro, Persona pTitular)
        System.out.println("------------------------");
        cb1.mostrar();
        System.out.println("------------------------");
        System.out.println("Depositando $1500.99");
        cb1.depositar(1500.99);
        System.out.println("------------------------");
        cb1.mostrar();
        System.out.println("------------------------");
        System.out.println("Depositando $-1500.99");
        cb1.depositar(-1500.99);
        System.out.println("------------------------");
        System.out.println("Extrayendo $30000");
        cb1.extraer(30000);
        System.out.println("------------------------");
        System.out.println("Extrayendo $500.99");
        cb1.extraer(500.99);
        System.out.println("------------------------");
        cb1.mostrar();
        System.out.println("----------- Fin de la Transaccion -----------");
        
        

    }
}
