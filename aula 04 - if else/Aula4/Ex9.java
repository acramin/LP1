import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n = sc.nextInt();

        if (n % 3 == 0){
            System.out.println(n + " é múltiplo de 3");
        } else {
            System.out.println(n + " não é mútiplo de 3");
        }
    }
}
