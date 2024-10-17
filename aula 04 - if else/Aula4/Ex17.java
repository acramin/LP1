import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo núemro: ");
        int n2 = sc.nextInt();

        if( n1 > n2){
            System.out.println(n2 + " é o menor número");
        }else{
            System.out.println(n1 + " é o menor número");
        }
        

    }
}
