import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BinRec extends JFrame {
    JPanel bin;
    JButton bProcurar;
    JTextField campo;
    JLabel texto;


    public BinRec(Vetor v){
        super("Busca Binária Recursiva");

        bin = new JPanel();
        bProcurar = new JButton("Procurar");
        campo = new JTextField(10);
        texto = new JLabel("Qual valor dejesa procurar?");

        bin.add(texto);
        bin.add(campo);
        bin.add(bProcurar);

        bProcurar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        //busca
                        double proc = Double.parseDouble(campo.getText());
                        int t = v.getTamanho();

                        // parte 1
                        double[] aux = new double[t];
                        for(int i = 0; i < t; i++){
                            aux[i] = v.getElemento(i);
                        }
                        // parte 2
                        int id = binRec(aux, 0,t,proc);
                        if(id == -1){
                            JOptionPane.showMessageDialog(null, "Valor não encontrado.");
                        }else{
                            JOptionPane.showMessageDialog(null, "Vetor = [" + str(v) + "]\n" + "Valor encontrado na posição " + id);
                        }
                    campo.setText("");
                    setVisible(false);
                }
            }
        );
        add(bin);
        
        setSize(500, 200);
        setVisible(true);
    }

    private String str(Vetor v){
        String msg = "" + v.getElemento(0);
        for(int i = 1; i < v.getTamanho(); i++){
            msg =  msg +  "     " + v.getElemento(i);
        }
        return msg;
    }

    int binRec(double arr[], int low, int high, double x)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binRec(arr, low, mid - 1, x);
            return binRec(arr, mid + 1, high, x);
        }
        return -1;
    }
 // https://www.geeksforgeeks.org/binary-search/

    /*public static void main(String[] args) {
        Vetor v = new Vetor(7);
        
        for(int i = 0; i < v.getTamanho(); i++){
            v.setElemento(i, v.getTamanho() - i);
        }
        new Apresenta(v);
        new BinRec(v);
    }*/
}
