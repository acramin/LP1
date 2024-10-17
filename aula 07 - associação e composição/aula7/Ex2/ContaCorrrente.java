package Ex2;

public class ContaCorrrente {
    
    private int numero;
    private int digito;
    private Agencia agencia;
    private double saldo;

    public ContaCorrrente(int n, int d, Agencia a, double s){
        numero = n;
        digito = d;
        agencia = a;
        saldo = s;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public int getDigito() {
        return digito;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double depositar(double valor){ // ficar de olho nisso
        return saldo = saldo + valor;    
    }

    public double sacar(double valor){ // ficar de olho nisso
        if (valor > saldo){
            return 0;
        } else {
            saldo = saldo - valor;
            return saldo;
        } 
    }

    public double consultarSaldo(){
        return saldo;
    }

    public String imprimirSaldo(){
        return "Numero da conta: " + numero + "-" + digito + "\nNumero da agencia: " 
        + agencia.getNumero() +  "-" + agencia.getDigito() + "\nSaldo da conta corrente: " + saldo; 
    }

    public boolean mod11(int numero, int digito){
        int p = numero/1000;
        int s = (numero % 1000)  / 100; 
        int t = (numero % 100) / 10 ;
        int q = (numero % 10);
        
        int valido = (p*4 +  s*6+ t*8+ q*2 ) % 11;
        
        if ( valido == digito){
            return true;
        } else {
            return false;
        }
    }

}
