import java.util.Scanner;

public class Ex24 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int maior = 0;
        int menor = 0;

        for (int i = 0; i < 5 ; i++){
            System.out.print("Digite o número " + ( i + 1 ) + " : ");
            int n = sc.nextInt();
            
            if(i == 0 ){
                maior = menor = n;
            }
            if(n > maior){
                maior = n;
            }
            if (n < menor){
                menor = n;
            }

        }

        System.out.println("O maior número é " + maior);
        System.out.println("O menor núemro é " + menor);

    }
}
