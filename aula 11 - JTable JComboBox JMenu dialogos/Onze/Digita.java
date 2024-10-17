import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Digita extends JFrame {
    
    JPanel dig;
    JButton bProximo;
    JTextField campo;
    JLabel texto;
    int indice = 0; 

    public Digita(Vetor v) {
        super("Digita");

        dig = new JPanel();
        bProximo = new JButton("Próximo");
        campo = new JTextField(10);
        texto = new JLabel("Digite um valor: ");

        dig.add(texto);
        dig.add(campo);
        dig.add(bProximo);

        bProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = campo.getText();
                if (isNumeric(input)) {
                    int val = Integer.parseInt(input);
                    if (indice < v.getTamanho()) {
                        v.setElemento(indice, val);
                        indice++;
                        campo.setText("");

                        if (indice == v.getTamanho()) {
                            bProximo.setEnabled(false);
                            JOptionPane.showMessageDialog(null, "Vetor preenchido");
                            setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Índice fora dos limites do vetor.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
                }
            }
        });

        add(dig);

        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '-') {
                return false;
            }
        }
        return true;
    }

    /*public static void main(String[] args) {
        Vetor v = new Vetor(3);
        new Digita(v);
    }*/
}
