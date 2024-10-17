import java.text.DecimalFormat;
import java.util.Scanner;


public class Ex3 {
    
    public static void main(String[] args) {
    
    DecimalFormat df = new DecimalFormat("0.00");
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite um número qualquer: ");
    double n = sc.nextDouble();

    if( n >= 0){
        System.out.println("A raiz de " + n + " é: " + df.format(Math.sqrt(n)));
    } else {
        if (n < 0){
            System.out.println("O quadrado de " +  n + " é: " + df.format(Math.pow(n, 2)));
        }
    }

    }

}
