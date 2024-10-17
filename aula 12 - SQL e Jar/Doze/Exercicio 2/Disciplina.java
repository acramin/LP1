import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private ArrayList<Professor> professores;
    private String codigo;

    public Disciplina() {
        clearObject();
    }

    public Disciplina(String codigo) {
        this.codigo = codigo;
    }

    public Disciplina(String nome, ArrayList<Professor> professores, String codigo) {
        this.nome = nome;
        this.professores = professores;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String toString() {
        return "Disciplina [nome=" + nome + ", codigo=" + codigo + ", professores=" + professores.toString() + "]";
    }

    public  void    clearObject()
    {   nome = null;
        codigo = null;
        professores = new ArrayList<>();
    }
}
