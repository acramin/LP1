import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        int b = sc.nextInt();
        
        if( a > b){
            System.out.println("O maior número é " + a);
        } else {
            System.out.println("O maior número é " + b);
        }
    }
}
