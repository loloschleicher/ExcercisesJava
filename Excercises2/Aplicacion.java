
/**
 *
 * @author Augusto
 * Dato importante: https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
 * cuando utilizo el mismo scanner hay veces que saltea el nextLine(); esto pasa porque el nextInt no consume el ultimo caracter de la linea. por tal motivo se lo debe llamar luego de utilizarlo.
 */
import java.text.*;
import java.util.*;

public class Aplicacion {
    private static Scanner entrada;
    
     public static void main() throws ParseException {
        // TODO code application logic here
        System.out.println("***** Bienvenidos a Visual-Dron ******");
        int var = 0;
        do{
            entrada = new Scanner(System.in);
            System.out.println("1-Nuevo Alquiler \n2-Salir");
            var = entrada.nextInt();
            if(var ==1){
                //Creamos un nuevo Alquiler
                Dron dron = crearDrone();
                Alquiler alqui = crearAlquiler(dron);
                int aux = 0, sa = 0;
                do{
                    System.out.println("|_ Que desea hacer?: \n  |_1 - Agregar un Servicio Adicional \n  |_2 - Mostrar \n  |_3 - Salir");
                    try {
                        aux = entrada.nextInt();
                    } catch (Exception e) {
                        System.out.println("Ingrese numero valido.");
                        aux = 0;
                    }
                    if(aux == 1){
                        sa = agregarUnServicioAdicional();
                        alqui.agregarAdicional(sa);
                    }else if(aux == 2){
                        alqui.mostrar();
                    }
                    
                }while(aux == 1 || aux == 2 || aux != 3 );
                
                
            }
        }while(var != 2);
    }
     
     private static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
     
     private static Dron crearDrone(){
        int aux;
        do{
            System.out.println("|_ Modelo del Dron?: \n  |_1 - DJI Phantom 2 con definicion FULL-HD \n  |_2 - DJI Phantom 3 con definicion 4K ");
            try {
                aux = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Ingrese numero valido.");
                aux = 0;
            }

        }while(aux != 1 && aux != 2 );
        String modelo, definicion;
        switch (aux){
            case 1:
                modelo = "DJI Phantom 2";
                definicion = "FULL-HD";
                break;
            case 2:
                modelo = "DJI Phantom 3";
                definicion = "4K";
                break;
            default:
                modelo = "";
                definicion = "";
                break;
        };
        return new Dron(aux, modelo, definicion);
     }

    private static Alquiler crearAlquiler(Dron dron) throws ParseException {
        String fecha;
        entrada.nextLine();
        do{
            System.out.println("|_ Fecha del servicio?(dd/mm/yyyy):");
            fecha = entrada.nextLine();
            if(!validarFecha(fecha))
                System.out.println("[ERROR] La fecha no es correcta por favor ingrese nuevamente.");
        }while(!validarFecha(fecha));
        int cantidadHoras;
        do{
            System.out.println("|_ Cantidad de horas:");
            try {
                cantidadHoras = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Ingrese numero valido.");
                cantidadHoras = 0;
            }

        }while(cantidadHoras == 0 );
        String cliente;
        entrada.nextLine(); //Uso para consumir la entrada porque saltea cuando quiero pedir el nombre del cliente
        System.out.println("|_ Nombre y Apellido del Cliente:");
        cliente = entrada.nextLine();
        int sa = agregarUnServicioAdicional();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatoFecha.parse(fecha);
        Calendar cal = Calendar.getInstance();
        if(sa == 3){
            return new Alquiler(dron, cal, cantidadHoras, cliente);
        }else{
            return new Alquiler(dron, cal, cantidadHoras, cliente, sa);
        }
    }
    
    private static int agregarUnServicioAdicional(){
        int sa;
        do{
            System.out.println("|_ Desea un Servicio adicional?: \n  |_1 - Filmación 360° \n  |_2 - Transmisión en vivo \n  |_3 - Ninguno");
            try {
                sa = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Ingrese numero valido.");
                sa = 0;
            }

        }while(sa != 1 && sa != 2 && sa != 3 );
        return sa;
    }
}