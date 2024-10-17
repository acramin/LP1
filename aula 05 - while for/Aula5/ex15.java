import java.util.Scanner;

public class ex15 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int n = sc.nextInt();
        int aux1 = 1;
        int aux2 = 1;
        
        System.out.println("Fibonacci até " + n + ": ");
        while(aux2 <= n){
            int prox = aux1 + aux2;
            if(prox <= n){
                System.out.println(prox);
            }
            aux1 = aux2;
            aux2 = prox;
        }
        
        sc.close();
    }
}

