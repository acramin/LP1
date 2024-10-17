package Ex2;

public class TesteEmpregado {
    public static void main(String[] args){

        // pessoa fisica de teste
        
        System.out.println("TESTE DE PESSOA FISICA HARD");
        System.out.println();
        System.out.println();

        PessoaFisica pf = new PessoaFisica();
        System.out.println(pf.dados());

        System.out.println();
        System.out.println();
        

        // pessoa fisica criada
        
        System.out.println("TESTE DE PESSOA FISICA CRIADA");
        System.out.println();
        System.out.println();

        PessoaFisica pf1 = new PessoaFisica("Ana", "Maré", "198.454.786-66");
        System.out.println(pf1.dados());
        
        System.out.println();
        System.out.println();

        // empregado criado (salrio = 0)

        System.out.println("TESTE DE EMPREGADO HARD");
        System.out.println();
        System.out.println();

        Empregado emp0 = new Empregado("Gael", "Boia", "198.454.786-66");
        System.out.println(emp0.dados());
        System.out.println("Salário = " + emp0.salario());
        
        System.out.println();
        System.out.println();

        // mensalista criado
        
        System.out.println("TESTE DE MENSALISTA");
        System.out.println();
        System.out.println();

        Mensalista ms = new Mensalista("Betina", "Maluca", "000.000.000-01", 1500);
        System.out.println(ms.dados());
        System.out.println("Salário = " +  ms.salario());
        
        System.out.println();
        System.out.println();

        // comissionado craido
        
        System.out.println("TESTE DE COMISSIONADO");
        System.out.println();
        System.out.println();

        Comissionado com = new Comissionado("Joazinho", "Doidinho", "000.000.000-02", 1530, 800);
        System.out.println(com.dados());
        System.out.println("Salário = " + com.salario());
        
        System.out.println();
        System.out.println();

        // horista criado
        
        System.out.println("TESTE DE HORISTA");
        System.out.println();
        System.out.println();

        Horista hor = new Horista("Fulano", "de Tal", "000.000.000-03", 50, 9);
        System.out.println(hor.dados());
        System.out.println("Salário = " + hor.salario());
        
        System.out.println();
        System.out.println();

        // tarefeiro criado
        
        System.out.println("TESTE DE TAREFEIRO");
        System.out.println();
        System.out.println();

        Tarefeiro tf = new Tarefeiro("Maria", "Joaquina", "000.000.000-03", 100, 5);
        System.out.println(tf.dados());
        System.out.println("Salário = " + tf.salario());
        
        System.out.println();
        System.out.println();

        // desempregado teste
        
        System.out.println("TESTE DESEMPREGADO HARD");
        System.out.println();
        System.out.println();

        Desempregado desp0 = new Desempregado();
        System.out.println(desp0.dados());
        
        System.out.println();
        System.out.println();

        // desempregado criado
        
        System.out.println("TESTE DESEMPREGADO");
        System.out.println();
        System.out.println();

        Desempregado desp = new Desempregado("Zezinho", "da Silva", "500.604.908-89", 2000);
        System.out.println(desp.dados()); 
        
        System.out.println();
        System.out.println();

    }

}
