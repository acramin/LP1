
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o sexo [F / M]: ");
        String sexo = sc.nextLine();

        System.out.print("Digite a idade: ");
        int idade = sc.nextInt();

        sexo = sexo.toUpperCase();
        char f = sexo.charAt(0);

        if( idade < 25 && f == 'F'){
            System.out.println("ACEITA");
        } else {
            System.out.println("NÃO ACEITA");
        }


    }
}

//sexo.equals("F")