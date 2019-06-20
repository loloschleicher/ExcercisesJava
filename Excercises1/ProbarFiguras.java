
/**
 * Write a description of class ProbarFiguras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ProbarFiguras
{
    // instance variables - replace the example below with your own
    public static void main()
    {
        Scanner teclado = new Scanner(System.in);
        int var = 0;
        
        do{
            System.out.println("1-Trabajar con circulos \n2-Trabajar con Rectangulos \n0-Para Salir");
            var = teclado.nextInt();
            switch(var)
            {
                case 1:
                    tratarCirculos();
                    break;
                case 2:
                    break;
                
            }
        } while(var != 0);
    }
    
    public static void tratarRectangulos()
    {
        Scanner tec = new Scanner(System.in);
        Rectangulo r1= new Rectangulo(0,0), r2= new Rectangulo(0,0);
        int var = 0;
        int aux = 0;
        double alto = 0;
        double ancho = 0;
        double px = 0;
        double py = 0;
        do{
            System.out.println("1-Iniciar Rectangulo \n2-Mostrar \n3-Desplazar \n4-Distancia A \n5-El Mayor \n0-Para Salir");
            var = tec.nextInt();
            aux = 0;
            switch(var)
            {
                case 1: //Iniciar Circulo
                    System.out.println("|_1-Rectangulo 1 \n|_2-Rectangulo 2");
                    System.out.print("|_");
                    aux = tec.nextInt();
                    System.out.print("  |_Alto: ");
                    alto = Double.parseDouble(tec.next());
                    System.out.print("  |_Ancho: ");
                    ancho = Double.parseDouble(tec.next());
                    System.out.print("\n  |_Px: ");
                    px = Double.parseDouble(tec.next());
                    System.out.print("\n  |_Py: ");
                    py = Double.parseDouble(tec.next());
                    if(aux ==1)
                    {
                        r1 = new Rectangulo(new Punto(px, py), ancho, alto);
                    }else if (aux ==2){
                        r2 = new Rectangulo(new Punto(px, py), ancho, alto);
                    }
                    break;
                case 2: //Mostrar
                    System.out.println("|_1-Rectangulo 1 \n|_2-Rectangulo 2");
                    System.out.print("|_");
                    aux = tec.nextInt();
                     if(aux ==1)
                    {
                        r1.mostrar();
                    }else if (aux ==2){
                        r2.mostrar();
                    }
                    break;
                case 3: //Desplazar
                    System.out.println("|_1-Rectangulo 1 \n|_2-Rectangulo 2");
                    aux = tec.nextInt();
                    System.out.print("  |_Px: ");
                    px = Double.parseDouble(tec.next());
                    System.out.print("\n  |_Py: ");
                    py = Double.parseDouble(tec.next());
                    if(aux ==1)
                    {
                        r1.desplazar(px,py);
                    }else if (aux ==2){
                        r2.desplazar(px,py);
                    }
                    break;
                case 4: //Distancia
                    System.out.println("|_La distancia que existe entre ambos rectangulos es: " + r1.distanciaA(r2));
                    break;
                case 5: //ElMayor
                    Rectangulo m = r1.elMayor(r2);
                    System.out.println("|_El Mayor de ambos rectangulos es: " + m);
                    break;
            }
            System.out.println("---------------------------------------------------------------");
        } while(var != 0);
    }
    
    public static void tratarCirculos()
    {
        Scanner tec = new Scanner(System.in);
        Circulo c1= new Circulo(), c2= new Circulo();
        int var = 0;
        int aux = 0;
        double r = 0;
        double px = 0;
        double py = 0;
        do{
            System.out.println("1-Iniciar Circulo \n2-Mostrar \n3-Desplazar \n4-Distancia A \n5-El Mayor \n0-Para Salir");
            var = tec.nextInt();
            aux = 0;
            switch(var)
            {
                case 1: //Iniciar Circulo
                    System.out.println("|_1-Circulo 1 \n|_2-Circulo 2");
                    System.out.print("|_");
                    aux = tec.nextInt();
                    System.out.print("  |_Radio: ");
                    r = Double.parseDouble(tec.next());
                    System.out.print("\n  |_Px: ");
                    px = Double.parseDouble(tec.next());
                    System.out.print("\n  |_Py: ");
                    py = Double.parseDouble(tec.next());
                    if(aux ==1)
                    {
                        c1 = new Circulo( r, new Punto(px, py));
                    }else if (aux ==2){
                        c2 = new Circulo(r, new Punto(px,py));
                    }
                    break;
                case 2: //Mostrar
                    System.out.println("|_1-Circulo 1 \n|_2-Circulo 2");
                    System.out.print("|_");
                    aux = tec.nextInt();
                     if(aux ==1)
                    {
                        c1.mostrar();
                    }else if (aux ==2){
                        c2.mostrar();
                    }
                    break;
                case 3: //Desplazar
                    System.out.println("|_1-Circulo 1 \n|_2-Circulo 2");
                    System.out.print("|_");
                    aux = tec.nextInt();
                    System.out.print("  |_Px: ");
                    px = Double.parseDouble(tec.next());
                    System.out.print("\n  |_Py: ");
                    py = Double.parseDouble(tec.next());
                    if(aux ==1)
                    {
                        c1.desplazar(px,py);
                    }else if (aux ==2){
                        c2.desplazar(px,py);
                    }
                    break;
                case 4: //Distancia
                    System.out.println("|_La distancia que existe entre ambos circulos es: " + c1.distanciaA(c2));
                    break;
                case 5: //ElMayor
                    System.out.println("|_El Mayor de ambos circulos es: ");
                    c1.elMayor(c2).mostrar();
                    break;
            }
            System.out.println("---------------------------------------------------------------");
        } while(var != 0);
    }
}
