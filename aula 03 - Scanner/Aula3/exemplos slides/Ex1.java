//Ex1

import java.util.Scanner;

public class Ex1{
    public static void main(String[] args) {
      Scanner sc  =  new Scanner(System.in);
      System.out.println("Nome do comprador: ");
      String nome = sc.nextLine();
      System.out.println("Produto adquirido: ");
      String produto = sc.nextLine();
      System.out.println("Quantidade do produto: ");
      int quantidade = sc.nextInt();
      System.out.println("Preço unitário: ");
      Double preco = sc.nextDouble();
      System.out.println("Comprador " + nome + " adquiriu " + quantidade + " " + produto + " que custavam " + preco + " cada." );
    }
}