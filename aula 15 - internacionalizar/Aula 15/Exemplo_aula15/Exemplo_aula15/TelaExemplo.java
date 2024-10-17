import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class TelaExemplo extends JFrame implements ActionListener{

    private JButton bt;
    private JLabel rt;
    private JTextField tx;
    private ResourceBundle  bn = null;

    public TelaExemplo(){
        // Menu simples de escolha de idoma
        int op = Integer.parseInt(JOptionPane.showInputDialog(
            "Idioma - Language - Langue - Lingua\n1 - Português\n2 - English\n3 - Française\n4 - Italiano"));

            // Carga dos arquivos de internacionalização
            switch(op){
                case 1:
                    bn = ResourceBundle.getBundle("ex1", new Locale("pt", "BR"));
                    break;
                case 2:
                    bn = ResourceBundle.getBundle("ex1", Locale.US);
                    break;
                case 3:
                    bn = ResourceBundle.getBundle("ex1", Locale.FRANCE);
                    break;
                case 4:
                    bn = ResourceBundle.getBundle("ex1", Locale.ITALY);
                    break;
                default:
                    bn = ResourceBundle.getBundle("ex1");
                    break;
            }

            // Esoclher Layout do Container
            Container c = getContentPane();
            c.setLayout(new FlowLayout());

            // Instanciação dos objetos
            bt = new JButton(bn.getString("tela1.botao.calcular"));
            rt = new JLabel(bn.getString("tela1.rotulo.valor") + ": ");
            tx = new JTextField(10);

            // Inclusão no Container
            c.add(rt);
            c.add(tx);
            c.add(bt);

            // Registro no listener dos objetos
            bt.addActionListener(this);

            // Configuração da janela
            setTitle(bn.getString("tela1.titulo"));
            setSize(350, 100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
    }



    // Implementação do método actionPerformed
    public void actionPerformed(ActionEvent e) {
        if(tx.getText().length() == 0){
            JOptionPane.showMessageDialog(null, bn.getString("mensagem.valor.nulo"), 
            bn.getString("tela1.erro.titulo"), JOptionPane.ERROR_MESSAGE);
        } else {
            int n = Integer.parseInt(tx.getText());
            n = n * n;
            tx.setText("" + n);
        }
    }

    
}