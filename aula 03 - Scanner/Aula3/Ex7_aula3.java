import java.util.Scanner;

public class Ex7_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um núemro de 5 digitos: ");
        int num = sc.nextInt();
        String n = "" + num;
        System.out.println("O algarismo da dezena é " + n.charAt(3));
    }
}
