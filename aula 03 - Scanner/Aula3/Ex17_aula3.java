import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex17_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int num = sc.nextInt();

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("número digitado: " + num);
        System.out.println("" + num + " ao quadaro = " + Math.pow(num, 2));
        System.out.println("raiz de " + num + " = " + df.format(Math.sqrt(num)));
    }
}
