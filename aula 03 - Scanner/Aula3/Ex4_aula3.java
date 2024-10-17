// Ex4

import java.util.Scanner;

public class Ex4_aula3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("String 1: ");
        String a1 = sc.nextLine();
        System.out.print("String 2: ");
        String a2 = sc.nextLine();
        System.out.print("String 3: ");
        String a3 = sc.nextLine();

        int tam = a1.length() + a2.length() + a3.length(); 
        System.out.println("Comprimento total das Strings = " + tam);
    }
}