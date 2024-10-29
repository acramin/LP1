import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;


public class ServidorBatePapo {
    
    public static final String ADRESS = "127.0.0.1";
    public static final int PORT = 3334;
    private ServerSocket serverSocket;
    private final List<SocketCliente> clients = new LinkedList<>();

    public void start() throws IOException{
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado na porta " + PORT);
        clientConnectionLoop();
    }

    private void clientConnectionLoop() throws IOException{
        System.out.println("Aguardando conexao de um cliente");
        while(true){
            SocketCliente clientSocket = new SocketCliente(serverSocket.accept());
            clients.add(clientSocket);
            new Thread(() -> clientMessageLoop(clientSocket)).start();
        }
    }

    private void clientMessageLoop(SocketCliente clientSocket){
        String msg;
        try{
            while((msg = clientSocket.getMessage()) != null){
                if("sair".equalsIgnoreCase(msg)) return;
                System.out.println("Mensagem recebida de " + clientSocket.getRemoteSocketAddress() + ": " + msg);
                sendMsgToAll(clientSocket, msg);
            }
        } 
        finally{
            clientSocket.close();
        }
    }

    private void sendMsgToAll(SocketCliente sender, String msg){
        Iterator<SocketCliente> iterator = clients.iterator();
        while(iterator.hasNext()){
            SocketCliente clientSocket = iterator.next();
            if(!sender.equals(clientSocket)){
                if(!clientSocket.sendMessage("Cliente " + sender.getRemoteSocketAddress() + ": " + msg)){
                    iterator.remove();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Console do Servidor");
        try{
            new ServidorBatePapo().start();
        } 
        catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
        System.out.println("Servidor encerrado");
    }

}
