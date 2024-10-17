import java.util.Scanner;

public class Ex28 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite um nome: ");
        String nome = sc.nextLine();
        
        char l = nome.toLowerCase().charAt(0); // Convertendo para minúscula para evitar a necessidade de múltiplas condições
        int letra = (int) l;
        
        if(letra >= 97 && letra <= 107){ // A a K -> D1
            System.out.println("D1");
        }
        else if(letra >= 108 && letra <= 110){ // L a N -> D2
            System.out.println("D2");
        }
        else if(letra >= 111 && letra <= 122){ // O a Z -> D3
            System.out.println("D3");
        }

    }
}
