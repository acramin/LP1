import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex14_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a: ");
        double a = sc.nextDouble();
        System.out.print("Digite b: ");
        double b = sc.nextDouble();
        System.out.print("Digite c: ");
        double c = sc.nextDouble();

        DecimalFormat df = new DecimalFormat("0.00");

        double x = 2*((a-c)/8)-b*5;
        System.out.println("x = " + df.format(x));
    }
}
