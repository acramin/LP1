import java.util.Scanner;

public class ex21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Valor máximo: ");
        int lim_sup = sc.nextInt();
        
        
        for(int i = 1; i < lim_sup; i = i+2){
            System.out.println(i);
        }
		sc.close();
    }
}
