import javax.swing.*; // importa a caixinha bonitinha

public class Ex7 {
    public static void main(String[] args) {
        
        // criação de variável, leitura de dados e conversão str -> int
        int m = Integer.parseInt(JOptionPane.showInputDialog("milhar: "));
        int c = Integer.parseInt(JOptionPane.showInputDialog("centena: ")); 
        int d = Integer.parseInt(JOptionPane.showInputDialog("dezena: "));
        int u = Integer.parseInt(JOptionPane.showInputDialog("undiade: "));
          
        // concatenação dos números em uma string
        String num = "" + m + c + d + u;

        // separação de cada caracter da string
        char mC = num.charAt(0);
        char cC = num.charAt(1);
        char dC = num.charAt(2);
        char uC = num.charAt(3);

        // exibição 
        JOptionPane.showMessageDialog(null, "" + mC + cC + dC + uC);
        
    }
}