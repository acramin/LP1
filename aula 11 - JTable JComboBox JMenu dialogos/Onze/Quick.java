import javax.swing.JFrame;

public class Quick extends JFrame{
    
    public Quick(Vetor v){
        super("Quick Sort");

        int t = v.getTamanho();

        //quick
        quickSort(v, 0, t - 1);

    }

    private void quickSort(Vetor v, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(v, begin, end);

            quickSort(v, begin, partitionIndex - 1);
            quickSort(v, partitionIndex + 1, end);
        }
    }

    private int partition(Vetor v, int begin, int end) {
        double pivot = v.getElemento(end);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (v.getElemento(j) <= pivot) {
                i++;

                double swapTemp = v.getElemento(i);
                v.setElemento(i, v.getElemento(j));
                v.setElemento(j, swapTemp);
            }
        }

        double swapTemp = v.getElemento(i + 1);
        v.setElemento(i + 1, v.getElemento(end));
        v.setElemento(end, swapTemp);
        return i + 1;
    }// https://www.sortvisualizer.com/quicksort/ 


    /*public static void main(String[] args) {
        Vetor v = new Vetor(7);
        
        for(int i = 0; i < v.getTamanho(); i++){
            v.setElemento(i, v.getTamanho() - i);
        }
        new Selecao(v);
    }*/

}
