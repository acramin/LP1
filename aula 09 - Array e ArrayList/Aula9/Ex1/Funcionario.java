package Ex1;

public class Funcionario extends Pessoa {
    private double salario;
    private String cargo;

    public Funcionario(String nome, int idade, double salario, String cargo){
        super(nome, idade);
        this.salario = salario;
        this.cargo = cargo;
    }

    public int categoria(){
        if(super.getIdade() > 20)
            return 30;
        else
            return 10;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Sobreposição
    public String toString() {
        return "Funcionario [nome: " + super.getNome() + "  , idade: " + super.getIdade() + ", salario: " 
        + salario + "  , cargo: " + cargo + "  , categoria: " + categoria() + "]";
    }

}
