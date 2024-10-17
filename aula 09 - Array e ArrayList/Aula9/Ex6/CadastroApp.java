package Ex6;

import java.util.Scanner;

public class CadastroApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BancoDeClientes bancoDeClientes = new BancoDeClientes();

        int op = 0;
        
        while (op != 6) {
            menu();
            op = sc.nextInt();
            sc.nextLine(); // limpa

            switch (op) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String fone = sc.nextLine();
                    System.out.print("ID do cliente: ");
                    int id = sc.nextInt();
                    bancoDeClientes.inserirCliente(new Cliente(nome, fone, id)); // instancia cliente dentro do inserirCliente
                    break;
                case 2:
                    System.out.print("ID do cliente a ser removido: ");
                    int idRemover = sc.nextInt();
                    bancoDeClientes.removerCliente(idRemover);
                    break;
                case 3:
                    System.out.print("ID do cliente a ser alterado: ");
                    int idAlterar = sc.nextInt();
                    sc.nextLine(); // limpa
                    System.out.print("Novo nome do cliente: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo telefone do cliente: ");
                    String novoFone = sc.nextLine();
                    bancoDeClientes.alterarCliente(idAlterar, novoNome, novoFone);
                    break;
                case 4:
                    System.out.print("ID do cliente a ser listado: ");
                    int idListar = sc.nextInt();
                    bancoDeClientes.listarCliente(idListar);
                    break;
                case 5:
                    bancoDeClientes.listarTodosClientes();
                    break;
                case 6:
                    System.out.println("Encerrando Programa");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
    
    public static void menu(){
        System.out.println();
        System.out.println("***Menu***");
        System.out.println("1. Inserir Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Alterar Cliente");
        System.out.println("4. Listar Dados de um Cliente");
        System.out.println("5. Listar Dados de Todos os Clientes");
        System.out.println("6. Sair");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }
}
