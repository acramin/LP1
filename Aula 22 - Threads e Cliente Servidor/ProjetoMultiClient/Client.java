package ProjetoMultiClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Classe responsável por implementar o lado cliente da aplicação.
 * Permite enviar mensagens ao servidor por meio de um loop de entrada de mensagens.
 */
public class Client {
    private Socket clientSocket; // Socket utilizado para a conexão com o servidor.
    private Scanner scanner; // Scanner para leitura de mensagens do console.
    private PrintWriter saida; // Stream de saída para envio de mensagens ao servidor.

    /**
     * Construtor da classe Client.
     * Inicializa o scanner para leitura das mensagens do console.
     */
    public Client() {
        scanner = new Scanner(System.in);
    }

    /**
     * Método principal que inicia o cliente.
     * Conecta ao servidor utilizando o endereço e a porta especificados na classe `Server`.
     * Exibe uma mensagem de sucesso ao conectar e entra no loop de mensagens.
     *
     * @throws IOException se ocorrer um erro ao conectar ao servidor.
     */
    public void start() throws IOException {
        clientSocket = new Socket(Server.ADDRESS, Server.PORT); // Conecta ao servidor.
        saida = new PrintWriter(clientSocket.getOutputStream(), true); // Inicializa o stream de saída.
        System.out.println("Cliente " + Server.ADDRESS + ":" + Server.PORT + " conectado!");
        messageLoop(); // Inicia o loop de envio de mensagens.
    }

    /**
     * Loop que lê mensagens do usuário no console e as envia ao servidor.
     * O loop continua até que o usuário digite "sair".
     *
     * @throws IOException se ocorrer um erro durante o envio de mensagens.
     */
    private void messageLoop() throws IOException {
        String msg;
        System.out.println("Aguardando mensagem para enviar ao servidor!");
        do {
            System.out.print("Digite uma mensagem para o servidor ou <sair> para finalizar: ");
            msg = scanner.nextLine(); // Lê a mensagem digitada pelo usuário.
            saida.println(msg); // Envia a mensagem ao servidor.
        } while (!msg.equals("sair")); // Sai do loop quando a mensagem for "sair".
    }

    /**
     * Método principal do programa cliente.
     * Inicia a aplicação cliente e lida com possíveis exceções durante a conexão ou execução.
     *
     * @param args argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Console Cliente");
        try {
            Client client = new Client(); // Cria uma instância do cliente.
            client.start(); // Inicia a conexão com o servidor.
        } catch (IOException e) {
            // Trata erros ao conectar ou iniciar o cliente.
            System.out.println("Erro ao iniciar o cliente: " + e.getMessage());
        }
        System.out.println("Cliente finalizado!");
    }
}

/*
 * Resumo do funcionamento:
 * - A classe Client implementa a lógica de um cliente que envia mensagens ao servidor.
 * - O método start() cria o socket para a conexão e inicializa os streams.
 * - O método messageLoop() permite ao usuário digitar mensagens no console e enviá-las ao servidor.
 * - O loop de mensagens é encerrado quando o usuário digita "sair".
 * - A interação é simples e baseada em texto, ideal para testes de comunicação.
 *
 * Pontos importantes:
 * - Utiliza o mesmo endereço e porta definidos na classe `Server`, garantindo compatibilidade.
 * - O fluxo de mensagens é síncrono (aguarda o usuário digitar antes de enviar).
 * - Caso o servidor não esteja disponível, o cliente exibe uma mensagem de erro.
 */
