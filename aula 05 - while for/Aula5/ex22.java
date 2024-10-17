import java.util.Scanner;

public class ex22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Quantidade de numeros: ");
        int n = sc.nextInt();
        
        System.out.println("Esse sao os primeiros " + n + " numeros pares a partir de 2: ");
        for(int i = 1; i <= n; i ++){
            System.out.println(i*2);
        }
		sc.close();
    }
}
