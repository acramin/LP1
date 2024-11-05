import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class ClienteBatePapoGUI extends JFrame implements Runnable {
    private SocketCliente clientSocket;
    private JTextArea messageArea;
    private JTextField inputField;
    private JButton sendButton, clearButton, exitButton;

    public ClienteBatePapoGUI() {
        setTitle("Cliente Bate-Papo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        connectToServer();   
    }

    private void initComponents() {
        // Área de exibição de mensagens
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        // Campo de entrada para mensagens
        inputField = new JTextField(30);
        
        // Botões
        sendButton = new JButton("Enviar");
        clearButton = new JButton("Limpar");
        exitButton = new JButton("Sair");

        // Painel inferior com campo de texto e botões
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.add(inputField);
        bottomPanel.add(sendButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(exitButton);

        // Configurando o layout principal
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Adicionando ações aos botões
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageArea.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientSocket.close();
                showMessage("Desconectado do servidor.");
                System.exit(0);
            }
        });

    }

    private void connectToServer() {
        try {
            clientSocket = new SocketCliente(new Socket(ServidorBatePapo.ADRESS, ServidorBatePapo.PORT));
            new Thread(this).start();
            showMessage("Conectado ao servidor.");
        } catch (IOException e) {
            showMessage("Erro: Não foi possível conectar ao servidor.");
        }
    }

    private void sendMessage() {
        String msg = inputField.getText().trim();
        if (!msg.isEmpty()) {
            clientSocket.sendMessage(msg);
            showMessage("Você: " + msg);
            inputField.setText("");
        }
    }

    private void showMessage(String message) {
        messageArea.append(message + "\n");
    }

    @Override
    public void run() {
        String msg;
        while ((msg = clientSocket.getMessage()) != null) {
            showMessage(msg);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteBatePapoGUI clienteGUI = new ClienteBatePapoGUI();
            clienteGUI.setVisible(true);
        });
    }
}