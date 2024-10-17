import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dimensiona extends JFrame {
    
    JPanel dim;
    JButton bSalvar;
    JTextField campo;
    JLabel texto;

    public Dimensiona(Vetor v){
        super("Dimensiona");
        
        dim = new JPanel();
        bSalvar = new JButton("Salvar");
        campo = new JTextField(10);
        texto = new JLabel("Digite o tamanho do vetor: ");

        dim.add(texto);
        dim.add(campo);
        dim.add(bSalvar);

        bSalvar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int tamanho = Integer.parseInt(campo.getText());
                    v.setTamanho(tamanho);
                    JOptionPane.showMessageDialog(null, "Vetor de tamanho " + tamanho + " foi criado.");
                    campo.setText("");
                    setVisible(false);
                }
            }
        );

        add(dim);
        
        setSize(500, 200);
        setVisible(true);
    }

    /*public static void main(String[] args) {
        Vetor v = new Vetor(0);
        new Dimensiona(v);
    }*/
}
