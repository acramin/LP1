package Ex2;

public class Tarefeiro extends Empregado {
    private double salario;
    private int tarefas;
    
    public Tarefeiro(String nome, String sobrenome, String cpf, double salario, int tarefas){
        super(nome, sobrenome, cpf);
        this.salario = salario;
        this.tarefas = tarefas;
    }
    
    public double salario(){
        return this.salario*this.tarefas;
    }
}
