import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JOptionPane;

public class LinIn extends JFrame{

    JPanel lin;
    JButton bProcurar;
    JTextField campo;
    JLabel texto;


    public LinIn(Vetor v){
        super("Busca Linear Iterativa");

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

                        int id = linIn(aux, t, proc);
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

    private static int linIn(double arr[], int N, double x)
    {
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    } // https://www.geeksforgeeks.org/linear-search/

    /*public static void main(String[] args) {
        Vetor v = new Vetor(7);
        
        for(int i = 0; i < v.getTamanho(); i++){
            v.setElemento(i, v.getTamanho() - i);
        }
        new Apresenta(v);
        new LinIn(v);
    }*/

}
