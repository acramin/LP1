// Ex2 

import java.util.Scanner;

public class Ex2_aula3{

    public static void main(String[] args){
        Scanner sc  =  new Scanner(System.in);
        System.out.print("Digite a base: ");
        double base = sc.nextInt();
        System.out.print("Digite a altura: ");
        double altura = sc.nextInt();
        double area = base * altura;
        System.out.println("Área = " + area);
    }
}