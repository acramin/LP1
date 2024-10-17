
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex9_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int num = sc.nextInt();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Log de " + num + " é " + df.format(Math.log10(num)));
    }
}
