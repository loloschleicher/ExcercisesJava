
/**
 * Write a description of class Punto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.text.*;
public class Punto
{
    // instance variables - replace the example below with your own
    public double x;
    private double y;

    /**
     * GETTERS && SETTERS
       */
    private void setX(double pX)
    {
        this.x = pX;
    }
    private void setY(double pY)
    {
        this.y = pY;
    }
    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }
      
    /**
     * Constructor for objects of class Punto
     */
    public Punto(double pX, double pY)
    {
        this.setX(pX);
        this.setY(pY);
    }
    public Punto()
    {
        this.setX(0);
        this.setY(0);
    }

    public void desplazar(double pX, double pY)
    {
        this.setX(getX() + pX);
        this.setY(getY() + pY);
    }
    public String coordenadas ()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        return "("+ df.format(this.getX())+","+ df.format(getY())+")";
    }
    public void mostrar()
    {
        System.out.println("Punto. X: "+this.getX()+", Y: "+getY());
    }
    
    public double distanciaA(Punto ptoDistante)
    {
        double dx = Math.pow((ptoDistante.getX() - this.getX()),2);
        double dy = Math.pow((ptoDistante.getY() - this.getY()),2);
        
        return Math.sqrt(dx + dy);
    }
    
}
