import javax.swing.*; // importa a caixinha bonitinha

public class Ex5 {
    public static void main(String[] args) {
        
        // criação de variáveis, leitura de dados e conversão str -> double
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso: ")); 
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Altura: ")); 

        // exibe
        JOptionPane.showMessageDialog(null, "Seus dados digitados foram:  " +  peso  + "kg e " + altura + "m.");
        
    }
}