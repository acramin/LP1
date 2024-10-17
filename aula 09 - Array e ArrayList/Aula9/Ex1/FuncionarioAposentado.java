package Ex1;

public class FuncionarioAposentado extends Funcionario {
    private double salarioAposentadoria;

    public FuncionarioAposentado(String nome, int idade, double salario, String cargo, double salarioAposentadoria) {
        super(nome, idade, salario, cargo);
        this.salarioAposentadoria = salarioAposentadoria;
    }

    public double getSalarioAposentadoria() {
        return salarioAposentadoria;
    }

    public void setSalarioAposentadoria(double salarioAposentadoria) {
        this.salarioAposentadoria = salarioAposentadoria;
    }
    
    // Sobreposição
    public String toString() {
        return "Funcionario [nome: " + super.getNome() + "  , idade: " + super.getIdade() 
        + ", aposentadoria: " + salarioAposentadoria + "  , categoria: " + super.categoria() + "]";
    }



}
