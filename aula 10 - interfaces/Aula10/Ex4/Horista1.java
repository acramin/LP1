package Ex4;

public class Horista1 extends Empregado1 {
    private double salario;
    private double horas;
    
    public Horista1(String nome, String sobrenome, String cpf, double salario, double horas){
        super(nome, sobrenome, cpf);
        this.salario = salario;
        this.horas = horas;
    }
    
    public double salario(){
        return this.salario*this.horas;
    }
}
