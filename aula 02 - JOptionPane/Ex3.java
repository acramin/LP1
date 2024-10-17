import javax.swing.*; // importa a caixinha bonitinha

public class Ex3 {
    public static void main(String[] args) {

        // criação da variável e leitura de dados
        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
        

        // exibe
        JOptionPane.showMessageDialog(null, "O valor do número digitado é: " + num);
        
    }
}