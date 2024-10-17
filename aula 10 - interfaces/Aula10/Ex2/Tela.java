package Ex2;

// importações gráficas
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener {
    
    private JButton bTicTac, bHora, bMinuto;
    private JLabel lHorario;

    Relogio r = new Relogio();

    public Tela(){
        super("Relógio");

        Container tela = getContentPane();
        tela.setLayout(new BorderLayout());

        lHorario = new JLabel(r.mostra());
        bTicTac = new JButton("Tic-Tac");
        bHora = new JButton("Hora");
        bMinuto = new JButton("Minuto");
        
        Font fonteR = new Font("Times New Roman", Font.BOLD, 60);
        lHorario.setFont(fonteR);
        lHorario.setForeground(Color.ORANGE);

        Font fonteB = new Font("Times New Roman", Font.ITALIC, 17);
        bTicTac.setFont(fonteB);
        bHora.setFont(fonteB);
        bMinuto.setFont(fonteB);

        JPanel painelIterativo = new JPanel(new GridLayout(1,3));
        painelIterativo.add(bTicTac);
        painelIterativo.add(bHora);
        painelIterativo.add(bMinuto);
        painelIterativo.setBackground(Color.GRAY);

        JPanel painelMostrador = new JPanel(new FlowLayout());
        painelMostrador.add(lHorario);
        painelMostrador.setBackground(Color.GRAY); 

        bHora.addActionListener(this);
        bMinuto.addActionListener(this);
        bTicTac.addActionListener(this);

        tela.add(painelMostrador, BorderLayout.CENTER);
        tela.add(painelIterativo, BorderLayout.SOUTH);
        setSize(300, 150); // tamanho original em pixel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // modo de saóda
        setLocationRelativeTo(null); // cenntraliza frame
        setVisible(true); // mostra a tela

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bTicTac){
            r.ticTac();
            lHorario.setText(r.mostra());
        }

        else if(e.getSource() == bHora){
            r.hora.incrementa();
            r.atualizaMostrador();
            lHorario.setText(r.mostra());
        }

        else if(e.getSource() == bMinuto){
            r.minuto.incrementa();
            r.atualizaMostrador();
            lHorario.setText(r.mostra());
        }
    }
}
