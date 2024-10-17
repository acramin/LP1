import java.util.Scanner;

public class Ex21 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo núemro: ");
        int n2 = sc.nextInt();
        System.out.print("Digite o terceiro núemro: ");
        int n3 = sc.nextInt();

        if(n1>n2 && n1>n3){
            System.out.println(n1 + " é o maior número");
        }
        if(n2>n1 && n2> n3){
            System.out.println(n2 + " é o maior número");
        }
        if(n3>n1 && n3>n2){
            System.out.println(n3 + " é o maior número");
        }
    }
}
