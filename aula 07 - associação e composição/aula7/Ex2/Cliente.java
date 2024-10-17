package Ex2;

public class Cliente {
    
    private String nome;
    private String cpf;
    private ContaCorrrente conta;

    public Cliente(String n, String cpf, ContaCorrrente c){
        nome = n;
        this.cpf = cpf;
        conta = c;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public ContaCorrrente getConta(){
        return conta;
    }

    public void setConta(ContaCorrrente conta) {
        this.conta = conta;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
