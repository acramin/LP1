import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = 1;
        int j = 0;

        while (n > 0){

            System.out.print("Digite um número: ");
            n = sc.nextInt();
            if(n > 0){
                if(primo(n)){
                    j ++;
                }
            }
        }
        
        System.out.println("Foram digitados " + j + " números primos.");
        sc.close();
    }
    
    public static boolean primo (int n){
        if (n == 1 || n == 0) return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}

