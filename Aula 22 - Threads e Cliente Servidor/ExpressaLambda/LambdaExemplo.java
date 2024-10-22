package ExpressaLambda;
// Definindo a interface funcional
@FunctionalInterface
interface Operacao {
    int executar(int a, int b);
}

public class LambdaExemplo {
    public static void main(String[] args) {
        // Lambda simples que soma dois números inteiros
        Operacao soma = (a, b) -> a + b;
        int resultado = soma.executar(5, 3); // resultado é 8
        System.out.println("Resultado da soma: " + resultado);
    }
}

/*
 * Operador é uma interface funcional que define um método executar que recebe dois inteiros e retorna um inteiro.
 * A classe LambdaExemplo contém o método main que cria uma instância de Operacao usando uma expressão lambda.
 * A expressão lambda (a, b) -> a + b é uma função que recebe dois inteiros e retorna a soma deles.
 * O método executar é chamado com os argumentos 5 e 3, e o resultado é impresso no console.
 * O resultado é 8, que é a soma de 5 e 3.
 */
