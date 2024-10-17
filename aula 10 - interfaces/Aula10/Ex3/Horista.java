package Ex3;

public class Horista extends Empregado{
    private double precoHora;
    private int qtdHoras;

    public Horista(String nome, double precoHora, int qtdHoras){
        super(nome);
        this.precoHora = precoHora;
        this.qtdHoras = qtdHoras;
    }

    public double salario(){
        return precoHora * qtdHoras;
    }
}
