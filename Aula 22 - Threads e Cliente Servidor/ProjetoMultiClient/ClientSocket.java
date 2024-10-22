package ProjetoMultiClient;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientSocket {
    private final Socket socket;
    private final BufferedReader entrada;
    private final PrintWriter saida;

    public ClientSocket(final Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("Cliente " + socket.getRemoteSocketAddress() + " conectado!");
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        saida = new PrintWriter(socket.getOutputStream(), true);
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close(){
        try {
            entrada.close();
            saida.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar o socket do cliente: " + e.getMessage());
        }
    }

    public String getMessage() {
        try{
            return entrada.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean sendMessage(String msg){
        saida.println(msg);
        return !saida.checkError();
    }
}

/*
 * A classe ClientSocket é responsável por encapsular o socket do cliente. Ela
 * possui métodos para enviar e receber mensagens do servidor. O método
 * getRemoteSocketAddress() retorna o endereço do cliente. O método close() fecha
 * o socket do cliente. O método getMessage() retorna a próxima mensagem do
 * cliente. O método sendMessage() envia uma mensagem para o cliente.
 */
