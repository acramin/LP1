import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

public class LoginWindow extends JFrame {
    private JLabel loginText, passwordText;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button1, button2;

    public LoginWindow() {
        super("Login");

        loginText = new JLabel("Login:");
        passwordText = new JLabel("Senha:");
        textField = new JTextField(15);
        passwordField = new JPasswordField(15);
        button1 = new JButton("Prosseguir");
        button2 = new JButton("Sair");

        setLayout(new GridLayout(3, 2, 10, 10));
        add(loginText);
        add(textField);
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
        String username = textField.getText();
        String password = new String(passwordField.getPassword());
        //JOptionPane.showMessageDialog(this, "Username: " + username + "\nPassword: " + password, "Login Information", JOptionPane.INFORMATION_MESSAGE);
        Login sla = new Login(username, password);
        Connection conn = Conexao.getConn();
        System.out.println(sla.usuario);
        System.out.println(sla.senha);

        sla.carregar(conn);
        System.out.println(password);
        System.out.println(sla.senha);
        if(sla.senha.equals(password)){
            username = sla.usuario;
            password = sla.senha;
            new App("Calculadora", sla.usuario);
            dispose();
        }
    }
}
