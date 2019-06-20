
/**
 * Write a description of class Alquiler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.text.*;
import java.util.*;
public class Alquiler {
    private Calendar fecha;
    private int cant_horas;
    private String cliente;
    private int servicio_Adicional;
    private Dron dron;
    
    /* GETTER AND SETTERS */
    public Calendar getFecha() {
        return fecha;
    }

    private void setFecha(Calendar fec) {
        fec.add(Calendar.MONTH,-1);
        this.fecha = fec;
    }

    public int getCant_horas() {
        return cant_horas;
    }

    private void setCant_horas(int cant_horas) {
        this.cant_horas = cant_horas;
    }

    public String getCliente() {
        return cliente;
    }

    private void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getServicio_Adicional() {
        return servicio_Adicional;
    }

    private void setServicio_Adicional(int servicio_Adicional) {
        this.servicio_Adicional = servicio_Adicional;
    }

    public Dron getDron() {
        return dron;
    }

    private void setDron(Dron dron) {
        this.dron = dron;
    }
    
    
    public Alquiler(Dron p_dron, Calendar p_fecha, int p_ch, String p_cliente, int p_sa){
        this.setDron(p_dron);
        this.setFecha(p_fecha);
        this.setCant_horas(p_ch);
        this.setCliente(p_cliente);
        this.setServicio_Adicional(p_sa);
    }
    public Alquiler(Dron p_dron, Calendar p_fecha, int p_ch, String p_cliente){
        this.setDron(p_dron);
        this.setFecha(p_fecha);
        this.setCant_horas(p_ch);
        this.setCliente(p_cliente);
        this.setServicio_Adicional(0);
    }
    public void agregarAdicional(int p_adicional){
        if(p_adicional == 1 || p_adicional == 2 || p_adicional == 0)
            this.setServicio_Adicional(p_adicional);
    }
    public double costoAlquiler(){
        double d = this.getDron().costoPorHora() * this.getCant_horas() + this.adicional();
        d = d - (d * this.porcentajeDescuento()/100);
        return d;
    }
    private int porcentajeDescuento(){
        int cH = this.getCant_horas();
        if( cH >= 5){
            return 25;
        } else if(cH >= 3 && cH < 5){
            return 15;
        }
        return 0;
    }
    private double adicional(){
        switch (this.getServicio_Adicional()){
            case 1:
                return 2000;
            case 2:
                return 1000;
            default:
                return 0;
        }
    }
    
    private String adicionalTipo(){
        switch (this.getServicio_Adicional()){
            case 1:
                return "Filmación 360°";
            case 2:
                return "Transmisión en vivo";
            default:
                return "";
        }
    }
    /**Mostrar imprime este formato:
    * *** Empresa Visual-Dron***
    * Modelo de Dron: DJI Phantom 3 – Definición: 4k - Costo por Hora: $ 1500.00
    * Fecha de alquiler: 12/02/2018 – Cliente: Marcos Alarcon - Hs de alquiler: 4
    * Adicional por 360°: $2000 – Descuento del 15 %- Costo final: $ 6800
*/
    public void mostrar(){
        DecimalFormat df = new DecimalFormat("#.##");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("*** Empresa Visual-Dron***");
        System.out.println(this.getDron().toString());
        System.out.printf("Fecha de alquiler: %s - Cliente: %s - Hs de alquiler: %s\n",sdf.format(this.getFecha().getTime()),this.getCliente(),this.getCant_horas());
        String cuartaLinea =  (!this.adicionalTipo().isEmpty()? "Adicional por "+ this.adicionalTipo() + ": $"+ this.adicional() + " - " : "");
        cuartaLinea += (this.porcentajeDescuento() != 0 ? "Descuento del "+this.porcentajeDescuento()+"% - ":"");
        cuartaLinea += "Costo final: $" + df.format(this.costoAlquiler());
        System.out.println(cuartaLinea);
        
    }
}