package Ex5;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();

        int op = 0;

        while (op != 6){
            op = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n"
            + "1 - Adicionar caixa\n"
            + "2 - Remover caixa\n"
            + "3 - Procurar caixa\n"
            + "4 - Mudar caixa\n"
            + "5 - Listar caixas mais pesadas que 10.0\n"
            + "6 - Sair"));

            switch (op) {
                case 1:
                    String corredor = JOptionPane.showInputDialog("Digite o corredor: ");
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição: "));
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso: "));
                    String dono = JOptionPane.showInputDialog("Digite o dono: ");
                    deposito.inserirCaixa(new Caixa(corredor, posicao, peso, dono));
                    break;
                case 2:
                    String donoR = JOptionPane.showInputDialog("Digite o dono da caixa a ser removida: ");
                    deposito.removerCaixa(donoR);
                    break;
                case 3:
                    String donoP = JOptionPane.showInputDialog("Digite o dono da caixa que deseja encontrar: ");
                    int posicaoEncotrada = deposito.procurarCaixa(donoP);
                    if (posicaoEncotrada != -1) {
                        JOptionPane.showMessageDialog(null, "Caixa encontrada na posição " + posicaoEncotrada + " da lista.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Caixa não encontrada.");
                    }
                    break;
                case 4:
                    String donoM = JOptionPane.showInputDialog("Digite o dono da caixa a ser modificada: ");
                    String novoCorredor = JOptionPane.showInputDialog("Digite o novo corredor: ");
                    int novaPosicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova posição: "));
                    deposito.mudarCaixa(donoM, novoCorredor, novaPosicao);
                    break;
                case 5:
                    double pesoLimite = 10.0; // peso de teste definido no exercício
                    ArrayList<Caixa> caixasPesadas = deposito.caixaMaisPesadas(pesoLimite);
                    if (caixasPesadas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há caixas mais pesadas que " + pesoLimite);
                    } else {
                        String mensagem = "Caixas mais pesadas que " + pesoLimite + ":\n";
                        for (Caixa caixa : caixasPesadas) {
                            mensagem = "Corredor: " + caixa.getCorredor() + ", Posição: " + caixa.getPosicao() 
                            + ", Peso: " + caixa.getPeso() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Programa encerrado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }    
}
