package Ex2;

public class Comissionado extends Mensalista{
    private double comissao;
    public Comissionado(String nome, String sobrenome, String cpf, double salario, double comissao){
        super(nome, sobrenome, cpf, salario);
        this.comissao = comissao;
    }
    
    public double salario(){
        return super.salario()+comissao;
    }
    
}
