
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite um número qualquer: ");
    int n = sc.nextInt();

    if ( n > 20 && n < 90){
        System.out.println(n +  " está entre 20  e 90");
    } else {
        System.out.println(n + " não está entre 20 e 90");
    }

    }
}
