package aula20;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.*;

public class SimpleClientTestGUI extends JFrame {
    
    // Crianndo a variavel de conexao com o servidor
    private static Socket cliente; // Comunicacao com o servidor

    public static void main(String[] args) {
        
        try {
            iniciaCliente(); // cria cleinte e inicia conexao
            new SimpleClientTestGUI().GUI();
            System.out.println("Mensagem para o servidor: ");
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

        tStatus = new JTextField("Aguardando mensagem...");
        tStatus.setBounds(120, 40, 150, 20);
        tStatus.setEditable(false);
        add(tStatus);

        enviar = new JButton("Enviar");
        enviar.setBounds(10, 70, 100, 20);
        add(enviar);

        enviar.addActionListener(e -> {
            try {
                String msg = tMensagem.getText();
                if (!msg.equals("sair")) {
                    enviarMensagem(msg);
                    System.out.println(msg);
                    tStatus.setText("Mensagem enviada!");
                } else {
                    System.out.println("Clinete se desconectou do servidor!");
                    enviarMensagem(msg);
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
        sair.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
