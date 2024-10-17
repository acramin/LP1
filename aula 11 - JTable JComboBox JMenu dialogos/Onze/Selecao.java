import javax.swing.JFrame;

public class Selecao extends JFrame {
    
    public Selecao(Vetor v){
        super("Seleção / Selection Sort");
        // selection
        selectionSort(v);
    }

    private void selectionSort(Vetor v) {
        int t = v.getTamanho();
        for (int i = 0; i < t - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < t; j++) {
                if (v.getElemento(j) < v.getElemento(min_idx)) {
                    min_idx = j;
                }
            }
            double temp = v.getElemento(min_idx);
            v.setElemento(min_idx, v.getElemento(i));
            v.setElemento(i, temp);
        }
    }



    /*void selectionSort(int arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    } */ // https://www.sortvisualizer.com/selectionsort/ 


}
