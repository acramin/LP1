
import java.util.Scanner;

public class Ex2 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Digite o sugundo número: ");
        int b = sc.nextInt();

        if((a+b) <= 20){
            System.out.println("A soma de (" + a + ") + (" + b + ") -5 é: " + (a+b-5));
        }else {
            System.out.println("Valor da soma maior que 20.");
        }

    }

}
