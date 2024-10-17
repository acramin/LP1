public class ex7 {
    public static void main(String[] args) {
        int min = 120;
        int max = 300;
        
        int valido = busca_binaria(min, max);
        
        if (valido != -1) {
            System.out.println("Maior valor de i sem estouro de memória: " + valido);
            long prod = 1;
            for (int i = min; i <= valido; i++) { // calcula o produto até o maior valor possivel antes de estourar a memoria
                prod *= i;
                System.out.println("Produto: " + prod);
            }
        } else {
            System.out.println("Não há um valor válido de i sem estouro de memória.");
        }
        
        System.out.println("Programa Finalizado!");
    }
    
    public static int busca_binaria(int min, int max) { // procura maior valor valido
        int inicio = min;
        int fim = max;
        int ultimo = -1; // ultimo valor valido
        
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            long produto = Prod(min, meio);
            
            if (produto > 0) {
                ultimo = meio;
                inicio = meio + 1;
            } else {
                fim = meio- 1;
            }
        }
        
        return ultimo;
    }
    
    public static long Prod(int min, int meio) { // faz o produto até achar o valor q estoura a memoria
        long prod = 1;
        for (int i = min; i <= meio; i++) {
            prod *= i;
            if (prod < 0) { // Verificar se houve estouro de memória
                return -1;
            }
        }
        return prod;
    }
}