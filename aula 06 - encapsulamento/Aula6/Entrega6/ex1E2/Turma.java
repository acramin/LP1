package Entrega6.ex1E2;

public class Turma {

    private String nome;
    private String curso;
    private int qtdDeAlunos;
    private int serie;

    public Turma(String n, String c, int q, int s){
        nome = n;
        curso = c;
        qtdDeAlunos = q;
        serie = s;
    }

    public String getNome(){
        return nome;
    }

    public String getCurso(){
        return curso;
    }

    public int getQtdDeAlunos(){
        return qtdDeAlunos;
    }

    public int getSerie(){
        return serie;
    }

    public void setNome(String n){
        nome = n;
    }

    public void setCurso(String c){
        curso =c;
    }

    public void setQtdDeAlunos(int q){
        qtdDeAlunos = q;
    }

    public void setSerie(int s){
       serie = s;
    }
}