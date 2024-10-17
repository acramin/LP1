package Ex3;

public class Tarefeiro extends Empregado {
    private double precoTarefa;
    private int qtdTarefas;

    public Tarefeiro(String nome, double precoTarefa, int qtdTarefas){
        super(nome);
        this.precoTarefa = precoTarefa;
        this.qtdTarefas = qtdTarefas;
    }

    public double salario(){
        return precoTarefa * qtdTarefas;
    }
}
