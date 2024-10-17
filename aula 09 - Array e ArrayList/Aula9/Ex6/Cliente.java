package Ex6;

public class Cliente {
    private String nome;
    private String fone;
    private int id;

    public Cliente(String nome, String fone, int id){
        this.nome = nome;
        this.fone = fone;
        this.id = id;
    }

    public Cliente(){
        this.nome = "Teste";
        this.fone = "(11) 9 1234-5678";
        this.id = 0;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
