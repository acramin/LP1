package Ex1;

// importações gráficas
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener {

    private JTextField campoTexto;
    private JButton bMostrar, bLimpar, bSair;
    private JLabel lTexto;

    public Tela() {
        super("Tela"); // Cabeçalho da Janela

        // Criação do Painel
        Container tela = getContentPane();
        tela.setLayout(new FlowLayout()); // gerenciador de Layout

        // Criação dos componentes
        lTexto = new JLabel("Texto:");
        campoTexto = new JTextField(20);
        bMostrar = new JButton("Mostrar");
        bLimpar = new JButton("Limpar");
        bSair = new JButton("Sair");

        // Adiciona os componentes à tela
        // botão aparece na ordem que adiciona
        tela.add(lTexto);
        tela.add(campoTexto);
        tela.add(bMostrar);
        tela.add(bLimpar);
        tela.add(bSair);

        // Adiciona listeners aos botões
        // sabe quando clica em cada botão
        bMostrar.addActionListener(this);
        bLimpar.addActionListener(this);
        bSair.addActionListener(this);

        // Configurações da janela
        setSize(300, 150); // tamanho original em pixel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // modo de saóda
        setLocationRelativeTo(null); // cenntraliza frame
        setVisible(true); // mostra a tela
    }

    public void actionPerformed(ActionEvent e) { // lógica do evento
        if (e.getSource() == bMostrar) { // se clicou no botão mostrar
            String texto = campoTexto.getText(); // pega texto escrito
            JOptionPane.showMessageDialog(this, "Texto digitado: " + texto); // exibe texto em caixa separada
        } else if (e.getSource() == bLimpar) { // se clicou no botão limpar
            campoTexto.setText(""); // substitui texto por nada
        } else if (e.getSource() == bSair) { // se clicou no batão sair
            System.exit(0); // fecha
        }
    }
}
