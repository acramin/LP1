import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class TelaExemplo extends JFrame implements ActionListener {
    private JButton bt;
    private JTextField tx;
    private JLabel rt;
    private ResourceBundle bn = null;
    private JMenuBar mb;
    private JMenu x;
    private JMenuItem m1, m2, m3, m4;

    public TelaExemplo() {
        bn = ResourceBundle.getBundle("ex1", new Locale("pt", "BR"));
        // Escolhe Layout do contêiner
        Container cx = getContentPane();
        cx.setLayout(new FlowLayout());

        // Instanciação dos objetos
        bt = new JButton(bn.getString("tela1.botao.calcular"));
        rt = new JLabel(bn.getString("tela1.rotulo.valor") + ":");
        tx = new JTextField(10);
        mb = new JMenuBar();

        // create a menu
        x = new JMenu(bn.getString("menu.linguagem"));

        // create menuitems
        m1 = new JMenuItem("Portugues");
        m2 = new JMenuItem("English");
        m3 = new JMenuItem("Française");
        m4 = new JMenuItem("Italiano");
        // add menu items to menu
        x.add(m1);
        x.add(m2);
        x.add(m3);
        x.add(m4);

        mb.add(x);

        setJMenuBar(mb);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        // Inclusão no container
        cx.add(rt);
        cx.add(tx);
        cx.add(bt);

        // Registro no listener dos objetos controlados
        bt.addActionListener(this);

        // Ajustes finais do frame
        setTitle(bn.getString("tela1.titulo"));
        setSize(350, 100);
        setVisible(true);

    }

    // Implementacao do metodo da interface ActionListener
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt){
            if (tx.getText().length() == 0) {
                JOptionPane.showMessageDialog(
                    null,
                    bn.getString("mensagem.valor.nulo"),
                    bn.getString("tela1.erro.titulo"),
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                int n = Integer.parseInt(tx.getText());
                n = n * n;
                tx.setText("" + n);
            }
        }   

        if(e.getSource()==m1){
            bn = ResourceBundle.getBundle("ex1", new Locale("pt", "BR"));
            rt.setText(bn.getString("tela1.rotulo.valor"));
            bt.setText(bn.getString("tela1.botao.calcular"));
            x.setText(bn.getString("menu.linguagem"));
            setTitle(bn.getString("tela1.titulo"));
        }   

        if(e.getSource()==m2){
            bn = ResourceBundle.getBundle("ex1", Locale.US);
            rt.setText(bn.getString("tela1.rotulo.valor"));
            bt.setText(bn.getString("tela1.botao.calcular"));
            x.setText(bn.getString("menu.linguagem"));
            setTitle(bn.getString("tela1.titulo"));
        }  
        if(e.getSource()==m3){
            bn = ResourceBundle.getBundle("ex1", Locale.FRANCE);
            rt.setText(bn.getString("tela1.rotulo.valor"));
            bt.setText(bn.getString("tela1.botao.calcular"));
            x.setText(bn.getString("menu.linguagem"));
            setTitle(bn.getString("tela1.titulo"));
        }  
        if(e.getSource()==m4){
            bn = ResourceBundle.getBundle("ex1", Locale.ITALY);
            rt.setText(bn.getString("tela1.rotulo.valor"));
            bt.setText(bn.getString("tela1.botao.calcular"));
            x.setText(bn.getString("menu.linguagem"));
            setTitle(bn.getString("tela1.titulo"));
        }  
    }

}
