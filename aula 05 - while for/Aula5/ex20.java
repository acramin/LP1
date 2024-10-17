import java.util.Scanner;

public class ex20 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i <20; i ++){
            
            System.out.println("Pessoa " + (i+1) + " :");

            System.out.print("nome: ");
            String nome = sc.nextLine();
        
            System.out.print("sexo: ");
            String sexo = sc.nextLine();
            sexo = sexo.toUpperCase();
            
            char s = sexo.charAt(0);
            
            System.out.print("idade: ");
            int idade = sc.nextInt();

            sc.nextLine();        

            if(idade > 21 && s == 'M'){
                System.out.println(nome + " tem mais de 21 anos.");
                //System.out.println("ENTROU");
            }
        }
        
		sc.close();
    }
}

