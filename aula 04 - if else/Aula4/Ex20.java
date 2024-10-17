import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo núemro: ");
        int n2 = sc.nextInt();

        if( n1 > n2  ){
            if (n1 > 0){
                System.out.println("A raiz quadrada de " +  n1 + " é " + Math.sqrt(n1));
                System.out.println("O quadrado de " + n2 + " é " + Math.pow(n2, 2));
            } else {
                System.out.println("Não é possível extrair a  raiz de " +  n1);
                System.out.println("O quadrado de " + n2 + " é " + Math.pow(n2, 2));
            }
        } else {
            if (n2 > 0){
                System.out.println("A raiz quadrada de " +  n2 + " é " + Math.sqrt(n2));
                System.out.println("O quadrado de " + n1 + " é " + Math.pow(n1, 2));
            } else {
                System.out.println("Não é possível extrair a  raiz de " +  n2);
                System.out.println("O quadrado de " + n1 + " é " + Math.pow(n1, 2));
            } 
        }
    }
}

