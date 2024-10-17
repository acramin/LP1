import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex15_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o raio r: ");
        double r = sc.nextDouble();
        double pi = 3.14159;

        DecimalFormat df = new DecimalFormat("0.00");
        double area = pi*r*r;
        System.out.println("Área do circulo de raio " + r + " = " +  df.format(area));
    }
}
