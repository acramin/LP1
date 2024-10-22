package FuncAnon;

// Definindo uma interface funcional com um único método abstrato
interface Operacao {
    int executar(int a, int b);
}

public class ExemploFuncaoAnonima {
    public static void main(String[] args) {
        // Criando uma instância da interface funcional usando uma classe anônima
        Operacao adicao = new Operacao() {
            @Override
            public int executar(int a, int b) {
                return a + b;
            }
        };

        // Usando a função anônima
        int resultado = adicao.executar(5, 3);
        System.out.println("Resultado: " + resultado);
    }
}

/*
 * A classe ExemploFuncaoAnonima contém o método main que cria uma instância da interface funcional Operacao usando uma classe anônima.
 * A classe anônima implementa o método executar da interface funcional, que neste caso é uma operação de adição.
 * A instância da classe anônima é atribuída à variável adicao, que é usada para chamar o método executar com os argumentos 5 e 3.
 * O resultado é 8, que é a soma de 5 e 3.
 */