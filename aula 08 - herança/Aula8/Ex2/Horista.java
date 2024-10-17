package Ex2;

public class Horista extends Empregado {
    private double salario;
    private double horas;
    
    public Horista(String nome, String sobrenome, String cpf, double salario, double horas){
        super(nome, sobrenome, cpf);
        this.salario = salario;
        this.horas = horas;
    }
    
    public double salario(){
        return this.salario*this.horas;
    }
}
