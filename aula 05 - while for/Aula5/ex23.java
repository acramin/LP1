
import java.util.Scanner;

public class ex23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int qtd = -1;
        double total = 0;
        
        while(qtd != 0){
            System.out.print("Quantidade de itens: ");
            qtd = sc.nextInt();
            
            while(qtd < 0){
                System.out.println("Insira valores positivos para a quantidade");
                System.out.print("Quantidade de itens: ");
                qtd = sc.nextInt();
            }
            
            
            if( qtd != 0){
                System.out.print("Preco do produto: ");
                double p = sc.nextDouble();
                if(p > 0){
                    total = total + p;  
                } else{
                    while(p < 0){
                    System.out.println("Insira valores positivos de preco");
                    System.out.print("Preco do produto: ");
                    p = sc.nextDouble();
                    if(p > 0){
                        total = total + p;
                    }
                    }

                }
                
            }
        
        }
        System.out.println("O preco total a ser pago eh de: " + total);
		sc.close();
    }
}
