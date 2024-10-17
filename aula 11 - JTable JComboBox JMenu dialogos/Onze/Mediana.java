import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mediana extends JFrame{
    
    public Mediana(Vetor v){
        super("Mediana");

        double m = 0; // mediana
        double[] aux = new double[v.getTamanho()];

        for(int i = 0; i < v.getTamanho(); i++){
            aux[i] = v.getElemento(i);
        }

        Arrays.sort(aux);

        int n = v.getTamanho();
        if(n % 2 == 1){
            m = aux[n/2];
        } else {
            m = (aux[(n / 2) - 1] + aux[n / 2]) / 2;
        }
        JOptionPane.showMessageDialog(null, "Mediana: " + m);

    }
}
