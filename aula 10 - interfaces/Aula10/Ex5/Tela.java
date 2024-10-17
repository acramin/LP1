package Ex5;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener {
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, // numéricos
            bMais, bMenos, bDivide, bMultiplica, bIgual, bLimpa; // ação

    private JTextField campoResposta; // resposta

    private String anterior = "";

    private Calculadora c = new Calculadora();

    public Tela() {
        super("Calculadora");

        Container tela = getContentPane();
        tela.setLayout(new BorderLayout());

        campoResposta = new JTextField("0", 20);
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bMais = new JButton("+");
        bMenos = new JButton("-");
        bDivide = new JButton("/");
        bMultiplica = new JButton("*");
        bIgual = new JButton("=");
        bLimpa = new JButton("C");

        campoResposta.setEditable(false);
        campoResposta.setHorizontalAlignment(JTextField.RIGHT);
        Font fonteL = new Font("Times New Roman", Font.BOLD, 15);
        campoResposta.setFont(fonteL);

        JPanel painelResposta = new JPanel(new FlowLayout());
        painelResposta.add(campoResposta);
        
        JPanel painelCalculadora = new JPanel(new GridLayout(4, 4));
        painelCalculadora.add(b7);
        painelCalculadora.add(b8);
        painelCalculadora.add(b9);
        painelCalculadora.add(bMais);
        painelCalculadora.add(b4);
        painelCalculadora.add(b5);
        painelCalculadora.add(b6);
        painelCalculadora.add(bMenos);
        painelCalculadora.add(b1);
        painelCalculadora.add(b2);
        painelCalculadora.add(b3);
        painelCalculadora.add(bMultiplica);
        painelCalculadora.add(b0);
        painelCalculadora.add(bLimpa);
        painelCalculadora.add(bIgual);
        painelCalculadora.add(bDivide);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bMais.addActionListener(this);
        bMenos.addActionListener(this);
        bMultiplica.addActionListener(this);
        bDivide.addActionListener(this);
        bIgual.addActionListener(this);
        bLimpa.addActionListener(this);

        tela.add(painelResposta, BorderLayout.NORTH);
        tela.add(painelCalculadora, BorderLayout.CENTER);
        setSize(275, 175);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == bLimpa){
            campoResposta.setText("0");
            return;
        } 

        if(e.getSource() == bMais){
            campoResposta.setText(campoResposta.getText() + " + ");
            anterior = "+";
            return;
        } 

        if (e.getSource() == bMenos){
            campoResposta.setText(campoResposta.getText() + " - ");
            anterior = "-";
            return;
        } 

        if (e.getSource() == bDivide){
            campoResposta.setText(campoResposta.getText() + " / ");
            anterior = "/";
            return;
        } 

        if (e.getSource() == bMultiplica){
            campoResposta.setText(campoResposta.getText() + " * ");
            anterior = "*";
            return;
        }

        if (e.getSource() == bIgual) {
            campoResposta.setText(c.calcularResultado(campoResposta.getText()));
            anterior = "=";
            return;
        }

        if (e.getSource() == b1){
            if (campoResposta.getText().equals("0") || anterior.equals("=")){
                campoResposta.setText("1");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "1");
                return;
            }
        } 
        
        if (e.getSource() == b2){
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("2");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "2");
                return;
            }
        } 

        if (e.getSource() == b3) {
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("3");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "3");
                return;
            }
        }

        if (e.getSource() == b4) {
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("4");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "4");
                return;
            }
        }

        if (e.getSource() == b5) {
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("5");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "5");
                return;
            }
        }

        if (e.getSource() == b6) {
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("6");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "6");
                return;
            }
        }

        if (e.getSource() == b7) {
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("7");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "7");
                return;
            }
        }

        if (e.getSource() == b8) {
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("8");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "8");
                return;
            }
        }

        if (e.getSource() == b9) {
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("9");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "9");
                return;
            }
        }

        if (e.getSource() == b0) {
            if (campoResposta.getText().equals("0")|| anterior.equals("=")){
                campoResposta.setText("0");
                anterior = "";
                return;
            } else {
                campoResposta.setText(campoResposta.getText() + "0");
                return;
            }
        }

    }

}
