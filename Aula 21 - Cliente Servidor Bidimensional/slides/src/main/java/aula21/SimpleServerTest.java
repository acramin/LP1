package aula21;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;

public class SimpleServerTest {
    // Especifica endereco do IP para o servidor
    public static final String ENDERECO = "127.0.0.7";
    // Espeficica porta livre do computador para o servidor escutar
    public static final int PORT = 3334;
    
    private static ServerSocket servidor;
    private static Socket clienteAceito;
    private static Scanner entrada;
    private static PrintStream saida;

    public static void main(String[] args){
        System.out.println("*v*v*v* Console do Servidor *v*v*v*");
        try{
            // Inicia servidor e cria servico de escuta por porta via socket
            iniciaServidor();
            // Cria canal de comunicacao para conexao do cliente (servico)
            aguardaConexaoCliente();
            // Escutando e respondendo as mensagens do cliente
            conversaComCliente();
            // Fecha canal de comuicacao da conexao do cliente (servico)
            encerraConexaoCliente();
            // Fecha servico de escuta por porta via socket e encerra servidor
            encerraServidor();
        } catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void iniciaServidor() throws IOException {
        // Cria servico de escuta pelo servidor na porta especificada via socket
        servidor = new ServerSocket(PORT);
        System.out.println("Servidor iniciado na porta " + PORT);
    }

    private static void aguardaConexaoCliente() throws IOException {
        // Cria canal de comunicao para conexao do cliente (servico)
        clienteAceito = servidor.accept();
        // Apresenta endereco do cliente conectado ao servidor
        System.out.println("Cliente IP:" +
            clienteAceito.getInetAddress().getHostAddress() +
            " Porta:" + clienteAceito.getPort());
        // Obtem a entrada do canal (socket)
        entrada = new Scanner(clienteAceito.getInputStream());
        // Objeto para enviar mensagem ao cliente
        saida = new PrintStream(clienteAceito.getOutputStream());        
    }

    private static void conversaComCliente() throws IOException {
        String msg;
        // Escutando as mensagens do cliente que chegam ao servidor
        while (entrada.hasNextLine()) { // Aguarda a proxima mensagem do cliente
            msg = leMensagemCliente(); // Le mensagem do cliente
            retornaMensagemCliente(msg); // Servidor retorna mensagem ao cliente
        }
    }

    private static String leMensagemCliente() throws IOException {
        String msg = entrada.nextLine(); // Le a mensagem do cliente
        System.out.println("Chegou do Cliente: " + msg); // Imprime na tela a mensagem de entrada
        return msg;
    }

    private static void retornaMensagemCliente(String msg) throws IOException {
       // Servidor retorna mensagem ao cliente
        saida.println(msg);
        System.out.println("Ecoou ao Cliente: " + msg); // Imprime na tela a mensagem de saida
    }

    private static void encerraConexaoCliente() throws IOException {
        // Fecha canal de entrada do servidor e o servico de conexao ao servidor
        entrada.close(); // Fecha canal de entrada do servidor
        System.out.println("Cliente se desconectou");
    }

    private static void encerraServidor() throws IOException {
        // Fecha servico de escuta por porta via socket e encerra servidor
        servidor.close();
        System.out.println("Servidor encerrado");
    }
}