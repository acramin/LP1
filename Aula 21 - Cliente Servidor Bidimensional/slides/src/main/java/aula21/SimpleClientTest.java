package aula21;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SimpleClientTest {
    // Criando a variavel de conexao do tipo Socket
    private static Socket cliente;
    private static Scanner entrada;
    private static PrintStream saida;

    public static void main(String[] args) {
        System.out.println("*v*v*v* Console do Cliente *v*v*v*");
        try {
            // Criar Cliente e inicia conexao com Servidor via Socket
            iniciaCliente();
            // Conversa com o Servidor ate solicitar encerramento de comunicao
            conversaComServidor();
            // Encerra conexao com Servidor via Socket
            encerraCliente();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void iniciaCliente() throws IOException {
        // Cria Cliente com IP e Porta para comunicacao com Servidor via Socket
        cliente = new Socket(SimpleServerTest.ENDERECO, SimpleServerTest.PORT);
        System.out.println("Cliente IP " +
            SimpleServerTest.ENDERECO +
            " Porta " + SimpleServerTest.PORT);
        // Obtem a entrada do canal (socket)
        entrada = new Scanner(cliente.getInputStream());
    }

    private static void conversaComServidor() throws IOException {
        String msg, echo = "";
        // Conversa com o Servidor ate solicitar encerramento de comunicao
        do{
            System.out.println("Digite na Entrada a mensagem para o Servidor!");
            msg = JOptionPane.showInputDialog("Digite na Entrada a mensagem para o Servidor (ou <sair> para encerrar)");
            if(!msg.equalsIgnoreCase("sair")){
                enviarMensagemServidor(msg);
                echo = leMensagemServidor();
                verificaComunicacao(echo, msg);
            }
        }while(!msg.equalsIgnoreCase("sair"));
    }

    private static void enviarMensagemServidor(String msg) throws IOException {
        // Objeto para enviar mensagem ao servidor
        saida = new PrintStream(cliente.getOutputStream());
        // Envia mensagem ao servidor
        saida.println(msg);
        System.out.println("Mensagem enviada ao Servidor: " + msg);
    }

    private static String leMensagemServidor() throws IOException {
        String msg = entrada.nextLine(); // Le mensagem do servidor
        System.out.println("Ecoou do Servidor: " + msg); // Impressao da mensagem ecoada
        return msg;
    }

    private static void verificaComunicacao(String echo, String msg) {
        // Verifica se a mensagem ecoada do Servidor e igual a mensagem enviada
        if(echo.equals(msg)){
            System.out.println("Comunicacao com Servidor OK!");
        } else {
            System.out.println("Comunicacao com Servidor NOK!");
        }
    }

    private static void encerraCliente() throws IOException {
        System.out.println("Cliente se desconectou");
        System.out.println("Cliente finalizado");
    }
}
