package Ex3;

import javax.swing.*;
import java.awt.*;

public class JanelaCadastro extends JFrame{
    private JLabel Ra, Nome, Sobrenome, P1, P2, P3, P4;
    private JTextField textFieldRa, textFieldNome, textFieldSobrenome, textFieldP1, textFieldP2, textFieldP3, textFieldP4;
    private JButton cadastrar;

    public JanelaCadastro() {
        super("Cadastro");

        // Criação dos componentes
        Ra = new JLabel("RA:");
        Nome = new JLabel("Nome:");
        Sobrenome = new JLabel("Sobrenome:");
        P1 = new JLabel("P1:");
        P2 = new JLabel("P2:");
        P3 = new JLabel("P3:");
        P4 = new JLabel("P4:");

        textFieldRa = new JTextField(15);
        textFieldNome = new JTextField(15);
        textFieldSobrenome = new JTextField(15);
        textFieldP1 = new JTextField(15);
        textFieldP2 = new JTextField(15);
        textFieldP3 = new JTextField(15);
        textFieldP4 = new JTextField(15);

        cadastrar = new JButton("Cadastrar");

        // Usando BorderLayout para organizar os componentes
        setLayout(new BorderLayout());

        // Painel para os campos de texto
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.add(Ra);
        panel.add(textFieldRa);
        panel.add(Nome);
        panel.add(textFieldNome);
        panel.add(Sobrenome);
        panel.add(textFieldSobrenome);
        panel.add(P1);
        panel.add(textFieldP1);
        panel.add(P2);
        panel.add(textFieldP2);
        panel.add(P3);
        panel.add(textFieldP3);
        panel.add(P4);
        panel.add(textFieldP4);

        // Adiciona o painel ao centro da tela
        add(panel, BorderLayout.CENTER);

        // Centralizando o botão na parte inferior
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cadastrar);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

        // Ação do botão cadastrar
        cadastrar.addActionListener(e -> {
            handleCadastro();
        });
    }

    private void handleCadastro() {
        Cadastro c  = new Cadastro();
        c.openFile();
        c.addRecords(textFieldRa.getText(), textFieldNome.getText(), 
                    textFieldSobrenome.getText(), textFieldP1.getText(), 
                    textFieldP2.getText(), textFieldP3.getText(), 
                    textFieldP4.getText());
        c.closeFile();

        textFieldRa.setText("");
        textFieldNome.setText("");
        textFieldSobrenome.setText("");
        textFieldP1.setText("");
        textFieldP2.setText("");
        textFieldP3.setText("");
        textFieldP4.setText("");
    }
}
