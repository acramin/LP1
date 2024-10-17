/**
 * Ex1
 */

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        int b = sc.nextInt();

        if( (a+b) > 10){
            System.out.println("A soma é: " + (a+b));
        } else{
		    System.out.println("Valor da soma é menor que 10.");
		}

    }

}