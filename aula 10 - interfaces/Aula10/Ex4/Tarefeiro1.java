package Ex4;

public class Tarefeiro1 extends Empregado1 {
    private double salario;
    private int tarefas;
    
    public Tarefeiro1(String nome, String sobrenome, String cpf, double salario, int tarefas){
        super(nome, sobrenome, cpf);
        this.salario = salario;
        this.tarefas = tarefas;
    }
    
    public double salario(){
        return this.salario*this.tarefas;
    }
}
