import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n = sc.nextInt();

        if( n % 10 == 0 && n % 5 == 0 && n % 2 == 0){
            System.out.println(n + " é divísel por 10, por 5 e por 2");
        } else {
            System.out.println(n + " não é divísel por 10, por 5 e por 2 simultaneamente");
        }
    }
}
