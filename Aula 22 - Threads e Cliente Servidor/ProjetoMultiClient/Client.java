package ProjetoMultiClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Client {
    private Socket clienSocket;
    private Scanner scanner;
    private PrintWriter saida;

    public Client(){
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException{
        clienSocket = new Socket(Server.ADDRESS, Server.PORT);
        saida = new PrintWriter(clienSocket.getOutputStream(), true);
        System.out.println("Cliente " + Server.ADDRESS + ":" + Server.PORT + " conectado!");
        messageLoop();
    }

    private void messageLoop() throws IOException{
        String msg;
        System.out.println("Aguardando mensagem para enviar ao servidor!");
        do{
            System.out.print("Digite uma mensagem para o servidor ou <sair> para finalizar: ");
            msg = scanner.nextLine();
            saida.println(msg);
        }while(!msg.equals("sair"));
    }

    public static void main(String[] args) {
        System.out.println("Console Cliente");
        try {
            Client client = new Client();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o cliente: " + e.getMessage());
        }
        System.out.println("Cliente finalizado!");
    }
}
