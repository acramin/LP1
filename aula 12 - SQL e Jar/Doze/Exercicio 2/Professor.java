public class Professor {

    private String nome;
    private int idade;
    private int matricula;

    public Professor(String nome, int idade, int matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    public Professor(int matricula) {
        this.matricula = matricula;
    }

    public Professor(){
        clearObject();
    }

    public int getIdade() {
        return idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        String msg = "Nome: " + nome + ", Idade: " + idade + ", Matricula: " + matricula;
        return msg;
    }

    public  void    clearObject()
    {   nome = null;
        idade = 0;
        matricula = 0;
    }
}