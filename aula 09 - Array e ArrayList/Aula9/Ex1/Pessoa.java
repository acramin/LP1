package Ex1;

public class Pessoa {
    private String nome;
    private int idade;

    // Sobrecarga
    public Pessoa(){
        nome = "Teste";
        idade = 19;
    }

    // Sobrecarga
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Sobreposição
    public String toString() {
        return "Pessoa [nome: " + nome + ", idade: " + idade + "]";
    }

}
