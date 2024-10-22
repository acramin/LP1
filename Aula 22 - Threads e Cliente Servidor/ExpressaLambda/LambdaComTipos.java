package ExpressaLambda;

import java.util.Comparator;

public class LambdaComTipos {
    public static void main(String[] args) {
        // Lambda com tipos explícitos
        Comparator<String> comparador = (String s1, String s2) -> s1.compareTo(s2);
        int resultado = comparador.compare("maçã", "banana");
        System.out.println("Resultado da comparação: " + resultado);
    }
}

/*
 * A classe LambdaComTipos contém o método main que cria uma instância de Comparator usando uma expressão lambda.
 * A expressão lambda (String s1, String s2) -> s1.compareTo(s2) é uma função que recebe duas Strings e retorna um inteiro.
 * O método compare é chamado com as Strings "maçã" e "banana", e o resultado é impresso no console.
 * O resultado é um número que diz a diferença entre as duas Strings, nesse caso 11.
 */