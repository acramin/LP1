
import java.util.Scanner;

public class ex25 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op = 0;
        
        
        while(op != 9){
            System.out.print("\nDigite o primeiro numero: ");
            double a = sc.nextInt();
            System.out.print("Digite o segundo numero: ");
            double b = sc.nextInt();
            System.out.println();
            System.out.println("Operacoes Disponiveis: \n1.Adicao \n2.Subtracao \n3.Multiplicacao \n4.Divisao \n9.Sair do programa\n");
            System.out.print("Digite a opcao desejada: ");
            op  = sc.nextInt();
            
            switch(op){
                case 1:
                    System.out.println(a + " + " + b + " = " + (a+b));
                    break;
                case 2:
                    System.out.println(a + " - " + b + " = " + (a-b));
                    break;
                case 3: 
                    System.out.println(a + " x " + b + " = " + (a*b));
                    break;
                case 4:
                    System.out.println(a + " / " + b + " = " + (a/b));
                    break;
                case 9:
                    System.out.println("Programa Encerrado");
                    break;
            }
            
        }
        sc.close();


    }
}
