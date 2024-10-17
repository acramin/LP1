import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número de 4 digitos: ");
        int n = sc.nextInt();

        n = Math.abs(n);
        String N = "" + n;
        //System.out.println(N);

        String uc = N.substring(0, 2);
        //System.out.println(dezena);

        int d = Integer.parseInt(uc);

        if(d % 4 == 0){
            System.out.println("O valor formado pela unidade de milhar e pela centena é múltiplo de 4");
        } else {
            System.out.println("O valor formado pela unidade de milhar e pela centena não é múltiplo de 4");
        }
    }
}
