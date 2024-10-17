import javax.swing.JFrame;


public class Insercao extends JFrame {
    
    public Insercao(Vetor v){
        super("Inserção / Inserction Sort");

        // inserction
        insertionSort(v);
        
    }

    private void insertionSort(Vetor v) {
        int t = v.getTamanho();
        for (int i = 1; i < t; ++i) {
            double key = v.getElemento(i);
            int j = i - 1;

            while (j >= 0 && v.getElemento(j) > key) {
                v.setElemento(j + 1, v.getElemento(j));
                j = j - 1;
            }
            v.setElemento(j + 1, key);
        }
    }

    /*void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    } */ // https://www.sortvisualizer.com/insertionsort/ 

}
