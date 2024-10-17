package Ex1;

public class Atribuicao {

    private Professor professor;
    private Disciplina disciplina;

    public Atribuicao(Professor p, Disciplina d){
        professor = p;
        disciplina = d;
    }

    public Professor getProfessor(){
        return professor;
    }


    public Disciplina getDisciplina(){
        return disciplina;
    }

    public void setProfessor(Professor p){
        professor = p;
    }

    public void setDisciplina(Disciplina d){
        disciplina = d;
    }
    
    public String getDados(){
        return "Info do professor: " + professor.getDados() + "\nInfo da disciplina: " + disciplina.getDados();
    }

}