
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex10_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int num = sc.nextInt();
        System.out.print("Digite a base do logaritimo: ");
        int base = sc.nextInt();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("O logaritmo de " + num + " na base " + base + " é " +df.format(Math.log(num)/Math.log(base)));
    }
}
