
/**
 * Write a description of class Ejercicio4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Ejercicio4
{
    public static void main() {
        Calendar fechaNacD1 = new GregorianCalendar(1991,03,15);
        System.out.println("Creando Director...");
        Director d1 = new Director("Augusto","Portillo", fechaNacD1);
        System.out.println("------------------------");
        d1.mostrar();
        System.out.println("------------------------");
        System.out.println("Edad del Director: " + d1.edad() + " años");
        System.out.println("------------------------");
        System.out.println("Creando Pelicula con Director y Fecha de estreno...");
        Calendar fechaEstrenoP1 = new GregorianCalendar(2010, 9 ,15);
        Pelicula p1 = new Pelicula("The Engineer's life", d1,fechaEstrenoP1, "Drama/Comedy",143);//(String pNom, Director pDir, Calendar pFecha, String pGen, int pDura)
        System.out.println("------------------------");
        p1.mostrar();
        System.out.println("------------------------");
        System.out.println("Antiguedad de la pelicula: " + p1.antiguedad() + " años");
        System.out.println("------------------------\n\n");
        System.out.println("------------------------");
        System.out.println("Creando Pelicula sin Director y sin Fecha...");
        Pelicula p2 = new Pelicula("Robots al ataque",2015, "Drama/Comedy");//(String pNom, Director pDir, Calendar pFecha, String pGen, int pDura)
        System.out.println("------------------------");
        p2.mostrar();
        System.out.println("------------------------");
        System.out.println("Antiguedad de la pelicula: " + p2.antiguedad() + " años");
        System.out.println("------------------------\n\n");

    }
}
