package Ex4;

// importações gráficas
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela1 extends JFrame implements ActionListener {
    
    JButton bMensalista, bTarefeito, bHorista, bComissionado, bDesemp;

    public Tela1(){
        super("Empregados");

        Container tela = getContentPane();
        tela.setLayout(new BorderLayout());
        
        // botoes 
        bMensalista = new JButton("Mensalista");
        bComissionado = new JButton("Comissionado");
        bHorista = new JButton("Horista");
        bTarefeito = new JButton("Tarfeiro");
        bDesemp = new JButton("Desempregado");

        // acoes
        bMensalista.addActionListener(this);
        bComissionado.addActionListener(this);
        bHorista.addActionListener(this);
        bTarefeito.addActionListener(this);
        bDesemp.addActionListener(this);

       // tela inicial
        JPanel texto = new JPanel(new FlowLayout());
        texto.add(new JLabel("Selecione"));
        tela.add(texto, BorderLayout.NORTH);
        JPanel menu = new JPanel(new GridLayout(2,2));
        menu.add(bMensalista);
        menu.add(bTarefeito);
        menu.add(bComissionado);
        menu.add(bHorista);
        tela.add(menu, BorderLayout.CENTER);
        JPanel menu1 = new JPanel(new FlowLayout());
        menu1.add(bDesemp);
        tela.add(menu1, BorderLayout.SOUTH);

        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bMensalista) {
            new TelaMensalista1();
            this.dispose();
        }
        if(e.getSource() == bComissionado) {
            new TelaComissionado1();
            this.dispose();
        }
        
        if(e.getSource() == bHorista) {
            new TelaHorista1();
            this.dispose();
        }
        if(e.getSource() == bTarefeito) {
            new TelaTarefeiro1();
            this.dispose();
        }

        if(e.getSource() == bDesemp){
            new TelaDesmpregado1();
            this.dispose();
        }
    }
}
