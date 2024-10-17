package aula20;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SimpleClientTest {   // COM INTERFACE GRAFICA


    // Crianndo a variavel de conexao com o servidor
    private static Socket cliente; // Comunicacao com o servidor

    public static void main(String[] args) {
        try {
            String msg;
            iniciaCliente(); // cria cleinte e inicia conexao
            System.out.println("Mensagem para o servidor: ");
            do {
                msg = JOptionPane.showInputDialog(null, "Digite a mensagem (ou <sair> para encerrar)");
                if (!msg.equals("sair")) {
                    System.out.println(msg);
                    enviarMensagem(msg); 
                }
            } while (!msg.equals("sair"));
            System.out.println("Clinete se desconectou do servidor!");
        } catch (Exception e) {
            System.out.println("Falha na comunicacao: " + e.getMessage());
        }
    }

    private static void iniciaCliente() throws IOException {
        // Cria un cliente com IP e Porta para a comunicacao com o servidor
        cliente = new Socket(SimpleServerTest.ENDERECO, SimpleServerTest.PORTA);
        System.out.println("cliente: " +  SimpleServerTest.ENDERECO 
                            + " conectado ao servidor na porta "
                            + SimpleServerTest.PORTA);
    }

    private static void enviarMensagem(String msg) throws IOException {
        // Objeto para enciar mensagem ao servidor
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        // Envia mensagem ao servidor
        saida.println(msg);
    }
}
