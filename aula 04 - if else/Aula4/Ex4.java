
import java.util.Scanner;

public class Ex4 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        int b = sc.nextInt();
        System.out.print("Digite o terceiro número: ");
        int c = sc.nextInt();

        if( a > b && a > c){
            if( b > c){
                System.out.println( c + " < " + b +  " < " + a);
            } else {
                System.out.println(b + " < " + c  + " < " + a);
            }
        } else {
            if (b > a && b > c){
                if ( a > c ) {
                    System.out.println(c + " < " + a +  " < " + b);
                } else {
                    System.out.println(a + " < " + c + " < " + b);
                }
            } else {
                if (c > a && c > b ) {
                    if (a > b){
                        System.out.println(b + " <  " + a + " < " + c);
                    } else {
                        System.out.println(a + " < " + b  + " < " + c);
                    }
                }
            }
        } 


    }

}
