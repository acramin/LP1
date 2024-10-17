
import java.util.Scanner;

public class Ex11_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite primeira frase: ");
        String frase1 = sc.nextLine();
        String  trecho4= frase1.substring(0, frase1.length()/2);
        String  trecho6= frase1.substring(frase1.length()/2, frase1.length());

        System.out.print("Digite segunda frase: ");
        String frase2 = sc.nextLine();
        String  trecho1= frase2.substring(0, frase2.length()/2);
        String  trecho3= frase2.substring(frase2.length()/2, frase2.length());

        System.out.print("Digite terceira frase: ");
        String frase3 = sc.nextLine();
        String  trecho5 = frase3.substring(0, frase3.length()/2);
        String  trecho2 = frase3.substring(frase3.length()/2, frase3.length());

        System.out.println("Original: " + frase1 + " " + frase2 +  " " + frase3);
        System.out.println("Embaralhado: " + trecho1 + " " + trecho2 + " " + trecho3 + " " + trecho4 + " " + trecho5 + " "+ trecho6);


    }






}
