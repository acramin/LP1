package exemplo2;
// Demonstrando a classe JTextField 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame{
    private JTextField textField1; // campo de texto com tamanho
    private JTextField textField2; // campo de texto com texto
    private JTextField textField3; // campo de texto com texto e tamanho
    private JPasswordField passwordField; // campo senha com texto

    public TextFieldFrame(){
        super("JTextField e JPasswordField");
        setLayout(new FlowLayout()); // configura o layout do frame

        //  campo de texto com 10 colunas
        textField1 = new JTextField(10);
        add(textField1); // adiciona textField1 ao JFrame

        //  campo de texto com texto default
        textField2 = new JTextField("Entre com o texto aqui");
        add(textField2); // adiciona textField2 ao JFrame

        //  campo de texto com texto padrão e 21 colunas
        textField3 = new JTextField("Campo de texto não editável", 21);
        textField3.setEditable(false); // desativa a edição
        add(textField3); // adiciona textField3 ao JFrame

        // constrói o campo de senha com texto padrão
        passwordField = new JPasswordField("Texto oculto");
        add(passwordField); // adiciona passwordField ao JFrame

        // manipuladores de evento
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);
    }

    private class TextFieldHandler implements ActionListener{
        // processa eventos de campo de texto
        public void actionPerformed(ActionEvent event){
            String string = ""; // declara a string a ser exibida

            // o usuário pressionou Enter no JTextField textField1
            if(event.getSource() == textField1)
                string = String.format("textField1: %s", event.getActionCommand());
            // o usuário pressionou Enter no JTextField textField2
            else if(event.getSource() == textField2)
                string = String.format("textField2: %s", event.getActionCommand());
            // o usuário pressionou Enter no JTextField textField3
            else if(event.getSource() == textField3)
                string = String.format("textField3: %s", event.getActionCommand());
            // o usuário pressionou Enter no JTextField passwordField
            else if(event.getSource() == passwordField)
                string = String.format("passwordField: %s", event.getActionCommand());

            // exibe o conteúdo do JTextField
            JOptionPane.showMessageDialog(null, string);
        }
    }
}
