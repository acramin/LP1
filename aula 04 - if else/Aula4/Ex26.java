import java.util.Scanner;

public class Ex26 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
         System.out.print("Digite o primeiro lado: ");
         int a = sc.nextInt();
         System.out.print("Digite o segundo lado: ");
         int b = sc.nextInt();
         System.out.print("Digite o terceiro lado: ");
         int c = sc.nextInt();

         if ((a + b > c) && (b + c > a ) && (a + c > b)){
            //System.out.println("É um triânngulo");
            if (a == b && b == c && c == a){
                System.out.println("Triangulo equilátero");
            }
            if ((a == b && a != c )|| (b == c && b != a ) || (c == a && c !=b)){
                System.out.println("Triangulo isósceles");
            }
            if ( a != b && a != c && b != c){
                System.out.println("Triangulo escaleno");
            }
         } else {
            System.out.println("Não é um triânngulo");
        }

    }
}
