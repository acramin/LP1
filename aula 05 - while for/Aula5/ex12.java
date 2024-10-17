import java.util.Scanner;

public class ex12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (n != -1){
            
            System.out.print("Digite um número ou -1 para sair: ");
            n = sc.nextInt();
            if(n != -1){
                if(primo(n)){
                    System.out.println(n + " é primo");
                } else {
                    System.out.println(n + " não é primo");
                }
            }
        }
        System.out.println("Programa Finalizado!");
        sc.close();
    }
    
    public static boolean primo (int n){
        if (n == 1 || n == 0 || n < 0) return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}

