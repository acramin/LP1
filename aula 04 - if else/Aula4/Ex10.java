import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n = sc.nextInt();

        if ( n % 5 == 0){
            System.out.println(n + " é divísível por 5");
        } else {
            System.out.println(n + " não é divisível por 5");
        }
    }
}
