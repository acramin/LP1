import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo núemro: ");
        int n2 = sc.nextInt();

        if( n1 > n2){
            System.out.println(n2 + " < " + n1);
        }else{
            System.out.println(n1 + " < " + n2);
        }
    }
}
