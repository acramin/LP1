import java.util.Scanner;

public class ex17 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Temperatura mínima: ");
        int lim_inf = sc.nextInt();
        
        System.out.print("Temperatura máxima: ");
        int lim_sup = sc.nextInt();
        
        System.out.print("Espaçamento entre as temperaturas: ");
        int inc = sc.nextInt();
        
        
        for(int i = lim_inf; i <= lim_sup; i = i + inc){
            System.out.println(i + " °C = " + (double)( 9*i/5 + 32) + " °F");
        }
        sc.close();
    }
}

