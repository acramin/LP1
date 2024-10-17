import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex18_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite valor da base: ");
        double b = sc.nextDouble();
        System.out.print("Digite valor da altura: ");
        double h = sc.nextDouble();
        double area = (b*h)/2;

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Área do triângulo: " + df.format(area));
    }
}
