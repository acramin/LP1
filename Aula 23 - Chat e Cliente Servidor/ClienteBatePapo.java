import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteBatePapo implements Runnable{
    private SocketCliente clientSocket;
    private Scanner scanner;

    public ClienteBatePapo() {
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException{
        try {
            clientSocket = new SocketCliente(new Socket(ServidorBatePapo.ADRESS, ServidorBatePapo.PORT));
            new Thread(this).start();
            messageLoop();
        } finally {
            clientSocket.close();
        }
    }

    @Override  
    public void run() {
        String msg;
        while((msg = clientSocket.getMessage()) != null){
            System.out.printf("\n -> %s\n", msg);
            System.out.println("Digite sua mensagem (ou <sair> para finalizar): \\n" + //
                                " <- ");
        }
    }

    private void messageLoop() throws IOException{
        String msg;
        System.out.println("Digite sua mensagem (ou <sair> para finalizar): ");
        do {
            System.out.println(" <- ");
            msg = scanner.nextLine();
            clientSocket.sendMessage(msg);
        } while(!msg.equalsIgnoreCase("sair"));
    }

    public static void main(String[] args) {
        System.out.println("Console do Cliente");
        try{
            new ClienteBatePapo().start();
        } 
        catch (IOException e) {
            System.out.println("Erro ao iniciar o cliente: " + e.getMessage());
        }
        System.out.println("Cliente finalizado");
    }

}
