package Ex2;

public class Mensalista extends Empregado{
    private double salario;
    
    public Mensalista(String nome, String sobrenome, String cpf, double salario){
        super(nome, sobrenome, cpf);
        this.salario = salario;
    }
    
    public double salario(){
        return this.salario;
    }
    
}


