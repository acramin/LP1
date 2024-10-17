package Ex1;

public class TesteAtribuicao {

    public static void main(String[] args) {
        Professor professor = new Professor("Teste", 0);
        Disciplina disciplina = new Disciplina("teste", false);
        Atribuicao atribuicao = new Atribuicao(professor, disciplina);

        System.out.println(atribuicao.getDados());

    }
}