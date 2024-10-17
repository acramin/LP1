import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

public class SenhaWindow extends JFrame {
    private JLabel passwordText;
    private JPasswordField passwordField;
    private JButton button1, button2;
    public String user;

    public SenhaWindow(String usuario) {
        super("Login");
        user = usuario; 
        passwordText = new JLabel("Nova Senha:");
        passwordField = new JPasswordField(15);
        button1 = new JButton("Prosseguir");
        button2 = new JButton("Sair");

        setLayout(new GridLayout(3, 2, 10, 10));
        add(passwordText);
        add(passwordField);
        add(button1);
        add(button2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null); 

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void handleLogin() {
        String password = new String(passwordField.getPassword());
        Connection conn = Conexao.getConn();
        Login sla = new Login(user, password);
        JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
        sla.alterar(conn);
        dispose();
    }
}
