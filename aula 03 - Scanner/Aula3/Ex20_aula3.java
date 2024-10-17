import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex20_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite lado 1: ");
        double lado1 = sc.nextDouble();
        System.out.print("Digite lado 2: ");
        double lado2 = sc.nextDouble();
        System.out.print("Digite o ângulo entre os lados 1 e 2: ");
        double ang = sc.nextDouble();

        DecimalFormat df = new DecimalFormat("0.00");

        double lado3 = Math.sqrt(lado1 * lado1 + lado2 * lado2 - 2 * lado1 * lado2 * Math.cos(Math.toRadians(ang)));
        System.out.println("Valor do lado 3 = " + df.format(lado3));
    }
}
