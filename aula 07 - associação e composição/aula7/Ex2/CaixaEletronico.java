package Ex2;

import java.util.Scanner;

public class CaixaEletronico {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    Agencia agencia = new Agencia("Sbrebous", 7890, 5);
    ContaCorrrente contaCorrrente = new ContaCorrrente(1234, 4, agencia, 150);
    Cliente cliente = new Cliente("Ademar Apior", "123231518-12", contaCorrrente);

    int op = -2;
    double valor = 0.00;

    while(op != -1){
        System.out.println("\n*** Menu **** \n1- Sacar\n2- Depositar \n3- Consultar Saldo\n4- Imprimir Saldo\nDigite -1 para sair.");
        op = sc.nextInt();

        switch (op) {
            case 1:
                System.out.print("Valor que deseja sacar:  ");
                valor = sc.nextDouble();
                if(contaCorrrente.sacar(valor) == 0){
                    System.out.println("Não foi possível fazer o saque");
                }else{
                    System.out.println("Saque concluído");
                }
                break;
            case 2:
                System.out.print("Valor que deseja sacar:  ");
                valor = sc.nextDouble();
                contaCorrrente.depositar(valor);
                System.out.println("Deposito concluído");
                break;
            case 3:
                System.out.println("Saldo atual: " + contaCorrrente.consultarSaldo());
                break;
            case 4:
                System.out.println("Nome do cliente: " + cliente.getNome()  + "\nCpf: " + cliente.getCpf());
                System.out.println(contaCorrrente.imprimirSaldo());
                break;
            default:
                break;
        }
        }
        sc.close();
    }  
}





