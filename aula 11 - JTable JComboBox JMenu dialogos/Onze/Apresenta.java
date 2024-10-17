
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Apresenta extends JFrame{
    
    public Apresenta(Vetor v){
        super("Exibe Vetor");
        
        String msg = "" + v.getElemento(0);
        for(int i = 1; i < v.getTamanho(); i++){
            msg =  msg +  "     " + v.getElemento(i);
        }

        JOptionPane.showMessageDialog(null, "Vetor = [ " + msg + " ]");

    }

    /*public static void main(String[] args) {
        Vetor v = new Vetor(5);
        for(int i =0; i< v.getTamanho() ; i ++){
            v.setElemento(i, i);
        }
        new Apresenta(v);
    }*/

}
