import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int  op = -1;
        // int i = 0; // contador de números
        int qtd = 0; // quantidade de números entre 100 e 200

        while (op != 0){

            System.out.print("Digite um número ou 0 para sair: ");
            op = sc.nextInt();
            // i ++; // 1+ número digitado

            if( op > 100 && op < 200){
                qtd++;
            }

        }
        System.out.println("Quantidade de números entre 100 e 200: " +  qtd);
        sc.close();
    }
}
