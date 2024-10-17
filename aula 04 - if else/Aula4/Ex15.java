import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ano de nascimento: ");
        int nascimento = sc.nextInt();
        System.out.print("Digite o ano atual: ");
        int atual = sc.nextInt();

        if ( nascimento < atual){
            System.out.println("Idade: "  + (atual - nascimento));
        } else {
            System.out.println("Ano de nascimento inválido");
        }

    }
}
