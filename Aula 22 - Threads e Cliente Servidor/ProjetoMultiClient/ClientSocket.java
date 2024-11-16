package ProjetoMultiClient;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Classe que encapsula a lógica de comunicação entre o servidor e um cliente.
 * Fornece métodos para enviar e receber mensagens, bem como gerenciar o socket do cliente.
 */
public class ClientSocket {
    private final Socket socket; // Socket associado ao cliente.
    private final BufferedReader entrada; // Stream para entrada de mensagens do cliente.
    private final PrintWriter saida; // Stream para saída de mensagens para o cliente.

    /**
     * Construtor que inicializa o socket do cliente e os streams de entrada e saída.
     * Também exibe uma mensagem informando a conexão do cliente.
     *
     * @param socket o socket do cliente conectado.
     * @throws IOException se houver erro ao inicializar os streams.
     */
    public ClientSocket(final Socket socket) throws IOException {
        this.socket = socket; // Associa o socket do cliente.
        System.out.println("Cliente " + socket.getRemoteSocketAddress() + " conectado!");
        // Inicializa o leitor para receber mensagens.
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Inicializa o escritor para enviar mensagens.
        saida = new PrintWriter(socket.getOutputStream(), true);
    }

    /**
     * Retorna o endereço remoto do cliente conectado.
     *
     * @return o endereço remoto do cliente.
     */
    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    /**
     * Fecha os streams de entrada, saída e o socket do cliente.
     * Trata possíveis exceções que possam ocorrer durante o fechamento.
     */
    public void close() {
        try {
            entrada.close(); // Fecha o stream de entrada.
            saida.close(); // Fecha o stream de saída.
            socket.close(); // Fecha o socket.
        } catch (IOException e) {
            System.out.println("Erro ao fechar o socket do cliente: " + e.getMessage());
        }
    }

    /**
     * Lê a próxima mensagem enviada pelo cliente.
     * Retorna null se ocorrer um erro ou se o cliente desconectar.
     *
     * @return a mensagem enviada pelo cliente, ou null em caso de erro.
     */
    public String getMessage() {
        try {
            return entrada.readLine(); // Lê uma linha do cliente.
        } catch (IOException e) {
            return null; // Retorna null em caso de erro.
        }
    }

    /**
     * Envia uma mensagem para o cliente.
     *
     * @param msg a mensagem a ser enviada.
     * @return true se a mensagem foi enviada com sucesso, false caso contrário.
     */
    public boolean sendMessage(String msg) {
        saida.println(msg); // Envia a mensagem ao cliente.
        return !saida.checkError(); // Verifica se houve algum erro ao enviar.
    }
}

/*
 * Resumo do funcionamento:
 * - A classe ClientSocket encapsula a comunicação entre o servidor e um cliente específico.
 * - getRemoteSocketAddress(): retorna o endereço do cliente conectado.
 * - close(): encerra os streams e o socket do cliente, liberando recursos.
 * - getMessage(): recebe mensagens do cliente. Retorna null em caso de erro.
 * - sendMessage(): envia mensagens ao cliente e verifica se o envio foi bem-sucedido.
 *
 * Uso:
 * - Essa classe simplifica a interação entre o servidor e os clientes ao encapsular
 *   a lógica de comunicação, tornando o código mais organizado e modular.
 */
