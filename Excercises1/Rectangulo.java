
/**
 * Write a description of class Rectangulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.text.*;
public class Rectangulo
{
    // instance variables - replace the example below with your own
    private Punto origen;
    private double ancho;
    private double alto;
    
    /*
     * GETTERS && SETTERS
     */
    private void setAncho(double pAncho)
    {
        ancho = pAncho;
    }
    private void setAlto(double pAlto)
    {
        this.alto = pAlto;
    }
    private void setOrigen(Punto pOrigen)
    {
        this.origen = pOrigen;
    }
    public double getAncho()
    {
        return this.ancho;
    }
    private double getAlto()
    {
        return this.alto;
    }
    public Punto getOrigen()
    {
        return this.origen;
    }

    /**
     * Constructor for objects of class Rectangulo
     */
    public Rectangulo(double pAncho, double pAlto)
    {
        // initialise instance variables
        this.setOrigen(new Punto());
        this.setAncho(pAncho);
        this.setAlto(pAlto);
    }
    public Rectangulo(Punto pOrigen, double pAncho, double pAlto)
    {
        // initialise instance variables
        this.setOrigen(pOrigen);
        this.setAncho(pAncho);
        this.setAlto(pAlto);
    }

    public void desplazar(double px, double py)
    {
        this.getOrigen().desplazar(px, py);
    }
    
    /**
     * El método características retorna una cadena con las características del objeto, según el
     * siguiente ejemplo: Origen: (2.0, 3.5) - Alto: 20.0 - Ancho: 5.55
     */
    public String caracteristicas()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Origen: " + this.getOrigen().coordenadas() + " - Alto: " + df.format(this.getAlto())+ " - Ancho: " + df.format(this.getAncho());
    }
    
    public double perimetro()
    {
        return  2* this.getAlto() +  2 *this.getAncho();
    }
    
    public double superficie()
    {
        return this.getAlto() * this.getAncho();
    }
    
    public double distanciaA(Rectangulo otroRectangulo)
    {
        return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
    }
    
    public Rectangulo elMayor(Rectangulo otroRectangulo)
    {
        return (this.superficie() > otroRectangulo.superficie() ?  this : otroRectangulo);
    }
    
    /**
     * El método mostrar() tendrá la siguiente salida impresa:
     *  ****** Rectangulo ******
     *  Origen: (2.0, 3.5) - Alto: 20.0 - Ancho: 5.55
     *  Superficie: 1256.64 - Perímetro: 125.66 
     */
    public void mostrar()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("****** Rectangulo ******");
        System.out.println(caracteristicas());
        System.out.println("Superficie: " + df.format(this.superficie()) + " - Perímetro: " + df.format(this.perimetro()));
    }
}
