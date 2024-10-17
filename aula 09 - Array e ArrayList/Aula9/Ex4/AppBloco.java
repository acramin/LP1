package Ex4;

import java.util.Scanner;

public class AppBloco {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BlocoDeNotas blocoDeNotas = new BlocoDeNotas();

        String nota = "";
        int op = 0;
        do {
            menu();
            op = sc.nextInt();
            sc.nextLine(); // limpa 

            switch (op) {
                case 1:
                    System.out.print("Digite a nota a ser inserida: ");
                    nota = sc.nextLine();
                    blocoDeNotas.inserirNota(nota);
                    break;
                case 2:
                    System.out.print("Digite a nota a ser removida: ");
                    nota = sc.nextLine();
                    blocoDeNotas.removerNota(nota);
                    break;
                case 3:
                    System.out.print("Digite a nota a ser buscada: ");
                    nota = sc.nextLine();
                    blocoDeNotas.buscarNota(nota);
                    break;
                case 4:
                    blocoDeNotas.imprimirNotas();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 5);

        sc.close();
    }

    public static void menu(){
        System.out.println("\n*****Menu*****");
        System.out.println("1) Inserir uma nota");
        System.out.println("2) Remover uma nota");
        System.out.println("3) Buscar uma nota");
        System.out.println("4) Listar todas as notas");
        System.out.println("5) Sair do sistema");
        System.out.print("Escolha uma opção: ");
    }
}