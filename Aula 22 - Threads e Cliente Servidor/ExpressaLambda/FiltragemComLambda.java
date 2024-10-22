package ExpressaLambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltragemComLambda {
    public static void main(String[] args) {
        // Filtrando números pares usando stream e lambda
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);
    }
}

/*
 * A classe FiltragemComLambda contém o método main que cria uma lista de números inteiros e filtra os 
 * números pares usando uma expressão lambda.
 * A lista de números é convertida em um stream, e o método filter é usado para filtrar os números pares.
 * O método collect é usado para coletar os números filtrados em uma nova lista.
 * A lista resultante contém apenas os números pares, que são impressos no console.
 * O resultado é uma lista de números pares: [2, 4, 6, 8, 10].
 */