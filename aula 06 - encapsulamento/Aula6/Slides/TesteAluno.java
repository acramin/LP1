package Slides;

import javax.swing.JOptionPane;

public class TesteAluno {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Nome:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso: "));
        char sexo = JOptionPane.showInputDialog("Sexo [M/F]: ").charAt(0);
        boolean formando = false;


        Aluno aluno = new Aluno(nome, idade, peso, sexo, formando);

        String msg = "Nome: " +  aluno.getNome() + "\nIdade: " + aluno.getIdade() + " anos " + "\nPeso: " + aluno.getPeso() + " kg ";

        if(aluno.getFormando()){
            msg += "\nFormando: sim";
        } else {
            msg += "\nFormando: não";
        }
        if (aluno.getSexo() == 'M'){
            msg += "\nSexo: masculino";
        } else {
            msg += "\nSexo: feminino";
        }

        JOptionPane.showMessageDialog(null, msg);

        idade = Integer.parseInt(JOptionPane.showInputDialog("Confime Idade: "));
        peso = Double.parseDouble(JOptionPane.showInputDialog("Confirme Peso: "));
        String form = JOptionPane.showInputDialog("Formando [sim/não]: ");


        if (form.equals("sim")){
            formando = true;
        } else {
            formando = false;
        }

        Aluno aluno2 = new Aluno(nome, idade, peso, sexo, formando);
        
        msg = "Nome: " +  aluno.getNome() + "\nIdade: " + aluno2.getIdade() + " anos " + "\nPeso: " + aluno2.getPeso() + " kg ";
        
        if(aluno2.getFormando()){
            msg += "\nFormando: sim";
        } else {
            msg += "\nFormando: não";
        }

        if (aluno.getSexo() == 'M'){
            msg += "\nSexo: masculino";
        } else {
            msg += "\nSexo: feminino";
        }

        JOptionPane.showMessageDialog(null, msg);
    }
}
