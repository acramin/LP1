package Entrega6.Ex4;

import javax.swing.JOptionPane;

public class TesteDisciplina {
    public static void main(String[] args) {
        
        String nome = JOptionPane.showInputDialog("Nome: ");
        String professor = JOptionPane.showInputDialog("Professor: ");
        int semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre: "));
        boolean ofertada;
        String of = JOptionPane.showInputDialog("Ofertada [sim/não]: ");

        if (of.equals("sim")){
            ofertada = true;
        } else {
            ofertada = false;
        }



        Disciplina disciplina = new Disciplina(nome, professor, semestre, ofertada);

        String msg = "Nome: " + disciplina.getNome() + "\nProfessor: " + disciplina.getProfessor() + "\nSemestre: " + disciplina.getSemestre();

        if(disciplina.getOfertada()){
            msg += "\nOferata: sim";
        } else {
            msg += "\nOfertada: não";
        }

        JOptionPane.showMessageDialog(null, msg);

    }
    
}