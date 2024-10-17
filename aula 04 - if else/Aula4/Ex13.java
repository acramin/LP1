import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número de 3 digitos: ");
        int n = sc.nextInt();
        
        n = Math.abs(n);
        //System.out.println(n);

        String N = "" + n;
        //System.out.println(N);

        String dezena = N.substring(1, 2);
        //System.out.println(dezena);

        int d = Integer.parseInt(dezena);

        if(d % 2 == 0){
            System.out.println("O valor da dezena é par");
        } else {
            System.out.println("O valor da dezena é ímpar");
        }
    }
}
