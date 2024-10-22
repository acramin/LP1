package FuncAnon;

// Definindo uma interface funcional com um único método abstrato
interface Operacao {
    int executar(int a, int b);
}

public class ExemploFuncaoAnonima2 {
    public static void main(String[] args) {
        // Usando uma expressão lambda para criar uma função anônima
        Operacao adicao = (a, b) -> a + b;

        // Usando a função anônima
        int resultado = adicao.executar(5, 3); // resultado é 8
        System.out.println("Resultado: " + resultado);
    }
}

/*
 * A classe ExemploFuncaoAnonima2 contém o método main que cria uma instância da interface funcional Operacao usando uma expressão lambda.
 * A expressão lambda (a, b) -> a + b é uma função que recebe dois inteiros e retorna a soma deles.
 * A instância da expressão lambda é atribuída à variável adicao, que é usada para chamar o método executar com os argumentos 5 e 3.
 * O resultado é 8, que é a soma de 5 e 3.
 */