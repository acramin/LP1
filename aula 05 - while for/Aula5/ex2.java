import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op = 0;
        int soma = 0;
        int i = 0; // contador de números


        while (op != -1){

            System.out.print("Digite um número positivo ou -1 para sair: ");
            op = sc.nextInt();

            if(op < 0 && op != -1){
                System.out.println("O número precisa ser positivo! ");
                continue;
            }
            
            if(op != -1 ){
                i ++; // 1+ número digitado
                soma = soma + op; // soma números
                //System.out.println("Soma: " + soma);
            }

        }
        if( i == 0){
            System.out.println("Nenhum valor foi inserido.");
        } 
        else{
            double med = (double) soma / i; // média dos números digitados
            System.out.println("Média: " +  med);
        }
        
        sc.close(); 
    }
}
