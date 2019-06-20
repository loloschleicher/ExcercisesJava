
/**
 * Write a description of class CuentaBancaria here.
 * 
 * @author Augusto Portillo 
 * @version (a version number or a date)
 */
public class CuentaBancaria
{
    private int nro;
    private double saldo;
    private Persona titular;

    public int getNro() {
        return this.nro;
    }
    //#region GETTERS AND SETTERS
    private void setNro(int nro) {
        this.nro = nro;
    }

    public double getSaldo() {
        return this.saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return this.titular;
    }

    private void setTitular(Persona titular) {
        this.titular = titular;
    }
    //#endregion

    public CuentaBancaria(int pNro, Persona pTitular){
        this.setNro(pNro);
        this.setTitular(pTitular);
        this.setSaldo(0);
    }
    public CuentaBancaria(int pNro, double pSaldo, Persona pTitular){
        this.setNro(pNro);
        this.setTitular(pTitular);
        this.setSaldo(pSaldo);
    }

    public void depositar(double pImporte){
        if(pImporte > 0){
            this.setSaldo(this.getSaldo()+pImporte);
        }else{
            System.out.println("Debe ingresar un importe superior a $0 (cero)");
        }
    }
    public void extraer(double pImporte){
        if(pImporte > 0){
            if(this.getSaldo() >= pImporte){
                this.setSaldo(this.getSaldo()-pImporte);
            }else{
                System.out.println("El monto a retirar es superior a su saldo.");
            }
        }else{
            System.out.println("Debe ingresar un importe superior a $0 (cero)");
        }
    }
    public void mostrar(){
        System.out.println("--- Cuenta Bancaria ---");
        System.out.println("Titular: " + this.getTitular().nombreYapellido());
        System.out.println("Saldo: $ "+ this.getSaldo());
    }
}
