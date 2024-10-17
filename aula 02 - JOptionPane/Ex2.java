import javax.swing.*; // importa a caixinha bonitinha

public class Ex2 {
    public static void main(String[] args) {

        // criação variáveis e leitura de dados
        String palavra1 = JOptionPane.showInputDialog("palavra 1: "); 
        String palvara2 = JOptionPane.showInputDialog("palavra 2: ");
        String palavra3 = JOptionPane.showInputDialog("palavra 3: ");

        // exibição na ordem inversa da leitura
        JOptionPane.showMessageDialog(null, palavra3 + " " + palvara2 + " " + palavra1);
        
    }
}