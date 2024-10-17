import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Func extends JFrame {
    
    public Func(Vetor v){
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

        String funcao = "f(x) = " + media + " + " + (max - media)/( max - min ) + "x";
        JOptionPane.showMessageDialog(null, funcao);
    }
}
