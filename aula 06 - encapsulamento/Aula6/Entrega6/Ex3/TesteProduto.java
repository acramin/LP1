package Entrega6.Ex3;

import javax.swing.JOptionPane;

public class TesteProduto {
    public static void main(String[] args) {
     
        String nome = JOptionPane.showInputDialog("Nome do prdouto: ");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço: "));
        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto: "));

        Produto produto = new Produto(nome, preco, qtd);

        String msg = "Nome: " + produto.getNome() + "\nPreço: R$  " + produto.getPreco() + "\nQuantidade do produto: " + produto.getQtd();

        JOptionPane.showMessageDialog(null, msg);
    }
    
}