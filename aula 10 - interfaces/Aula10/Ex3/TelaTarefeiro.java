package Ex3;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaTarefeiro extends JFrame implements ActionListener {

    Container tela;
    JButton bVoltar, bCalcula, bLimpar;
    JTextField cNome, cTarefas, cCPF, cPreco;
    JLabel lNome, lTarefa, lCPF, lPreco;

    public TelaTarefeiro() {
        super("Tarefeiro");

        tela = getContentPane();
        tela.setLayout(new BorderLayout());

        // Botoes
        bVoltar = new JButton("Voltar");
        bCalcula = new JButton("Calcular Salário");
        bLimpar = new JButton("Limpar");

        // Acoes
        bVoltar.addActionListener(this);
        bCalcula.addActionListener(this);
        bLimpar.addActionListener(this);

        // Menu inferior
        JPanel menu = new JPanel(new GridLayout(1, 3));
        menu.add(bVoltar);
        menu.add(bCalcula);
        menu.add(bLimpar);
        tela.add(menu, BorderLayout.SOUTH);

        cNome = new JTextField("",40);
        cCPF = new JTextField("",40);
        cTarefas = new JTextField(40);
        cPreco = new JTextField(40);
        lNome = new JLabel("Nome completo: ");
        lCPF = new JLabel("Cpf: ");
        lTarefa = new JLabel("Quantidade de Tarefas: ");
        lPreco = new JLabel("Preço por Tarefa: ");

        cCPF.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '-' && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignora a tecla pressionada se não for um dígito
                }
            }

            public void keyPressed(KeyEvent e) {}

            public void keyReleased(KeyEvent e) {}
        });

        cPreco.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) &&  c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignora a tecla pressionada se não for um dígito
                }
            }

            public void keyPressed(KeyEvent e) {}

            public void keyReleased(KeyEvent e) {}
        });

        cTarefas.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((!Character.isDigit(c)) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignora a tecla pressionada se não for um dígito
                }
            }

            public void keyPressed(KeyEvent e) {}

            public void keyReleased(KeyEvent e) {}
        });

        JPanel info = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        info.add(lNome, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        info.add(cNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        info.add(lCPF, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        info.add(cCPF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        info.add(lTarefa, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        info.add(cTarefas, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        info.add(lPreco, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        info.add(cPreco, gbc);

        tela.add(info, BorderLayout.CENTER);

        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bVoltar) {
            new Tela();
            this.dispose();
        }
        if (e.getSource() == bLimpar) {
            cNome.setText("");
            cCPF.setText("");
            cTarefas.setText("");
            cPreco.setText("");
        }
        if (e.getSource() == bCalcula) {

        String n = cNome.getText();
        double t = Double.parseDouble(cTarefas.getText());
        int p = Integer.parseInt(cPreco.getText());
        Tarefeiro m = new Tarefeiro(n, t , p);

            m.setNome(cNome.getText());
            JOptionPane.showMessageDialog(null, "Dados \nNome:" + m.getNome() + "\nCPF: "
                    + cCPF.getText() + "\nSalario: " + m.salario());
        }
    }
}
