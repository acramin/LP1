import java.util.Scanner;

public class ex19 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        System.out.print("Valor máximo: ");
        int lim_sup = sc.nextInt();
        
        System.out.print("Espaçamento entre valores: ");
        int inc = sc.nextInt();
        
        for(int i =0; i <= lim_sup; i = i + inc){
            System.out.println(i);
        }
		sc.close();
    }
}

