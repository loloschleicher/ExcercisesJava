
/**
 * Write a description of class RegistroCivilActualizado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.text.*;
import java.util.*;
public class RegistroCivilActualizado {

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
    
    private static Mujer2 tratarMujer(boolean casadaFlag) throws ParseException{
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
        if(casadaFlag){  
            return new Mujer2(nombre, apellido, cal);    
        }
        char isCasada;
        do{
            System.out.println("Está Casada? (S/N): ");
            isCasada = input.nextLine().toUpperCase().charAt(0);
        }while( isCasada != 'S' && isCasada != 'N');
        Mujer2 mujer;
        if(isCasada == 'S'){
            do{
                System.out.println("Con Hombre (H) o Mujer (M)? (H/M): ");
                isCasada = input.nextLine().toUpperCase().charAt(0);
            }while( isCasada != 'H' && isCasada != 'M');
            if(isCasada == 'H'){
                Hombre2 hombre = tratarHombre(true);
                mujer = new Mujer2(nombre, apellido, cal, "Casada", hombre);
                hombre.casarseCon(mujer);
            }else{
                Mujer2 mujerC = tratarMujer(true);
                mujer = new Mujer2(nombre, apellido, cal, "Casada", mujerC);
                mujerC.casarseCon(mujer);
            }
        }else{
            mujer = new Mujer2(nombre, apellido, cal);
        }
        
        int aux =0;
        do{
            boolean estaCasada = mujer.getEsposx() != null;
            System.out.println(mujer.datos() + " quiere: \n"+(!estaCasada ? "1 - Casarse?": "1 - Divorciarse? \n2 - Mostrar Estado Civil? \n3 - Saber con quien esta casada?")+"\n0 - Salir");
            aux = input.nextInt();
            switch (aux){
                case 1:
                    if(estaCasada){
                        mujer.getEsposx().divorcio();
                        mujer.divorcio();
                    }else{
                        input.nextLine();
                        do{
                            System.out.println("Con Hombre (H) o Mujer (M)? (H/M): ");
                            isCasada = input.nextLine().toUpperCase().charAt(0);
                        }while( isCasada != 'H' && isCasada != 'M');
                        if(isCasada == 'H'){
                            mujer.casarseCon(tratarHombre(true));
                        }else{
                            mujer.casarseCon(tratarMujer(true));
                        }
                    }
                    break;
                case 2:
                    if(estaCasada)
                        mujer.mostrarEstadoCivil();
                    break;
                case 3:
                    if(estaCasada)
                        mujer.casadxCon();
                    break;
            }
        }while(aux > 0);
        return mujer;
    }
    private static Hombre2 tratarHombre( boolean casadoFlag) throws ParseException{
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
        if(casadoFlag){  
            return new Hombre2(nombre, apellido, cal);    
        }
        char isCasado;
        do{
            System.out.println("Está Casado? (S/N): ");
            isCasado = input.nextLine().toUpperCase().charAt(0);
        }while( isCasado != 'S' && isCasado != 'N');
        Hombre2 hombre;
        if(isCasado == 'S'){
            do{
                System.out.println("Con Hombre (H) o Mujer (M)? (H/M): ");
                isCasado = input.nextLine().toUpperCase().charAt(0);
            }while( isCasado != 'H' && isCasado != 'M');
            if(isCasado == 'H'){
                Hombre2 hombreC = tratarHombre(true);
                hombre = new Hombre2(nombre, apellido, cal, "Casada", hombreC);
                hombreC.casarseCon(hombre);
            }else{
                Mujer2 mujer = tratarMujer(true);
                hombre = new Hombre2(nombre, apellido, cal, "Casado", mujer);
                mujer.casarseCon(hombre);
            }
            
        }else{
            hombre = new Hombre2(nombre, apellido, cal);
        }
        
        int aux =0;
        do{
            boolean estaCasado = hombre.getEsposx() != null;
            System.out.println(hombre.datos() + " quiere: \n"+(!estaCasado ? "1 - Casarse?": "1 - Divorciarse? \n2 - Mostrar Estado Civil? \n3 - Saber con quien esta casada?")+"\n0 - Salir");
            aux = input.nextInt();
            switch (aux){
                case 1:
                    if(estaCasado){
                        hombre.getEsposx().divorcio();
                        hombre.divorcio();
                    }else{
                        input.nextLine();
                        do{
                            System.out.println("Con Hombre (H) o Mujer (M)? (H/M): ");
                            isCasado = input.nextLine().toUpperCase().charAt(0);
                        }while( isCasado != 'H' && isCasado != 'M');
                        if(isCasado == 'H'){
                            hombre.casarseCon(tratarHombre(true));
                        }else{
                            hombre.casarseCon(tratarMujer(true));
                        }
                    }
                    break;
                case 2:
                    if(estaCasado)
                        hombre.mostrarEstadoCivil();
                    break;
                case 3:
                    if(estaCasado)
                        hombre.casadxCon();
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
