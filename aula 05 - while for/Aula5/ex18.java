import java.util.Scanner;

public class ex18 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
		System.out.print("Digite um número: "); 
		int n = sc.nextInt(); 
		
		if(n < 0){
			System.out.println("Não é possível calcular o fatorial de " + n);
		}
		else{
            int resp = fat(n); 
            System.out.print("fatorial de " + n + " = "  + resp); 
		}
		sc.close();
    }
    
    public static int fat(int n){
	    int resp = 1;
	    for(int i = 1; i <= n; i++){
	        resp = resp * i; 
	    }
	    return resp; 
	    
	} 
}

