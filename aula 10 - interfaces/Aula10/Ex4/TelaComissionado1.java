package Ex4;

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

public class TelaComissionado1 extends JFrame implements ActionListener {

    Container tela;
    JButton bVoltar, bCalcula, bLimpar;
    JTextField cNome, cSalario, cCPF, cComissao;
    JLabel lNome, lSalario, lCPF, lComissao;

    public TelaComissionado1() {
        super("Comissionado");

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

        cNome = new JTextField("",30);
        cCPF = new JTextField("",30);
        cSalario = new JTextField(30);
        cComissao = new JTextField(30);
        lNome = new JLabel("Nome completo: ");
        lCPF = new JLabel("Cpf: ");
        lSalario = new JLabel("Salario: ");
        lComissao = new JLabel("Comissão: ");

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

        cComissao.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) &&  c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignora a tecla pressionada se não for um dígito
                }
            }

            public void keyPressed(KeyEvent e) {}

            public void keyReleased(KeyEvent e) {}
        });

        cSalario.addKeyListener(new KeyListener() {
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
        info.add(lSalario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        info.add(cSalario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        info.add(lComissao, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        info.add(cComissao, gbc);

        tela.add(info, BorderLayout.CENTER);

        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bVoltar) {
            new Tela1();
            this.dispose();
        }
        if (e.getSource() == bLimpar) {
            cNome.setText("");
            cCPF.setText("");
            cSalario.setText("");
            cComissao.setText("");
        }
        if (e.getSource() == bCalcula) {

        String n = cNome.getText();
        String f = cCPF.getText();
        double s = Double.parseDouble(cSalario.getText());
        double c = Double.parseDouble(cComissao.getText());
        Comissionado1 m = new Comissionado1(n, "", f, s, c);

            m.setNome(cNome.getText());
            JOptionPane.showMessageDialog(null, "Dados \nNome:" + m.getNome() + "\nCPF: "
                    + m.getCpf() + "\nSalario: " + m.salario());
        }
    }
}
