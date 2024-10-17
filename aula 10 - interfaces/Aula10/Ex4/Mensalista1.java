package Ex4;

public class Mensalista1 extends Empregado1{
    private double salario;
    
    public Mensalista1(String nome, String sobrenome, String cpf, double salario){
        super(nome, sobrenome, cpf);
        this.salario = salario;
    }
    
    public double salario(){
        return this.salario;
    }
    
}


