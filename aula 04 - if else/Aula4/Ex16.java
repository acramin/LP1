import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo núemro: ");
        int n2 = sc.nextInt();

        if( n1 == n2 ){
            System.out.println("Os número inseridos são iguais.");
        } else {
            System.out.println("Os número inseridos são diferentes.");
        }
    }
}
