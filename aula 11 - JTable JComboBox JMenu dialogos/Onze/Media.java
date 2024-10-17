import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Media extends JFrame {
    
    public Media(Vetor v) {
        super("Média");

        double sum = 0;
        double med = 0;

        for(int i = 0; i < v.getTamanho(); i++) {
            sum += v.getElemento(i);
        }
        
        med = sum / v.getTamanho();
        JOptionPane.showMessageDialog(null, "Média: " + med);
    }

    /*public static void main(String[] args) {
        Vetor v = new Vetor(3);

        for(int i = 0; i < v.getTamanho(); i++) {
            v.setElemento(i, i);
        }

        new Media(v);
    }*/
}
