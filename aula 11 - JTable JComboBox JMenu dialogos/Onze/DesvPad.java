import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DesvPad extends JFrame{
    
    public DesvPad(Vetor v){
        super("Desvio Padrão");

        // parte 1
        double sum = 0;
        double med = 0;
        for(int i = 0; i < v.getTamanho(); i++) {
            sum += v.getElemento(i);
        }
        med = sum / v.getTamanho();

        //parte 2
        double quad = 0;
        for(int i = 0; i < v.getTamanho(); i ++){
            quad += Math.pow(v.getElemento(i) - med, 2);
        }
        double var = quad / (v.getTamanho() - 1);
        double desvPad = Math.sqrt(var);

        JOptionPane.showMessageDialog(null, "Desvio Padrão: " + desvPad);
    }

}
