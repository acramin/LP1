import java.util.Scanner;

public class Ex27 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um verbo: ");
        String v = sc.nextLine();
        
        String fim = v.substring(v.length() - 2, v.length());
        //System.out.println(fim);
        char f = fim.charAt(fim.length()- 1);
        
        if(fim.equals("ar")){
            System.out.println("1° conjugação (ar)");
        } else
        if(fim.equals("er")){
            System.out.println("2° conjugação (er)");
        } else
        if(fim.equals("ir")){
            System.out.println("3° conjugação (ir)");
        } else
        if(fim.equals("or") || fim.equals("ur")){
            System.out.println("Provavelmente nem é verbo (terminados em 'or' ou 'ur')");
        } else 
        if (f != 'r'){ 
            System.out.println("Não está no infinitivo (não termina em r)");
        }

    }
}
