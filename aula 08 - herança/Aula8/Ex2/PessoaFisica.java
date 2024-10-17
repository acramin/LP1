package Ex2;

public class PessoaFisica {
    private String nome;
    private String sobrenome;
    private String cpf;

    public PessoaFisica(){
        nome = "Teste ";
        sobrenome = "Teste";
        cpf = "123.456.789-00";
    }

    public PessoaFisica(String nome, String sobrenome, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String dados(){
        String msg = "Nome Compelto: " + nome + " " + sobrenome + "\nCPF: " + cpf;
        return msg;
    }
}
