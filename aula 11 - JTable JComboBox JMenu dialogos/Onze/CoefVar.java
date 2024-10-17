import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CoefVar extends JFrame {
    

    public CoefVar(Vetor v){
        super("Coeficiente de Variação");

        int t = v.getTamanho();

        // parte 1
        double[] aux = new double[t];
        for(int i = 0; i < t; i++){
            aux[i] = v.getElemento(i);
        }
        Arrays.sort(aux);

        // parte 2
        double sum = 0;
        double med = 0;
        for(int i = 0; i < t; i++) {
            sum += v.getElemento(i);
        }
        med = sum / t;

        // parte 3
        double quad = 0;
        for(int i = 0; i < t; i ++){
            quad += Math.pow(v.getElemento(i) - med, 2);
        }
        double var = quad / (t - 1);
        double desvPad = Math.sqrt(var);

        // parte 4
        double coefVar = (desvPad/med )* 100;
        JOptionPane.showMessageDialog(null,"Coeficinte de variação: "  + coefVar);
    }
}
