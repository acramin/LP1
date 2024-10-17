import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int  op = 0;

        while (op != -999){

            System.out.print("Digite um número ou -999 para sair: ");
            op = sc.nextInt();

            if(op == -999) { 
                break;
            }else{
                if( op > 0){
                    for(int i = op; i > 0 ; i--){
                        if(op % i == 0){
                            System.out.println("divisor de "+ op + " = " + i);
                        }
                    }
                } else {
                    for(int i = op; i < 0 ; i++){
                        if(op % i == 0){
                            System.out.println("divisor de "+ op + " = " + i);
                        }
                    }
                }
                
            }
        }
        System.out.println("Programa Finalizado!");
        sc.close();
    }
}
