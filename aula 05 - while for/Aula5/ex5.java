import java.text.DecimalFormat;
import java.util.Scanner;


public class ex5 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0000");

        int  op = 0;

        while (op != -999){

            System.out.print("Digite um número ou -999 para sair: ");
            op = sc.nextInt();

            if( op > 0){
                System.out.println("Raiz de " + op  + ": " + df.format(Math.sqrt(op)));
                
                System.out.println("Inverso de " + op +  ": " + ( double) 1 /op);
            } else if(op == -999) { 
                break;
            } else {
                System.out.println("Não foi possível calcular a raiz de "  + op);
                System.out.println("Inverso de " + op + ": " + ( double) 1 /op);
            }

        }
        System.out.println("Programa Finalizado!");
        sc.close();
    }

}
