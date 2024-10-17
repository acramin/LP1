package Ex1;

public class Disciplina {

    private String nome;
    private boolean pratica;

    public Disciplina(String n, boolean p){
        nome = n;
        pratica = p;
    }
    
    public String getNome(){
        return nome;
    }


    public boolean getPratica(){
        return pratica;
    }

    public void setNome(String n){
        nome = n;
    }

    public void setPratica(boolean p){
        pratica = p;
    }

    public String getDados(){
        return "Nome: " + nome + "; Pratica: " + pratica;
    }
    
}