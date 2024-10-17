import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;



public class LoginWindow extends JFrame {
    private JLabel loginText, passwordText;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button1, button2;
    private JComboBox<String> languageSelector;

    public LoginWindow() {
        super("Login");

        ResourceBundle messages = LanguageManager.getResourceBundle();

        // ComboBox para selecionar o idioma
        languageSelector = new JComboBox<>(new String[]{"Português", "English"});
        languageSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLanguage(languageSelector.getSelectedIndex());
            }
        });

        // Componentes da interface
        loginText = new JLabel(messages.getString("login"));
        passwordText = new JLabel(messages.getString("password"));
        textField = new JTextField(15);
        passwordField = new JPasswordField(15);
        button1 = new JButton(messages.getString("proceed"));
        button2 = new JButton(messages.getString("exit"));

        // Configuração do layout
        setLayout(new GridLayout(4, 2, 10, 10));
        add(new JLabel("Idioma / Language:"));
        add(languageSelector);
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

        // Ação dos botões
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

    private void updateLanguage(int languageIndex) {
        Locale selectedLocale = (languageIndex == 0) ? new Locale("pt", "BR") : new Locale("en", "US");
        LanguageManager.setCurrentLocale(selectedLocale);
        ResourceBundle messages = LanguageManager.getResourceBundle();

        loginText.setText(messages.getString("login"));
        passwordText.setText(messages.getString("password"));
        button1.setText(messages.getString("proceed"));
        button2.setText(messages.getString("exit"));
    }

    private void handleLogin() {
        String username = textField.getText();
        String password = new String(passwordField.getPassword());

        Login sla = new Login(username, password);
        Connection conn = Conexao.getConn();

        sla.carregar(conn);

        if (sla.senha.equals(password)) {
            username = sla.usuario;
            password = sla.senha;
            new App("Calculadora", sla.usuario);
            dispose();
    }
}}
