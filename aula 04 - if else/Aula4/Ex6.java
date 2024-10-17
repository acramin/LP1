
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número qualquer: ");
        int n = sc.nextInt();

        if ( n == 20 ){
            System.out.println(n + " é igual a 20");
        } else {
            if ( n > 20){
                System.out.println(n + " é maior que 20");
            } else {
                System.out.println(n + " é menor que 20");
            }
        }

    }
}
