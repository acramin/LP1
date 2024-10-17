import java.util.Scanner;

public class Ex25 {
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
         System.out.print("Digite o primeiro ladao: ");
         int a = sc.nextInt();
         System.out.print("Digite o segundo lado: ");
         int b = sc.nextInt();
         System.out.print("Digite o terceiro lado: ");
         int c = sc.nextInt();

         if ((a + b > c) && (b + c > a ) && (a + c > b)){
            System.out.println("É um triânngulo");
         } else {
            System.out.println("Não é um triânngulo");
        }
    }
}


