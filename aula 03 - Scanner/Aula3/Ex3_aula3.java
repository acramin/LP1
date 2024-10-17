/**
 * Ex3_aula3
 */

import java.util.Scanner;

public class Ex3_aula3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int num = sc.nextInt();
        System.out.println(""+ (double)num + " elevado ao qudrado = " + Math.pow((double)num, 2));
    }
}