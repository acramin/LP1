package Ex1;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Teste Pessoa Pre-montada
        System.out.println("Pessoa Genérica");

        Pessoa p = new Pessoa();
        System.out.println(p.toString());

        System.out.println();

        // Teste Pessoa (+ entrada de dados)
        System.out.println("Pessoa Criada");

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();

        Pessoa p1 = new Pessoa(nome, idade);
        System.out.println(p1.toString());

        System.out.println();

        // Teste Funcionario (+ set informação na instancia)
        System.out.println("Funcionario Criado");

        Funcionario fun1 = new Funcionario("Noah", 23, 1500, "Estagiario");
        System.out.println(fun1.toString());

        System.out.println();

        // Teste Funcionario Aposentado (+ set informação no código)
        System.out.println("Aposentado Criado");
        FuncionarioAposentado apo = new FuncionarioAposentado(null, 0, 0,null, 0);

        apo.setNome("Bob");
        apo.setIdade(40);
        apo.setCargo("Encanador");
        apo.setSalario(3000);
        apo.setSalarioAposentadoria(1700);

        System.out.println(apo.toString());

        System.out.println();

        sc.close();

    }
}
