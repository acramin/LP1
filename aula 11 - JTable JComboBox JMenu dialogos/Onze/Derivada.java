import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Derivada extends JFrame{
    
    public Derivada(Vetor v){

        String derivada;
        double max = v.getElemento(0);
        double min = v.getElemento(0);
        double sum = v.getElemento(0);

        for (int i = 1; i < v.getTamanho(); i++) {
            double value = v.getElemento(i);
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
            sum += value;
        }

        double media = sum / v.getTamanho();

        if (v.getTamanho() > 1) {
            derivada = "f'(x) = " + (max - media) / ( max - min );
        } else {
            derivada = "Undefined (vector too small)";
        }
        JOptionPane.showMessageDialog(null, derivada);
    }

}
