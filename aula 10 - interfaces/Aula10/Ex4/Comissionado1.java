package Ex4;

public class Comissionado1 extends Mensalista1{
    private double comissao;
    public Comissionado1(String nome, String sobrenome, String cpf, double salario, double comissao){
        super(nome, sobrenome, cpf, salario);
        this.comissao = comissao;
    }
    
    public double salario(){
        return super.salario()+comissao;
    }
    
}
