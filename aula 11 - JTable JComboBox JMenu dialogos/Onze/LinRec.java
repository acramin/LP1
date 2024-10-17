
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LinRec extends JFrame{
    
    JPanel lin;
    JButton bProcurar;
    JTextField campo;
    JLabel texto;


    public LinRec(Vetor v){
        super("Busca Linear Recursiva");

        lin = new JPanel();
        bProcurar = new JButton("Procurar");
        campo = new JTextField(10);
        texto = new JLabel("Qual valor dejesa procurar?");

        lin.add(texto);
        lin.add(campo);
        lin.add(bProcurar);

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
                        int id = linRec(aux, t, proc);
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
        add(lin);
        
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
    
    static int linRec(double arr[], int size, double key)
    {
        if (size == 0) {
            return -1;
        }
        else if (arr[size - 1] == key) {
            return size - 1;
        }
        return linRec(arr, size - 1, key);
    } // https://www.geeksforgeeks.org/recursive-c-program-linearly-search-element-given-array/ 

    /*public static void main(String[] args) {
        Vetor v = new Vetor(7);
        
        for(int i = 0; i < v.getTamanho(); i++){
            v.setElemento(i, v.getTamanho() - i);
        }
        new Apresenta(v);
        new LinRec(v);
    }*/

}
