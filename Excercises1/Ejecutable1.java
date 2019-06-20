
/**
 * Write a description of class Ejecutable1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Ejecutable1
{
    public static void main()
    {
        Scanner teclado = new Scanner(System.in);
        int var = 0;
        System.out.println("Crear un punto:\nIngrese X:");
        double x = Double.parseDouble(teclado.next());
        System.out.println("Ingrese Y:");
        double y = Double.parseDouble(teclado.next());
        Punto p = new Punto (x,y);
        do{
            System.out.println("1-Deplazar Punto \n2-Mostrar Punto \n3-GetCoordenadas \n0-Para Salir");
            var = teclado.nextInt();
            switch(var)
            {
                case 1:
                    System.out.println("Ingrese X:");
                    double dx = Double.parseDouble(teclado.next());
                    System.out.println("Ingrese Y:");
                    double dy = Double.parseDouble(teclado.next());
                    p.desplazar(dx,dy);
                    break;
                case 2:
                    p.mostrar();
                    break;
                case 3:
                    System.out.println("Mostrando coordenadas ...\n" + p.coordenadas());
                    break;
            }
        } while(var != 0);
    }

    
}
