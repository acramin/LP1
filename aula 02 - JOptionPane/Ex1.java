import javax.swing.*; // importa a caixinha bonitinha

public class Ex1 {
    public static void main(String[] args) {

        // criação variáveis + leitura de dados
        String palavra1 = JOptionPane.showInputDialog("palavra 1: "); 
        String palvara2 = JOptionPane.showInputDialog("palavra 2: ");
        String palavra3 = JOptionPane.showInputDialog("palavra 3: ");

        // exibição na ordem digitada
        JOptionPane.showMessageDialog(null, palavra1 + " " + palvara2 + " " + palavra3); // tudo na mesma linha separdo por espaço
        
    }
}