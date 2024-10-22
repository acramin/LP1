package CriandoThreads;

import java.util.Random;

public class SimpleThreadExample {
    // Geracao de um bilhao de numeros aleatorios...
    private static final long TOTAL_NUMEROS = 1_000_000_000L;

    public static void main(String args[]) {
        final int threads = 1; // criar apenas 1 outra Thread
        System.out.println("Missao: Gerar um bilhao de numeros aleatorios!");
        System.out.printf(" Criando %d Thread(s) para isso!\n", threads);
        new SimpleThreadExample().run(); // Uma Thread por vez (linear)
    }

    public void run() {
        System.out.println("- Iniciando Thread Principal...");
        // Le o tempo do sistema no inicio do processamento
        final double startTime = System.currentTimeMillis();
        // Sorteia um numero (randomico)
        Random rand = new Random();
        // Eleva a 10a potencia cada numero para o processamento mais complexo
        for (int i = 0; i < TOTAL_NUMEROS; i++) {
            Math.pow(rand.nextDouble(), 10);
        }
        // Tempo de processamento em segundos
        final double totalSecs = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println("- Encerrando o processamento...");
        System.out.printf("Missao cumprida em %.2f segundos!\n", totalSecs);
    }
}

/*
 * A classe SimpleThreadExample contém o método main que cria uma instância da classe SimpleThreadExample e chama o método run.
 * O método run executa um loop que gera um bilhão de números aleatórios e eleva cada número à décima potência.
 * O tempo de processamento é medido e impresso no console.
 * É uma execução linear, ou seja, apenas uma Thread é usada para processar os números.
 * 
 * No computador pessoal levou 47,19 segundos para fazer esse processamento.
 */