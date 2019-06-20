
/**
 * Write a description of class Dron here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dron {
    private String modelo;
    private String definicion;
    
    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDefinicion() {
        return definicion;
    }

    private void setDefinicion(String definicion) {
        this.definicion = definicion;
    }
    
    public Dron(int p_cod, String p_mod, String p_def){
        this.setModelo(p_mod);
        this.setDefinicion(p_def);
    }
    
    public double costoPorHora(){
        switch (this.getDefinicion()){
            case "4K":
                return 1500;
            case "FULL-HD":
                return 1200;
            default:
                return 0;
        }
    }
    /** El método toString () de la clase Dron, devuelve un String con el siguiente formato:
      * Modelo de Dron: DJI Phantom 3 – Definición: 4k - Costo por Hora: $ 1500.00*/
    public String toString(){
        return "Modelo de Dron: " + this.getModelo() + " – Definición: " + this.getDefinicion() + " - Costo por Hora: $ "+this.costoPorHora();
    }
}
