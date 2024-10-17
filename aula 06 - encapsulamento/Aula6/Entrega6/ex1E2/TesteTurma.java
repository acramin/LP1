package Entrega6.ex1E2;

import javax.swing.JOptionPane;

public class TesteTurma {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Nome:");
        String curso = JOptionPane.showInputDialog("Curso:");
        int qtdDeAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de alunos: "));
        int serie = Integer.parseInt(JOptionPane.showInputDialog("Série: "));

        Turma turma = new Turma(nome, curso, qtdDeAlunos, serie);

        String msg = "Nome: " +  turma.getNome() + "\nCurso: " + turma.getCurso() + "\nQuantidade de alunos: " + turma.getQtdDeAlunos() + "\nSérie: " + turma.getSerie();
        
        JOptionPane.showMessageDialog(null, msg);

        int novaQtd = Integer.parseInt(JOptionPane.showInputDialog("Nova quantidade de alunos: "));
        turma.setQtdDeAlunos(novaQtd);

        msg = "Nome: " +  turma.getNome() + "\nCurso: " + turma.getCurso() + "\nQuantidade de alunos: " + turma.getQtdDeAlunos() + "\nSérie: " + turma.getSerie();

        JOptionPane.showMessageDialog(null, msg);

    }
    
}