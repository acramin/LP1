package aula21;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.*;

public class SimpleClientTestGUI extends JFrame {
    
    // Criando a variavel de conexao do tipo Socket
    private static Socket cliente;
    private static Scanner entrada;
    private static PrintStream saida;

    public static void main(String[] args) {
        
        try {
            System.out.println("*v*v*v* Console do Cliente *v*v*v*");
            iniciaCliente(); // cria cleinte e inicia conexao
            new SimpleClientTestGUI().GUI();
        } catch (Exception e) {
            System.out.println("Falha na comunicacao: " + e.getMessage());
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

    private static void conversaComServidor(String msg) throws IOException {
        System.out.println("Digite na Entrada a mensagem para o Servidor!");
        String echo = "";
        // Envia mensagem ao Servidor
        enviarMensagemServidor(msg);
        // Lê a resposta do servidor
        echo = leMensagemServidor();
        // Verifica se a mensagem ecoada pelo servidor é igual à mensagem enviada
        verificaComunicacao(echo, msg);
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

    JButton limpar, sair, enviar;
    JTextField tMensagem, tStatus;
    JLabel lMensagem, lStatus;

    private void GUI() {
        setTitle("Cliente");
        setSize(315, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        lMensagem = new JLabel("Mensagem: ");
        lMensagem.setBounds(10, 10, 100, 20);
        add(lMensagem);

        tMensagem = new JTextField();
        tMensagem.setBounds(120, 10, 150, 20);
        add(tMensagem);

        lStatus = new JLabel("Status: ");
        lStatus.setBounds(10, 40, 100, 20);
        add(lStatus);

        tStatus = new JTextField();
        tStatus.setBounds(120, 40, 150, 20);
        tStatus.setEditable(false);
        add(tStatus);

        enviar = new JButton("Enviar");
        enviar.setBounds(10, 70, 100, 20);
        add(enviar);

        enviar.addActionListener(e -> {
            try {
                String msg = tMensagem.getText();
                if (!msg.equalsIgnoreCase("sair")) {
                    conversaComServidor(msg);
                    tStatus.setText("Mensagem enviada: " + msg);
                } else {
                    enviarMensagemServidor(msg);
                    tStatus.setText("Desconectado!");
                }
            } catch (IOException ex) {
                tStatus.setText("Erro ao enviar mensagem!");
            }
        });

        limpar = new JButton("Limpar");
        limpar.setBounds(120, 70, 100, 20);
        add(limpar);
        limpar.addActionListener(e -> {
            tMensagem.setText("");
            tStatus.setText("Aguardando mensagem...");
        });

        sair = new JButton("Sair");
        sair.setBounds(230, 70, 60, 20);
        add(sair);
        sair.addActionListener(e -> {
            try {
                encerraCliente();
                System.exit(0);
            } catch (IOException ex) {
                tStatus.setText("Erro ao encerrar cliente!");
            }
        });

        setVisible(true);
    }
}
