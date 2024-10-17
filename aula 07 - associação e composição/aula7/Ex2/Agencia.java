package Ex2;

public class Agencia {
    
    private String nome;
    private int numero;
    private int digito;

    public Agencia(String n, int num, int d){
        nome = n;
        numero = num;
        digito = d;
    }

    public int getDigito() {
        return digito;
    }
    
    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setNumero(int numero) {
        this.numero = numero;
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
