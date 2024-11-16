package ProjetoMultiClient;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Classe principal do servidor em um sistema de comunicação multi-cliente.
 * Responsável por gerenciar conexões e troca de mensagens com os clientes.
 */
public class Server {
    // Constantes para o endereço IP e porta do servidor.
    public static final String ADDRESS = "127.0.0.1"; // Endereço local (localhost).
    public static final int PORT = 3334; // Porta de comunicação.

    // Socket do servidor para aceitar conexões de clientes.
    private ServerSocket serverSocket;

    /**
     * Método principal que inicia o servidor.
     * Cria o socket do servidor e entra no loop de conexão com clientes.
     *
     * @throws IOException se ocorrer algum erro ao criar o socket.
     */
    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT); // Inicializa o ServerSocket na porta especificada.
        System.out.println("Servidor iniciado em " + ADDRESS + ":" + PORT);
        clientConnectionLoop(); // Inicia o loop de conexão com clientes.
    }

    /**
     * Loop principal que aceita conexões de clientes e cria uma thread separada para cada conexão.
     *
     * @throws IOException se ocorrer um erro ao aceitar a conexão.
     */
    private void clientConnectionLoop() throws IOException {
        System.out.println("Aguardando conexão de um cliente!");
        do {
            // Aceita a conexão de um cliente e cria um objeto ClientSocket para gerenciar a comunicação.
            ClientSocket clientSocket = new ClientSocket(serverSocket.accept());
            
            // Cria uma nova thread para gerenciar a comunicação com o cliente conectado.
            new Thread(() -> clientMessageLoop(clientSocket)).start();
        } while (true); // Continua aceitando conexões indefinidamente.
    }

    /**
     * Método que gerencia o loop de mensagens para um cliente específico.
     * Lê mensagens enviadas pelo cliente e as imprime no console.
     * Finaliza a conexão se o cliente enviar a mensagem "sair".
     *
     * @param clientSocket o socket do cliente conectado.
     */
    public void clientMessageLoop(ClientSocket clientSocket) {
        String msg;
        try {
            // Lê mensagens do cliente enquanto não for nulo e não for a mensagem "sair".
            while ((msg = clientSocket.getMessage()) != null && !msg.equals("sair")) {
                System.out.printf("Mensagem recebida do cliente %s: %s\n", clientSocket.getRemoteSocketAddress(), msg);
            }
        } finally {
            clientSocket.close(); // Fecha o socket do cliente ao final da comunicação.
        }
    }

    /**
     * Método principal do programa.
     * Inicia o servidor e gerencia possíveis exceções ao inicializar o socket.
     *
     * @param args argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Console Servidor");
        try {
            Server server = new Server(); // Cria uma instância do servidor.
            server.start(); // Inicia o servidor.
        } catch (IOException e) {
            // Trata erros de inicialização do servidor.
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
        System.out.println("Servidor finalizado!");
    }
}

/*
 * Resumo do funcionamento:
 * - A classe Server inicia um servidor que aguarda conexões de clientes na porta especificada.
 * - Cada cliente conectado é gerenciado por uma thread separada, permitindo comunicação simultânea.
 * - O método clientMessageLoop() processa as mensagens enviadas por cada cliente.
 * - Se o cliente enviar "sair", sua conexão é encerrada.
 * - A aplicação pode ser usada para criar um sistema simples de chat ou troca de mensagens.
 */
