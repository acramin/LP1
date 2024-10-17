// Ex1 

import java.util.Scanner;

public class Ex1_aula3 {

    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        double dias = DiasVivo(idade);
        System.out.println("Você está a " + dias + " vivo.");
    }

    public static double DiasVivo(int idade){
        double dias = idade*365.25;
        return dias;
    }
}