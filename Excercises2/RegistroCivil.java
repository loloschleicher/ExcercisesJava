
/**
 * Write a description of class RegistroCivil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.text.*;
import java.util.*;
public class RegistroCivil {

    private static Scanner input;
    public static void main(String[] args) throws ParseException{
        input = new Scanner(System.in);
        System.out.println("**** Bienvenidos al Registro Civil ****");
        int var = 0;
        do{
            System.out.println("1 - Crear Mujer \n2 - Crear Hombre \n3 - Salir");
            var = input.nextInt();
            input.nextLine();
            switch (var){
                case 1:
                    tratarMujer(false);
                    break;
                case 2:
                    tratarHombre(false);
                    break;
            }
        }while(var !=3);
    }
    
    private static Mujer tratarMujer(boolean conHombre) throws ParseException{
        String nombre, apellido;
        System.out.println("* Nombre de la Mujer:");
        nombre = input.nextLine();
        System.out.println("* Apellido de la Mujer:");
        apellido = input.nextLine();
        //Fecha de Nacimiento
        String fecha;
        do{
            System.out.println("|_ Fecha del servicio?(dd/mm/yyyy):");
            fecha = input.nextLine();
            if(!validarFecha(fecha))
                System.out.println("[ERROR] La fecha no es correcta por favor ingrese nuevamente.");
        }while(!validarFecha(fecha));
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatoFecha.parse(fecha);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(conHombre){  
            return new Mujer(nombre, apellido, cal);    
        }
        char isCasada;
        do{
            System.out.println("Está Casada? (S/N): ");
            isCasada = input.nextLine().toUpperCase().charAt(0);
        }while( isCasada != 'S' && isCasada != 'N');
        Mujer mujer;
        if(isCasada == 'S'){
            Hombre hombre = tratarHombre(true);
            mujer = new Mujer(nombre, apellido, cal, "Casada", hombre);
            hombre.casarseCon(mujer);
        }else{
            mujer = new Mujer(nombre, apellido, cal);
        }
        
        int aux =0;
        do{
            boolean estaCasada = mujer.getEsposo() != null;
            System.out.println(mujer.datos() + " quiere: \n"+(!estaCasada ? "1 - Casarse?": "1 - Divorciarse? \n2 - Mostrar Estado Civil? \n3 - Saber con quien esta casada?")+"\n0 - Salir");
            aux = input.nextInt();
            switch (aux){
                case 1:
                    if(estaCasada){
                        mujer.getEsposo().divorcio();
                        mujer.divorcio();
                    }else{
                        input.nextLine();
                        mujer.casarseCon(tratarHombre(true));
                    }
                    break;
                case 2:
                    if(estaCasada)
                        mujer.mostrarEstadoCivil();
                    break;
                case 3:
                    if(estaCasada)
                        mujer.casadaCon();
                    break;
            }
        }while(aux > 0);
        return mujer;
    }
    private static Hombre tratarHombre( boolean conMujer) throws ParseException{
        String nombre, apellido;
        System.out.println("* Nombre del Hombre:");
        nombre = input.nextLine();
        System.out.println("* Apellido del Hombre:");
        apellido = input.nextLine();
        //Fecha de Nacimiento
        String fecha;
        do{
            System.out.println("|_ Fecha de Nacimiento?(dd/mm/yyyy):");
            fecha = input.nextLine();
            if(!validarFecha(fecha))
                System.out.println("[ERROR] La fecha no es correcta por favor ingrese nuevamente.");
        }while(!validarFecha(fecha));
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatoFecha.parse(fecha);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(conMujer){  
            return new Hombre(nombre, apellido, cal);    
        }
        char isCasado;
        do{
            System.out.println("Está Casado? (S/N): ");
            isCasado = input.nextLine().toUpperCase().charAt(0);
        }while( isCasado != 'S' && isCasado != 'N');
        Hombre hombre;
        if(isCasado == 'S'){
            Mujer mujer = tratarMujer(true);
            hombre = new Hombre(nombre, apellido, cal, "Casado", mujer);
            mujer.casarseCon(hombre);
        }else{
            hombre = new Hombre(nombre, apellido, cal);
        }
        
        int aux =0;
        do{
            boolean estaCasado = hombre.getEsposa() != null;
            System.out.println(hombre.datos() + " quiere: \n"+(!estaCasado ? "1 - Casarse?": "1 - Divorciarse? \n2 - Mostrar Estado Civil? \n3 - Saber con quien esta casada?")+"\n0 - Salir");
            aux = input.nextInt();
            switch (aux){
                case 1:
                    if(estaCasado){
                        hombre.getEsposa().divorcio();
                        hombre.divorcio();
                    }else{
                        input.nextLine();
                        hombre.casarseCon(tratarMujer(true));
                    }
                    break;
                case 2:
                    if(estaCasado)
                        hombre.mostrarEstadoCivil();
                    break;
                case 3:
                    if(estaCasado)
                        hombre.casadoCon();
                    break;
            }
        }while(aux > 0);
        return hombre;
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
}