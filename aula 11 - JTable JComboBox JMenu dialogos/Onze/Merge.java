import javax.swing.JFrame;

public class Merge extends JFrame {
    
    public Merge(Vetor v){
        super("Merge Sort");

        int t = v.getTamanho();

        // merge
        sort(v, 0, t - 1);

    }

    private void merge(Vetor v, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = v.getElemento(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = v.getElemento(m + 1 + j);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                v.setElemento(k, L[i]);
                i++;
            } else {
                v.setElemento(k, R[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            v.setElemento(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            v.setElemento(k, R[j]);
            j++;
            k++;
        }
    }

    private void sort(Vetor v, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(v, l, m);
            sort(v, m + 1, r);

            merge(v, l, m, r);
        }
    } // https://www.sortvisualizer.com/mergesort/ 

    /*public static void main(String[] args) {
        Vetor v = new Vetor(10);
        
        for(int i = 0; i < v.getTamanho(); i++){
            v.setElemento(i, v.getTamanho() - i);
        }
        new Selecao(v);
    }*/
}
