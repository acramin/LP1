import java.util.Scanner;

public class Ex23 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        int b = sc.nextInt();
        System.out.print("Digite o terceiro número: ");
        int c = sc.nextInt();

        int maior, intermediario, menor;

        if( a > b && a > c){
            if( b > c){
                maior = a;
                intermediario = b;
                menor = c;
                System.out.println("maior = " + maior);
                System.out.println("intermediario = " + intermediario);
                System.out.println("menor = " + menor);
            } else {
                maior = a;
                intermediario = c;
                menor = b;
                System.out.println("maior = " + maior);
                System.out.println("intermediario = " + intermediario);
                System.out.println("menor = " + menor);
            }
        } else {
            if (b > a && b > c){
                if ( a > c ) {
                    maior = b;
                    intermediario = a;
                    menor = c;
                    System.out.println("maior = " + maior);
                    System.out.println("intermediario = " + intermediario);
                    System.out.println("menor = " + menor);
                } else {
                    maior = b;
                    intermediario = c;
                    menor = a;
                    System.out.println("maior = " + maior);
                    System.out.println("intermediario = " + intermediario);
                    System.out.println("menor = " + menor);
                }
            } else {
                if (c > a && c > b ) {
                    if (a > b){
                        maior = c;
                        intermediario = a;
                        menor = b;
                        System.out.println("maior = " + maior);
                        System.out.println("intermediario = " + intermediario);
                        System.out.println("menor = " + menor);
                    } else {
                        maior = c;
                        intermediario = b;
                        menor = a;
                        System.out.println("maior = " + maior);
                        System.out.println("intermediario = " + intermediario);
                        System.out.println("menor = " + menor);
                    }
                }
            }
        } 




    }
}
