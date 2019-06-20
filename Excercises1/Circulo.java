
/**
 * Write a description of class Circulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.text.*;
public class Circulo
{
    // instance variables - replace the example below with your own
    private double radio;
    private Punto centro;
    
    /*
     * GETTERS && SETTERS
     */
    private void setRadio(double cRadio)
    {
        this.radio = cRadio;
    }
    private void setCentro(Punto cCentro)
    {
        this.centro = cCentro;
    }
    public double getRadio()
    {
        return this.radio;
    }
    public Punto getCentro()
    {
        return this.centro;
    }
    
    /**
     * Constructor for objects of class Circulo
     */
    public Circulo()
    {
        setCentro(new Punto());
        setRadio(0);
    }
    
    public Circulo(double cRadio, Punto cCentro)
    {
        setCentro(cCentro);
        setRadio(cRadio);
    }
    
    
    public void desplazar(double px, double py)
    {
        this.centro.desplazar(px, py);
    }
    
    
    /**
       * El método características retorna una cadena con las características del objeto, según el
       * siguiente ejemplo: Centro: (2.0, 3.5) - Radio: 20.0 
    */
    public String caracteristicas()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Centro: " + this.getCentro().coordenadas() + " - Radio: " + df.format(this.getRadio());
    }
    
    
    public double perimetro()
    {
        return 2*Math.PI*this.getRadio();
    }
    
    
    public double superficie()
    {
        return Math.PI*Math.pow(this.getRadio(),2);
    }
    
    //+dsitanciaA(otroCirculo Circulo): double
    /**
     * El método distanciaA() permita calcular la distancia entre dos círculos, que estará
     * representada por la distancia entre sus centros. 
     * */
     public double distanciaA(Circulo otroCirculo)
     {
         return this.getCentro().distanciaA(otroCirculo.getCentro());
     }
     
    /**
     * +elMayor(otroCirculo Circulo): Circulo
     * El método elMayor() indique, entre dos círculos, cual es el mayor en función del tamaño
     * de su superficie
     */
    public Circulo elMayor(Circulo otroCirculo)
    {
        return (this.superficie() > otroCirculo.superficie() ?  this : otroCirculo);
    }
    
    /**
     * El método mostrar() tendrá la siguiente salida impresa:
     *  ****** Circulo ******
     *  Centro: (2.0, 3.5) - Radio: 20.0
     *  Superficie: 1256.64 - Perímetro: 125.66 
     */
    public void mostrar()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("****** Circulo ******");
        System.out.println(caracteristicas());
        System.out.println("Superficie: " + df.format(this.superficie()) + " - Perímetro: " + df.format(this.perimetro()));
    }
}
