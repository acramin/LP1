import java.util.Scanner;

public class Ex16_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o dividendo: ");
        int dividendo = sc.nextInt();

        System.out.print("Digite o divisor: ");
        int divisor = sc.nextInt();

        double quociente = dividendo / divisor;

        double resto = dividendo % divisor;

        System.out.println("Dividendo: " + dividendo);
        System.out.println("Divisor: " + divisor);
        System.out.println("Quociente: " + quociente);
        System.out.println("Resto: " + resto);
    }
}
