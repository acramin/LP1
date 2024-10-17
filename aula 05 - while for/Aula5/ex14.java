import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = Integer. MIN_VALUE;
        int maior = Integer. MIN_VALUE;

        while (n != -999){
            
            System.out.print("Digite um número: ");
            n = sc.nextInt();
            if(n != -999){
                
                if(maior < n){
                    maior = n;
                }
            }
        }
        
        System.out.println("O maior número é " + maior);
        sc.close();
    }
}

