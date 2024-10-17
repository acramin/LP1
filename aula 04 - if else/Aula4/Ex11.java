import java.util.Scanner;

public class Ex11 {
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n = sc.nextInt();

        if ( n % 3 == 0 && n % 7  == 0){
            System.out.println(n + " é divisível por 3 e por 7");
        } else {
            System.out.println(n + " não é divisível por 3 e por 7");
        }

    }

}
