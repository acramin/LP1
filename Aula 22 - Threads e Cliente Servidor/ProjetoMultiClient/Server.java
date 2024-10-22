package ProjetoMultiClient;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static final String ADDRESS = "127.0.0.1";
    public static final int PORT = 3334;
    private ServerSocket serverSocket;

    public void start() throws IOException{
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado em " + ADDRESS + ":" + PORT);
        clientConnectionLoop();
    }

    private void clientConnectionLoop() throws IOException{
        System.out.println("Aguardando conexao de um cliente!");
        do{
            ClientSocket clientSocket = new ClientSocket(serverSocket.accept());
            new Thread(()-> clientMessageLoop(clientSocket)).start();
        }while(true);
    }

    public void clientMessageLoop(ClientSocket clientSocket){
        String msg;
        try{
            while((msg = clientSocket.getMessage()) != null && !msg.equals("sair")){
                System.out.printf("Mensagem recebida do cliente %s: %s\n",  clientSocket.getRemoteSocketAddress(), msg);
            }
        } finally {
            clientSocket.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("Console Servidor");
        try {
            Server server = new Server();
            server.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
        System.out.println("Servidor finalizado!");
    }


}

/*
 * A classe Server é responsável por aceitar conexões de clientes e criar uma
 * thread para cada cliente. Ela possui um método start() que cria um socket
 * para aguardar conexões de clientes e um método clientConnectionLoop() que
 * cria uma thread para cada cliente conectado. O método clientMessageLoop()
 * recebe mensagens do cliente e imprime no console. O servidor finaliza quando
 * o usuário digitar a mensagem sair.
 */