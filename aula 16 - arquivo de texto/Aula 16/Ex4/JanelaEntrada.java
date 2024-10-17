package Ex4;

import javax.swing.*;
import java.awt.*;

public class JanelaEntrada extends JFrame{
    private JLabel Ra;
    private JTextField textFieldRa;
    private JButton validar;

    public JanelaEntrada() {
        super("Entrada");

        Ra = new JLabel("RA:");
        textFieldRa = new JTextField(15);
        validar = new JButton("Validar");

        // Painel para RA e textFieldRa
        JPanel panelDados = new JPanel();
        panelDados.setLayout(new GridLayout(1, 1, 10, 10));
        panelDados.add(Ra);
        panelDados.add(textFieldRa);

        // Painel para o botão validar
        JPanel panelBotao = new JPanel();
        panelBotao.add(validar);

        // Configura o layout principal
        setLayout(new BorderLayout());
        add(panelDados, BorderLayout.CENTER);
        add(panelBotao, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

        validar.addActionListener(e -> {
            handleEntrada();
        });
    }

    private void handleEntrada() {
        LerArqUser ler = new LerArqUser();
        ler.openFile();
        ler.readRecords(textFieldRa.getText());
        ler.closeFile();
        textFieldRa.setText("");
    }
}
