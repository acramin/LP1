import java.util.Scanner;

public class Ex22 {
    public static void main(String[] args) {
                
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo núemro: ");
        int n2 = sc.nextInt();
        System.out.print("Digite o terceiro núemro: ");
        int n3 = sc.nextInt();

        int maior;

        if(n1>n2 && n1>n3){
            maior = n1;
            System.out.println("O número armazenado foi " + maior);
        }
        if(n2>n1 && n2> n3){
            maior = n2;
            System.out.println("O número armazenado foi " + maior);
        }
        if(n3>n1 && n3>n2){
            maior = n3;
            System.out.println("O número armazenado foi " + maior);
        }


    }
}
