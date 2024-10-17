import javax.swing.*; // importa a caixinha bonitinha

public class Ex4 {
    public static void main(String[] args) {

        // criação de variável + leitura de dados
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia [DD]: "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes [MM]: "));
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano [AAAA]: "));

        // exibe data
        if(dia < 10){
            if(mes < 10){
                JOptionPane.showMessageDialog(null, "A data digitada foi 0" + dia + "/0" + mes + "/" + ano );
            } else {
                JOptionPane.showMessageDialog(null, "A data digitada foi 0" + dia + "/" + mes + "/" + ano );
            }
        } else {
            if(mes < 10){
                JOptionPane.showMessageDialog(null, "A data digitada foi " + dia + "/0" + mes + "/" + ano );
            } else {
                JOptionPane.showMessageDialog(null, "A data digitada foi " + dia + "/" + mes + "/" + ano );
            }
        }


        
        
    }
}